package com.security.demo.entity;

import java.util.Set;

public class SysUser {

    private Set<Sysrole> role;

    public Set<Sysrole> getRole() {
        return role;
    }

    public void setRole(Set<Sysrole> role) {
        this.role = role;
    }
}
