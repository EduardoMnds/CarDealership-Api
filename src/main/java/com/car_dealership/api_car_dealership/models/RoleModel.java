package com.car_dealership.api_car_dealership.models;

import com.car_dealership.api_car_dealership.enums.RoleName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_ROLE")
public class RoleModel implements GrantedAuthority, Serializable {

    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roleId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false , unique = true)
    private RoleName roleName;


    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }

    public UUID getRoleId(){
        return roleId;
    }

    public RoleName getRoleName(){
        return roleName;
    }

    public void setRoleId(UUID roleId){
        this.roleId = roleId;
    }
}
