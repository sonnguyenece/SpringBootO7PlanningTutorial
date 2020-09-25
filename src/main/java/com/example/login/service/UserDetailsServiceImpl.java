package com.example.login.service;

import com.example.login.entity.AppUser;
import com.example.login.entity.UserRole;
import com.example.login.repository.AppRoleRepository;
import com.example.login.repository.AppUserRepository;
import com.example.login.repository.UserRoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserDetailsServiceImpl {

    @Autowired
    private AppRoleRepository appRoleRepository;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    public UserDetails loadUserByUsername(String username){
        AppUser appUser = appUserRepository.findByUserName(username);

        if (appUser==null){
      log.error("User not found!"+ username);
      throw new UsernameNotFoundException("User" + username + "was not found in the database")
        }
        System.out.println("Found User:" + appUser);
log.info("Found USer: "+appUser);

UserRole userRole = userRoleRepository.findById(appUser.getUserId()).get();

//List<String> roleNames = this.appRoleRepository
//        .findById(userRole.getId())
//        .stream()
//        .collect(Collectors.toList());

    }
}
