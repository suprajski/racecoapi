package com.raceco.apii.Controller;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


import com.raceco.apii.Entity.Branch;
import com.raceco.apii.Service.BranchService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BranchControllerTest {

    @Mock
    private BranchService branchService;

    @InjectMocks
    private BranchController branchController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddBranch_Success() {
        // Arrange
        Branch branch = new Branch();
        branch.setCountry("USA");

        when(branchService.addBranch(any(Branch.class))).thenReturn(branch);

        // Act
        ResponseEntity<Branch> response = branchController.addBranch(branch);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody().getCountry()).isEqualTo("USA");
        verify(branchService, times(1)).addBranch(branch);
    }

    @Test
    void testGetBranchById_Success() {
        // Arrange
        Branch branch = new Branch();
        branch.setBranchId(1L);
        branch.setCountry("USA");

        when(branchService.getBranchById(1L)).thenReturn(branch);

        // Act
        ResponseEntity<?> response = branchController.getBranchById(1L);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isInstanceOf(Branch.class);
        assertThat(((Branch) response.getBody()).getCountry()).isEqualTo("USA");
    }

    @Test
    void testGetBranchById_NotFound() {
        // Arrange
        when(branchService.getBranchById(1L)).thenReturn(null);

        // Act
        ResponseEntity<?> response = branchController.getBranchById(1L);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(null);
    }

    @Test
    void testGetAllBranches_Success() {
        // Arrange
        Branch branch1 = new Branch();
        branch1.setBranchId(1L);
        branch1.setCountry("Canada");

        Branch branch2 = new Branch();
        branch2.setBranchId(2L);
        branch2.setCountry("USA");

        List<Branch> branches = Arrays.asList(branch1, branch2);

        when(branchService.getAllBranches()).thenReturn(branches);

        // Act
        ResponseEntity<List<Branch>> response = branchController.getAllBranches();

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody().get(0).getCountry()).isEqualTo("Canada");
        assertThat(response.getBody().get(1).getCountry()).isEqualTo("USA");
        verify(branchService, times(1)).getAllBranches();
    }

    @Test
    void testDeleteBranch_Success() {
        Long branchId = 1L;

        doNothing().when(branchService).deleteBranch(branchId);

        // Act
        ResponseEntity<Void> response = branchController.deleteBranch(branchId);

        // Assert
        assertThat(response.getStatusCodeValue()).isEqualTo(204);
        verify(branchService, times(1)).deleteBranch(branchId);
    }


}
