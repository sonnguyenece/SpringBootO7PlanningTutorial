package com.example.login.repository;

import com.example.login.entity.AppRole;
import com.example.login.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {
 UserRole findUserRoleByAppUser_UserId(long userId);
}
