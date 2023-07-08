package vitfed.kata_spr_boot_security_pp_3_1_3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vitfed.kata_spr_boot_security_pp_3_1_3.dto.UserDto;
import vitfed.kata_spr_boot_security_pp_3_1_3.entity.User;
import vitfed.kata_spr_boot_security_pp_3_1_3.service.UserService;


import java.util.List;


@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    private final UserService userService;
    public AdminController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/users")
    public ResponseEntity<List<User>> showAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getOneUser(@PathVariable("id") Long id) {
        UserDto userDto = userService.convertToUserDto(userService.getUserById(id));
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<HttpStatus> addUser(@RequestBody UserDto userDto) {
        userService.addUser(userService.convertToUser(userDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        userService.removeUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PatchMapping(value = "/users/{id}")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User user, @PathVariable("id") Long id) {
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
