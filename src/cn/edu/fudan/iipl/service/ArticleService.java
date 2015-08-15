/**
 * ychen.
 * Copyright (c).
 */
package cn.edu.fudan.iipl.service;

import java.util.List;

import cn.edu.fudan.iipl.entity.Article;

/**
 * 
 * @author racing
 * @version $Id: ArticleService.java, v 0.1 Aug 15, 2015 11:46:21 PM racing Exp $
 */
public interface ArticleService {

    public List<Article> getAllArticle();

    public void createArticle(Article article);
}
