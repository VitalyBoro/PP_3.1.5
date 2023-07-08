package vitfed.kata_spr_boot_security_pp_3_1_3.service;



import vitfed.kata_spr_boot_security_pp_3_1_3.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    void deleteRoleById(Long id);

    void addRole(Role role);

}

