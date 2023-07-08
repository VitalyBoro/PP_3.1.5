package vitfed.kata_spr_boot_security_pp_3_1_3.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vitfed.kata_spr_boot_security_pp_3_1_3.entity.Role;
import vitfed.kata_spr_boot_security_pp_3_1_3.repository.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleRepository.save(role);
    }
}
