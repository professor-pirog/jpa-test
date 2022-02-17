package com.pirogsoft.jpatest.entities;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Permission {

    private boolean read;

    private boolean write;

    private boolean delete;

}
