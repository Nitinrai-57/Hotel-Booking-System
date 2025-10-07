package com.userservice.repositories;

import com.userservice.entities.UserSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSessionReporitory extends JpaRepository<UserSession,Long> {
    public UserSession findByRefreshToken(String refreshToken);
    public void deleteByRefreshToken(String refreshToken);

}
