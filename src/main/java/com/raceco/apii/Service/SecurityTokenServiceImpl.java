package com.raceco.apii.Service;

import com.raceco.apii.Entity.SecurityToken;
import com.raceco.apii.Repository.SecurityTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SecurityTokenServiceImpl implements SecurityTokenService{

    @Autowired
    private SecurityTokenRepository securityTokenRepository;

    @Override
    public SecurityToken createToken(SecurityToken token) {
        return securityTokenRepository.save(token);
    }

    @Override
    public SecurityToken getToken(String token) {
        return securityTokenRepository.findByToken(token);
    }

    @Override
    public void deleteExpiredTokens() {
        securityTokenRepository.deleteByExpirationTimeBefore(new Date());
    }
}
