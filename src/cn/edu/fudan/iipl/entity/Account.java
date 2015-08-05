/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package cn.edu.fudan.iipl.entity;

/**
 * 账户实体
 * @author racing
 * @version $Id: Account.java, v 0.1 Jul 26, 2015 6:55:40 PM racing Exp $
 */
public class Account {
    private int    id;
    private String name;
    private String password;

    public Account(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
