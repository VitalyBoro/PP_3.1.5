package vitfed.kata_spr_boot_security_pp_3_1_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vitfed.kata_spr_boot_security_pp_3_1_3.models.User;
import vitfed.kata_spr_boot_security_pp_3_1_3.service.RoleService;
import vitfed.kata_spr_boot_security_pp_3_1_3.service.UserService;


@Controller
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;
    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @GetMapping("/admin")
    public String findAll(Model model){
        model.addAttribute("users", userService.getUsers());
        return "table";
    }
    @PostMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "add_user";
    }
    @PostMapping("/saveUser") //сохранение
    public String saveUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/admin";
    }
    @PatchMapping("/updateUser")//редактирование
    public String updateUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "update_user";
    }
    @PatchMapping("/updateUserData")
    public String updateUserData(@ModelAttribute("update") User user) {
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/deleteUser") //удаление
    public String deleteUser(@RequestParam("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
