/**
 * iipl.fudan.edu.cn
 * Copyright (c)
 */
package cn.edu.fudan.iipl.entity;

import java.sql.Date;

/**
 * article entity class.
 * @author racing
 * @version $Id: Article.java, v 0.1 Aug 5, 2015 11:24:25 PM racing Exp $
 */
public class Article {

    /** 文章id */
    private int    id;

    /** 标题 */
    private String title;

    /** 正文 */
    private String mainBody;

    /** 分类 */
    private String category;

    /** 作者 */
    private String author;

    /** 创建时间 */
    private Date   gmtCreate;

    /** 最后修改时间 */
    private Date   gmtModify;

    /**
     * Getter method for property <tt>id</tt>.
     * 
     * @return property value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     * 
     * @param id value to be assigned to property id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>title</tt>.
     * 
     * @return property value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter method for property <tt>title</tt>.
     * 
     * @param title value to be assigned to property title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Getter method for property <tt>mainBody</tt>.
     * 
     * @return property value of mainBody
     */
    public String getMainBody() {
        return mainBody;
    }

    /**
     * Setter method for property <tt>mainBody</tt>.
     * 
     * @param mainBody value to be assigned to property mainBody
     */
    public void setMainBody(String mainBody) {
        this.mainBody = mainBody;
    }

    /**
     * Getter method for property <tt>category</tt>.
     * 
     * @return property value of category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter method for property <tt>category</tt>.
     * 
     * @param category value to be assigned to property category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter method for property <tt>author</tt>.
     * 
     * @return property value of author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Setter method for property <tt>author</tt>.
     * 
     * @param author value to be assigned to property author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Getter method for property <tt>gmtCreate</tt>.
     * 
     * @return property value of gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * Setter method for property <tt>gmtCreate</tt>.
     * 
     * @param gmtCreate value to be assigned to property gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * Getter method for property <tt>gmtModify</tt>.
     * 
     * @return property value of gmtModify
     */
    public Date getGmtModify() {
        return gmtModify;
    }

    /**
     * Setter method for property <tt>gmtModify</tt>.
     * 
     * @param gmtModify value to be assigned to property gmtModify
     */
    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }

}
