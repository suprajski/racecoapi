package com.raceco.apii.Repository;

import com.raceco.apii.Entity.SecurityToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SecurityTokenRepository extends JpaRepository<SecurityToken, Long> {
    SecurityToken findByToken(String token);

    void deleteByExpirationTimeBefore(Date currentDate);

}
