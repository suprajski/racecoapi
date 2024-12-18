package com.raceco.apii.Repository;

import com.raceco.apii.Entity.FailedLoginAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FailedLoginAttemptRepository extends JpaRepository<FailedLoginAttempt, Long> {
    List<FailedLoginAttempt> findByUserUserId(Long userId);
    long countByUserUserIdAndAttemptTimestampBetween(Long userId, Date start, Date end);
}
