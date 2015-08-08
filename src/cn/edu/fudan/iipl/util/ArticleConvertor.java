/**
 * ychen.
 * Copyright (c).
 */
package cn.edu.fudan.iipl.util;

import cn.edu.fudan.iipl.entity.Article;
import cn.edu.fudan.iipl.form.ArticleForm;

/**
 * article转换类
 * @author racing
 * @version $Id: ArticleConvertor.java, v 0.1 Aug 8, 2015 6:49:01 PM racing Exp $
 */
public class ArticleConvertor {

    /**
     * ArticleForm转换成Article
     * @param form
     * @return Article
     */
    public static Article convertArticleFormToArticle(ArticleForm form) {
        Article article = new Article();
        article.setTitle(form.getTitle());
        article.setMainBody(form.getMainBody());
        article.setCategory(form.getCategory());
        article.setGmtCreate(form.getGmtCreate());
        article.setGmtModify(form.getGmtModify());
        article.setAuthor(form.getAuthor());
        return article;
    }
}
