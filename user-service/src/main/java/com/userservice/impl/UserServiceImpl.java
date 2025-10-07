package com.userservice.impl;

import com.userservice.dtos.AuthResponse;
import com.userservice.dtos.LoginRequest;
import com.userservice.dtos.RegisterRequest;
import com.userservice.dtos.UpdateUserRequest;
import com.userservice.entities.User;
import com.userservice.entities.UserSession;
import com.userservice.repositories.UserRepository;
import com.userservice.repositories.UserSessionReporitory;
import com.userservice.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserSessionReporitory userSessionReporitory;
    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;



    public User register(RegisterRequest registerRequest){
        User newCreatedUser=User.builder().username(registerRequest.getUsername()).password(passwordEncoder.encode(registerRequest.getPassword()))
                .email(registerRequest.getEmail()).firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName()).phoneNumber(registerRequest.getPhoneNumber()).build();
        userRepository.save(newCreatedUser);
        return newCreatedUser;
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        Optional<User> userOpt = Optional.ofNullable(userRepository.findByUsername(loginRequest.getNameoremail()));

        if (!userOpt.isPresent()) {
            userOpt = Optional.ofNullable(userRepository.findByEmail(loginRequest.getNameoremail()));
        }
        User user = userOpt.orElseThrow(() -> new IllegalArgumentException("Invalid credentials"));

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid credentials");
        }
        String refreshToken=UUID.randomUUID().toString();
        Instant expiry= Instant.now().plus(Duration.ofMinutes(10));
        UserSession userSession=UserSession.builder()
                .user(user).refreshToken(refreshToken)
                .expiryAt(expiry).createdAt(Instant.now()).build();
        userSessionReporitory.save(userSession);

        return new AuthResponse("101", "Bearer", 60 * 60, null);



    }

    @Override
    public AuthResponse refreshToken(String token)
    {
      UserSession userSession =userSessionReporitory.findByRefreshToken(token);
      if(userSession==null)
          throw new RuntimeException("token is not valid");
      if(userSession.getExpiryAt().isBefore(Instant.now()))
      {
          userSessionReporitory.delete(userSession);
          throw new RuntimeException("token Already exprired");
      }
      User u=userSession.getUser();

        return new AuthResponse("101", "Bearer", 60 * 60, token);
    }

    @Override
    public void logout(String token)
    {
        userSessionReporitory.deleteByRefreshToken(token);
    }
    @Override
    public User updateUser(Long id,UpdateUserRequest r){
        User u=userRepository.findById(id).orElseThrow();
        if (r.getUsername()!=null) u.setUsername(r.getUsername());
        if (r.getEmail()!=null)    u.setEmail(r.getEmail());
        if (r.getFirstName()!=null)u.setFirstName(r.getFirstName());
        if (r.getLastName()!=null) u.setLastName(r.getLastName());
        if (r.getPhoneNumber()!=null) u.setPhoneNumber(r.getPhoneNumber());
       return userRepository.save(u);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + id));
    }

    @Override
    public User getByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User getByName(String authentication)
    {
        return userRepository.findByUsername(authentication);
    }
    @Override
    public User saveUser(User user) {
//        Long id=UUID.randomUUID().;
//        user.setId(id);
      User registeredUser= userRepository.save(user);
//      kafkaTemplate.send(CommonConstant.name,registeredUser);

     return registeredUser;

    }
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
