package com.pirogsoft.jpatest.entities;

import com.pirogsoft.jpatest.entities.converters.IntPermissionConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "role_permission")
public class RolePermission {

    @Id
    @Getter
    @Setter
    @Column(name = "id")
    private String id;

    @Convert(converter = IntPermissionConverter.class)
    @Column(name = "value")
    private Permission permission = new Permission();

    @Getter
    @Setter
    @Column(name = "target")
    private String target;

    public boolean isRead() {
        return permission.isRead();
    }

    public void setRead(boolean read) {
        permission.setRead(read);
    }

    public boolean isWrite() {
        return permission.isWrite();
    }

    public void setWrite(boolean write) {
        permission.setWrite(write);
    }

    public boolean isDelete() {
        return permission.isDelete();
    }

    public void setDelete(boolean delete) {
        permission.setDelete(delete);
    }
}
