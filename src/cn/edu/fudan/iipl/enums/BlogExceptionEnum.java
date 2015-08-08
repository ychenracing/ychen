/**
 * ychen.
 * Copyright (c).
 */
package cn.edu.fudan.iipl.enums;

/**
 * 全局异常枚举
 * @author racing
 * @version $Id: BlogExceptionEnum.java, v 0.1 Aug 8, 2015 4:20:30 PM racing Exp $
 */
public enum BlogExceptionEnum {

    /** 系统错误 */
    SYSTEM_ERROR("SYSTEM_ERROR", "系统错误"),

    /** 文章不存在，没找到该文章 */
    ARTICLE_ID_NOT_FOUND("ARTICLE_ID_NOT_FOUND", "文章不存在，没找到该文章");

    /** 错误码 */
    private String messageCode;

    /** 错误描述 */
    private String description;

    private BlogExceptionEnum(String messageCode, String description) {
        this.messageCode = messageCode;
        this.description = description;
    }

    /**
     * Getter method for property <tt>messageCode</tt>.
     * 
     * @return property value of messageCode
     */
    public String getMessageCode() {
        return messageCode;
    }

    /**
     * Setter method for property <tt>messageCode</tt>.
     * 
     * @param messageCode value to be assigned to property messageCode
     */
    public void setMessageCode(String messageCode) {
        this.messageCode = messageCode;
    }

    /**
     * Getter method for property <tt>description</tt>.
     * 
     * @return property value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter method for property <tt>description</tt>.
     * 
     * @param description value to be assigned to property description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
