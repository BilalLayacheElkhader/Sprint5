package cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n01.model.dto.dtoBranch;

import java.util.List;
import java.util.Optional;

public interface BranchService {
    void save(dtoBranch dtobranch);

    void updateBranch(dtoBranch dtobranch);

    void deleteBranch(int branchId);

    dtoBranch getById(int branchId);

    List<dtoBranch> getAllBranch();
}
