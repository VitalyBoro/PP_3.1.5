package vitfed.kata_spr_boot_security_pp_3_1_3.init;


import org.springframework.stereotype.Component;
import vitfed.kata_spr_boot_security_pp_3_1_3.entity.Role;
import vitfed.kata_spr_boot_security_pp_3_1_3.entity.User;
import vitfed.kata_spr_boot_security_pp_3_1_3.service.RoleServiceImpl;
import vitfed.kata_spr_boot_security_pp_3_1_3.service.UserServiceImpl;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class DbInit {
    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    public DbInit(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @PostConstruct
    private void postConstruct() {
        Role roleAdmin = new Role((long)1,"ADMIN");
        Role roleUser = new Role( (long)2,"USER");
        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        User user = new User("user@mail.ru", "user", "user", "user", 20, Set.of(roleUser));
        User admin = new User("admin@mail.ru", "admin", "admin", "admin", 30, Set.of(roleAdmin, roleUser));
        userService.addUser(user);
        userService.addUser(admin);
    }
}
