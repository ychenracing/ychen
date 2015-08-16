/**
 * ychen.
 * Copyright (c).
 */
package cn.edu.fudan.iipl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.fudan.iipl.dao.ArticleDao;
import cn.edu.fudan.iipl.entity.Article;
import cn.edu.fudan.iipl.service.ArticleService;

/**
 * 
 * @author racing
 * @version $Id: ArticleServiceImpl.java, v 0.1 Aug 15, 2015 11:50:00 PM racing Exp $
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Resource
    ArticleDao articleDao;

    /** 
     * @see cn.edu.fudan.iipl.service.impl.ArticleService#getAllArticle()
     */
    @Override
    public List<Article> getAllArticle() {
        return articleDao.getAll();
    }

    /** 
     * @see cn.edu.fudan.iipl.service.impl.ArticleService#createArticle(cn.edu.fudan.iipl.entity.Article)
     */
    @Override
    public void createArticle(Article article) {
        articleDao.addArticle(article);
    }

}
