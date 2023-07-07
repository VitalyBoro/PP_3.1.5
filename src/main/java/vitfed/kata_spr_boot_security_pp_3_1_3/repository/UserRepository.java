package vitfed.kata_spr_boot_security_pp_3_1_3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vitfed.kata_spr_boot_security_pp_3_1_3.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
