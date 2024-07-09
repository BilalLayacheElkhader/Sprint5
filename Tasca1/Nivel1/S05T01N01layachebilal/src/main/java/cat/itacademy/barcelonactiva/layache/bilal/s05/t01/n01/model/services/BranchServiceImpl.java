package cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n01.exceptions.BranchNotFoundException;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n01.model.domain.Branch;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n01.model.dto.dtoBranch;
import cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n01.model.repository.BranchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService{
    @Autowired
    private BranchRepo br;
    @Override
    public void save(dtoBranch dtobranch) {
        Branch branch =  new Branch(dtobranch.getNameBranch(), dtobranch.getCountryBranch());
        br.save(branch);
    }
    @Override
    public void updateBranch(dtoBranch dtobranch) {
        Branch branch = br.findById(dtobranch.getPk_SucursalID())
                .orElseThrow(()-> new BranchNotFoundException("No existe"));
        branch.setCountryBranch(dtobranch.getCountryBranch());
        branch.setNameBranch(dtobranch.getNameBranch());
        br.save(branch);
    }

    @Override
    public void deleteBranch(int branchId) {
        if(!br.existsById(branchId)){
            throw new BranchNotFoundException("La branch con id : "+branchId + " haz intentado eliminar no existe.");
        }else {
            br.deleteById(branchId);
        }

    }

    @Override
    public dtoBranch getById(int branchId) {
        Branch branch = br.findById(branchId)
                .orElseThrow(()-> new BranchNotFoundException("No existe"));
        dtoBranch dtobranch = new dtoBranch(branch.getNameBranch(), branch.getCountryBranch());
        dtobranch.setPk_SucursalID(branchId);
        return dtobranch;
    }

    @Override
    public List<dtoBranch> getAllBranch() {
        List<Branch> branchList = br.findAll();

        return branchList.stream()
                .map(branch -> {
                    dtoBranch dtobranch = new dtoBranch(branch.getNameBranch(),branch.getCountryBranch());
                    dtobranch.setPk_SucursalID(branch.getPk_SucursalID());
                    return dtobranch;
                })
                .collect(Collectors.toList());
    }
    }



