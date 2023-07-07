package vitfed.kata_spr_boot_security_pp_3_1_3.service;



import vitfed.kata_spr_boot_security_pp_3_1_3.models.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getUsers();

    User getUser(Long id);

    void updateUser(User user);

    void deleteUser(Long id);
    User findByUsername(String username);
}
