package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Permission;
import com.bezkoder.springjwt.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
