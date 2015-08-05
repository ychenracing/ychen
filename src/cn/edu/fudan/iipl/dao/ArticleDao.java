/**
 * iipl.fudan.edu.cn
 * Copyright (c)
 */
package cn.edu.fudan.iipl.dao;

import java.sql.Date;
import java.util.List;

import cn.edu.fudan.iipl.entity.Article;

/**
 * article dao
 * @author racing
 * @version $Id: ArticleDao.java, v 0.1 Aug 5, 2015 11:35:51 PM racing Exp $
 */
public interface ArticleDao {

    /**
     * 查询所有文章
     * @return List<Article>
     */
    public List<Article> getAll();

    /**
     * 根据id查找文章
     * @param id
     * @return Article
     */
    public Article getById(int id);

    /**
     * 根据标题查找文章
     * @param title
     * @return Article
     */
    public Article getByTitle(String title);

    /**
     * 根据类别查找文章
     * @param category
     * @return List<Article>
     */
    public List<Article> getByCategory(String category);

    /**
     * 根据作者查找文章
     * @param category
     * @return List<Article>
     */
    public List<Article> getByAuthor(String category);

    /**
     * 根据创建时间查找文章
     * @param gmtCreate
     * @return List<Article>
     */
    public List<Article> getByGmtCreate(Date gmtCreate);

    /**
     * 修改
     * @param article
     */
    public void updateArticle(Article article);

    /**
     * 新增
     * @param article
     */
    public void addArticle(Article article);

    /**
     * 根据id删除文章
     * @param id
     */
    public void deleteById(int id);

    /**
     * 根据标题删除文章
     * @param id
     */
    public void deleteByTitle(int title);

}
