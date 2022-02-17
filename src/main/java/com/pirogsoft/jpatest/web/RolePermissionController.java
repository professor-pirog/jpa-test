package com.pirogsoft.jpatest.web;

import com.pirogsoft.jpatest.dto.RolePermissionDTO;
import com.pirogsoft.jpatest.entities.Permission;
import com.pirogsoft.jpatest.entities.RolePermission;
import com.pirogsoft.jpatest.repositories.RolePermissionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/role-permissions")
public class RolePermissionController {

    private final RolePermissionRepository rolePermissionRepository;

    public RolePermissionController(RolePermissionRepository rolePermissionRepository) {
        this.rolePermissionRepository = rolePermissionRepository;
    }

    @GetMapping
    public List<RolePermissionDTO> getRolePermissions() {
        return rolePermissionRepository
            .findAll()
            .stream()
            .map(this::mapToDTO)
            .collect(Collectors.toList());
    }

    @PostMapping
    public void createRolePermission(@RequestBody RolePermissionDTO rolePermissionDTO) {
        rolePermissionRepository.save(mapToDomain(rolePermissionDTO));
    }

    private RolePermissionDTO mapToDTO(RolePermission rolePermission) {
        return RolePermissionDTO
            .builder()
            .id(rolePermission.getId())
            .read(rolePermission.isRead())
            .write(rolePermission.isWrite())
            .delete(rolePermission.isDelete())
            .target(rolePermission.getTarget())
            .build();
    }

    private RolePermission mapToDomain(RolePermissionDTO dto) {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setId(dto.getId());
        rolePermission.setRead(dto.isRead());
        rolePermission.setWrite(dto.isWrite());
        rolePermission.setDelete(dto.isDelete());
        rolePermission.setTarget(dto.getTarget());
        return rolePermission;
    }


}
