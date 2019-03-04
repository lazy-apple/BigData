package com.LaZY.eshop.model;

import java.util.Date;

/**
 * @author LaZY(李志一)
 * @create 2019-03-04 19:10
 */
public class User {
    private Integer id;
    private String name;
    private  String password;
    private Date regDate;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", regDate=" + regDate +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
