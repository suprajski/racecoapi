package com.raceco.apii.Controller;

import com.raceco.apii.Entity.FailedLoginAttempt;
import com.raceco.apii.Service.FailedLoginAttemptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/failed-login-attempts")
public class FailedLoginAttemptController {
    @Autowired
    private FailedLoginAttemptService failedLoginAttemptService;

    @PostMapping
    public ResponseEntity<FailedLoginAttempt> logAttempt(@RequestBody FailedLoginAttempt attempt) {
        return ResponseEntity.ok(failedLoginAttemptService.logAttempt(attempt));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FailedLoginAttempt>> getAttemptsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(failedLoginAttemptService.getAttemptsByUser(userId));
    }

    @GetMapping("/count/user/{userId}")
    public ResponseEntity<Long> countAttemptsByUserInRange(@PathVariable Long userId) {
        return ResponseEntity.ok(failedLoginAttemptService.countAttemptsByUserInRange(userId));
    }
}
