package com.simbirsoft.spring_demo.model;

public enum Permission {
    AUTHOR_READ("author:read"),
    AUTHOR_WRITE("author:write"),
    BOOK_READ("book:read"),
    BOOK_WRITE("book:write"),
    PUBLISHER_READ("publisher:read"),
    PUBLISHER_WRITE("publisher:write"),
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;


    Permission(String permission) {
        this.permission = permission;
    }


    public String getPermission() {
        return permission;
    }

}
