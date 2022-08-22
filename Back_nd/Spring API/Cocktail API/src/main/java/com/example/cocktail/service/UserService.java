/**package com.example.cocktail.service;

import com.example.cocktail.model.Role;
import com.example.cocktail.model.Users;
import com.example.cocktail.repository.RoleRepository;
import com.example.cocktail.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
  //  @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Users SaveUser(Users user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByRole("ADMIN");
        return userRepository.save(user);
    }


}
*/