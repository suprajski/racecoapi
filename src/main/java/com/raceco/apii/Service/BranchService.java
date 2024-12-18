package com.raceco.apii.Service;

import com.raceco.apii.Entity.Branch;

import java.util.List;

public interface BranchService  {
    Branch addBranch(Branch branch);
    List<Branch> getAllBranches();
    Branch getBranchById(Long branchId);
    void deleteBranch(Long branchId);

}
