package vitfed.kata_spr_boot_security_pp_3_1_3.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vitfed.kata_spr_boot_security_pp_3_1_3.entity.User;
import vitfed.kata_spr_boot_security_pp_3_1_3.service.UserService;


import java.security.Principal;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/api/auth")
    public ResponseEntity<Optional<User>> getAuthUser( Principal principal) {
        Optional<User> user = userService.findByUsername(principal.getName());
        return ResponseEntity.ok(user);
    }
}
