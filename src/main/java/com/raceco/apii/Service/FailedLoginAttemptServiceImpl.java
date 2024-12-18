package com.raceco.apii.Service;

import com.raceco.apii.Entity.FailedLoginAttempt;
import com.raceco.apii.Repository.FailedLoginAttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FailedLoginAttemptServiceImpl implements FailedLoginAttemptService{

    @Autowired
    private FailedLoginAttemptRepository failedLoginAttemptRepository;

    @Override
    public FailedLoginAttempt logAttempt(FailedLoginAttempt attempt) {
        return failedLoginAttemptRepository.save(attempt);
    }

    @Override
    public List<FailedLoginAttempt> getAttemptsByUser(Long userId) {
        return failedLoginAttemptRepository.findByUserUserId(userId);
    }

    @Override
    public long countAttemptsByUserInRange(Long userId) {
        return failedLoginAttemptRepository.countByUserUserIdAndAttemptTimestampBetween(userId,new Date(),new Date());
    }
}
