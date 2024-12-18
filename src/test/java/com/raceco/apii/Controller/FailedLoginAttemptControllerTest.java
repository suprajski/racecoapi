package com.raceco.apii.Controller;

import com.raceco.apii.Entity.FailedLoginAttempt;
import com.raceco.apii.Entity.User;
import com.raceco.apii.Service.FailedLoginAttemptService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FailedLoginAttemptControllerTest {
    @InjectMocks
    private FailedLoginAttemptController failedLoginAttemptController;

    @Mock
    private FailedLoginAttemptService failedLoginAttemptService;

    @Test
    void testLogAttempt() {
        FailedLoginAttempt attempt = new FailedLoginAttempt();
        User user1 = new User();
        user1.setUserId(1L);
        user1.setEmail("terefere@wp.pl");
        attempt.setAttemptId(1L);
        attempt.setUser(user1);
        attempt.setAttemptTimestamp(new java.util.Date());
        attempt.setIpAddress("192.168.1.1");

        when(failedLoginAttemptService.logAttempt(any(FailedLoginAttempt.class))).thenReturn(attempt);

        ResponseEntity<FailedLoginAttempt> response = failedLoginAttemptController.logAttempt(attempt);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getAttemptId()).isEqualTo(1L);
        assertThat(response.getBody().getUser().getUserId()).isEqualTo(1L);
        assertThat(response.getBody().getIpAddress()).isEqualTo("192.168.1.1");
        verify(failedLoginAttemptService, times(1)).logAttempt(any(FailedLoginAttempt.class));
    }

    @Test
    void testGetAttemptsByUser() {
        FailedLoginAttempt attempt1 = new FailedLoginAttempt();
        User user1 = new User();
        user1.setUserId(1L);
        user1.setEmail("terefere@wp.pl");
        attempt1.setAttemptId(1L);
        attempt1.setUser(user1);
        attempt1.setAttemptTimestamp(new Date(System.currentTimeMillis() - 10 * 60 * 1000));

        FailedLoginAttempt attempt2 = new FailedLoginAttempt();
        User user2 = new User();
        user1.setUserId(2L);
        user1.setEmail("tere2fere@wp.pl");
        attempt2.setAttemptId(2L);
        attempt2.setUser(user2);
        attempt2.setAttemptTimestamp(new Date(System.currentTimeMillis() - 5 * 60 * 1000));

        List<FailedLoginAttempt> attempts = Arrays.asList(attempt1, attempt2);

        when(failedLoginAttemptService.getAttemptsByUser(1L)).thenReturn(attempts);

        ResponseEntity<List<FailedLoginAttempt>> response = failedLoginAttemptController.getAttemptsByUser(1L);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody().get(0).getAttemptId()).isEqualTo(1L);
        assertThat(response.getBody().get(1).getAttemptId()).isEqualTo(2L);
        verify(failedLoginAttemptService, times(1)).getAttemptsByUser(1L);
    }

    @Test
    void testCountAttemptsByUserInRange() {
        when(failedLoginAttemptService.countAttemptsByUserInRange(100L)).thenReturn(3L);

        ResponseEntity<Long> response = failedLoginAttemptController.countAttemptsByUserInRange(100L);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(3L);
        verify(failedLoginAttemptService, times(1)).countAttemptsByUserInRange(100L);
    }
}
