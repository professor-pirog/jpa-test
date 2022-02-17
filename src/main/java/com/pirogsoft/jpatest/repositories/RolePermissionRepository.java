package com.pirogsoft.jpatest.repositories;

import com.pirogsoft.jpatest.entities.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepository extends JpaRepository<RolePermission, String> {

}
