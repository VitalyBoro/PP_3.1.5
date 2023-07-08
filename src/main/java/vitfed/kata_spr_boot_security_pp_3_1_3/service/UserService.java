package vitfed.kata_spr_boot_security_pp_3_1_3.service;




import vitfed.kata_spr_boot_security_pp_3_1_3.dto.UserDto;
import vitfed.kata_spr_boot_security_pp_3_1_3.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    void addUser(User user);

    void removeUser(Long id);

    void updateUser(User user);

    Optional<User> findByUsername(String username);

    User convertToUser(UserDto userDto);
    UserDto convertToUserDto(User user);
}