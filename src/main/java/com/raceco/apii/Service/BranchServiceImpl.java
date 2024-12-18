package com.raceco.apii.Service;

import com.raceco.apii.Entity.Branch;
import com.raceco.apii.Repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService{

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public Branch addBranch(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public List<Branch> getAllBranches() {
        return branchRepository.findAll();
    }

    @Override
    public Branch getBranchById(Long branchId) {
        return branchRepository.findById(branchId)
                .orElseThrow(()-> new RuntimeException("No branch with ID: " + branchId));
    }

    @Override
    public void deleteBranch(Long branchId) {

        branchRepository.deleteById(branchId);

    }

}
