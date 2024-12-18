package com.raceco.apii.Service;

import com.raceco.apii.Entity.SecurityToken;

public interface SecurityTokenService {
    SecurityToken createToken(SecurityToken token);
    SecurityToken getToken(String token);
    void deleteExpiredTokens();
}
