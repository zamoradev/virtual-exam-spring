package com.springboot.virtualexam.rol.data;

public enum RolName {
    MANAGER("ROLE_MANAGER"),
    TEACHER("ROLE_TEACHER"),
    STUDENT("ROLE_STUDENT");

    private String name;

    RolName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
