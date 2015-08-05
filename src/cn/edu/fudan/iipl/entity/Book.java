/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2015 All Rights Reserved.
 */
package cn.edu.fudan.iipl.entity;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.StringUtils;

/**
 * 
 * @author racing
 * @version $Id: Book.java, v 0.1 Aug 4, 2015 11:17:56 PM racing Exp $
 */
public class Book implements InitializingBean {

    private String name;

    private String owner;

    public void init() {
        if (StringUtils.isEmpty(name)) {
            name = "data structure";
        }
        if (StringUtils.isEmpty(owner)) {
            owner = "Yong Chen";
        }
        System.out.println("正在执行初始化方法 init...");
    }

    /** 
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("正在执行初始化方法 afterPropertiesSet...");
    }

}
