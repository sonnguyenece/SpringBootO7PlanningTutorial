package com.example.login.repository;

import com.example.login.entity.AppRole;
import com.example.login.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {

}
