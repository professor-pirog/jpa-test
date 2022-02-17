package com.pirogsoft.jpatest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class RolePermissionDTO {

    private String id;

    private boolean read;

    private boolean write;

    private boolean delete;

    private String target;
}
