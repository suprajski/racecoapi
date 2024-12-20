package com.raceco.apii.Controller;

import com.raceco.apii.Entity.Branch;
import com.raceco.apii.Service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;

    @PostMapping
    public ResponseEntity<Branch> addBranch(@RequestBody Branch branch) {
        return ResponseEntity.ok(branchService.addBranch(branch));
    }

    @GetMapping
    public ResponseEntity<List<Branch>> getAllBranches() {
        return ResponseEntity.ok(branchService.getAllBranches());
    }

    @GetMapping("/{branchId}")
    public ResponseEntity<Branch> getBranchById(@PathVariable Long branchId) {
        return ResponseEntity.ok(branchService.getBranchById(branchId));
    }

    @DeleteMapping("/{branchId}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Long branchId) {
        branchService.deleteBranch(branchId);
        return ResponseEntity.noContent().build();
    }
}
