package fr.mariech.phonebook.service;


import fr.mariech.facturier.entity.Admin;
import fr.mariech.facturier.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Admin> admin = userRepository.findByUsername(email);
        if (admin.isEmpty()) {
            throw new UsernameNotFoundException("Mauvais identifiants");
        }

        return admin.get();
    }
}

