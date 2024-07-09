package cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n01.model.repository;

import cat.itacademy.barcelonactiva.layache.bilal.s05.t01.n01.model.domain.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BranchRepo extends JpaRepository<Branch, Integer> {
}
