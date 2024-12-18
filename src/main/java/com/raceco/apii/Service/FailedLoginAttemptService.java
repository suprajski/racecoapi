package com.raceco.apii.Service;

import com.raceco.apii.Entity.FailedLoginAttempt;

import java.util.List;

public interface FailedLoginAttemptService {
    FailedLoginAttempt logAttempt(FailedLoginAttempt attempt);
    List<FailedLoginAttempt> getAttemptsByUser(Long userId);
    long countAttemptsByUserInRange(Long userId);
}
