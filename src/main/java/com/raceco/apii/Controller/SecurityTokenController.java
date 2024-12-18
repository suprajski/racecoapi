package com.raceco.apii.Controller;

import com.raceco.apii.Entity.SecurityToken;
import com.raceco.apii.Service.SecurityTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tokens")
public class SecurityTokenController {
    @Autowired
    private SecurityTokenService securityTokenService;

    @PostMapping
    public ResponseEntity<SecurityToken> createToken(@RequestBody SecurityToken token) {
        return ResponseEntity.ok(securityTokenService.createToken(token));
    }

    @GetMapping("/{token}")
    public ResponseEntity<?> getToken(@PathVariable String token) {
        SecurityToken securityToken = securityTokenService.getToken(token);
        if (securityToken == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(securityToken);
    }

    @DeleteMapping("/expired")
    public ResponseEntity<Void> deleteExpiredTokens() {
        securityTokenService.deleteExpiredTokens();
        return ResponseEntity.noContent().build();
    }
}
