package fr.mariech.facturier.controller;

import fr.mariech.facturier.repository.AdminRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class AuthWebController {

    private final AdminRepository adminRepository;

    public AuthWebController(AdminRepository userRepository) {
        this.adminRepository = userRepository;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/clients";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    /*@GetMapping("/auth/profile")
    public String displayUserDetails(Model model) {
        return "auth/profile";
    }

    @GetMapping("/auth/logout")
    public String logout(Model model) {
        return "redirect:/login";
    }*/
}
