/**
 * ychen
 * Copyright (c).
 */
package cn.edu.fudan.iipl.controller;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.fudan.iipl.dao.ArticleDao;
import cn.edu.fudan.iipl.entity.Article;
import cn.edu.fudan.iipl.form.ArticleForm;
import cn.edu.fudan.iipl.util.ArticleConvertor;

/**
 * 文章controller
 * @author racing
 * @version $Id: ArticleList.java, v 0.1 Aug 8, 2015 3:49:42 PM racing Exp $
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    private static final Logger logger                 = Logger.getLogger(ArticleController.class);

    /** articleDao对象 */
    @Resource(type = ArticleDao.class)
    private ArticleDao          articleDao;

    /** 文章列表页面 */
    private static final String ARTICLE_LIST_JSP       = "/article/article_list";

    /** 文章详情页面 */
    private static final String ARTICLE_PROFILE_JSP    = "/article/article_profile";

    /** 创建文章页面 */
    private static final String ADD_ARTICLE_JSP        = "/article/add_article";

    /** 文章创建结果页面 */
    private static final String ADD_ARTICLE_RESULT_JSP = "/article/add_article_result";

    /**
     * 显示文章列表页面
     * @param request
     * @return 文章列表页面JSP
     */
    @RequestMapping(value = "/list", method = { RequestMethod.GET })
    public String showList(ModelMap model) {
        List<Article> articleList = articleDao.getAll();
        model.addAttribute("articles", articleList);
        if (logger.isInfoEnabled()) {
            logger.info(articleList);
        }
        return ARTICLE_LIST_JSP;
    }

    /**
     * 显示文章内容页面
     * @param model
     * @return 文章内容页面JSP
     */
    @RequestMapping(value = "/profile/{id}", method = { RequestMethod.GET })
    public String showProfile(ModelMap model, @PathVariable String id) {
        int articleId = 0;
        try {
            articleId = Integer.parseInt(id);
        } catch (Exception e) {
            logger.error("文章不存在，没找到该文章", e);
            //            throw new BlogException(BlogExceptionEnum.ARTICLE_ID_NOT_FOUND);
        }

        Article article = articleDao.getById(articleId);
        model.addAttribute("article", article);
        return ARTICLE_PROFILE_JSP;
    }

    /**
     * 显示创建文章页面
     * @param model
     * @return 文章创建页面JSP
     */
    @RequestMapping(value = "/addArticle", method = { RequestMethod.GET })
    public String showAddArticle(ArticleForm articleForm, ModelMap model) {
        return ADD_ARTICLE_JSP;
    }

    /**
     * 创建文章
     * @param articleForm
     * @param bindingResult
     * @param model
     * @return 文章创建结果页面JSP
     */
    @RequestMapping(value = "/addArticle", method = { RequestMethod.POST })
    public String doAddArticle(ArticleForm articleForm, BindingResult bindingResult, ModelMap model) {
        if (bindingResult.hasErrors()) {
            model
                .addAttribute("errorMsg", bindingResult.getFieldErrors().get(0).getRejectedValue());
            return ADD_ARTICLE_JSP;
        }
        Date date = new Date(System.currentTimeMillis());
        articleForm.setGmtCreate(date);
        articleForm.setGmtModify(date);

        Article article = ArticleConvertor.convertArticleFormToArticle(articleForm);
        articleDao.addArticle(article);

        return ADD_ARTICLE_RESULT_JSP;
    }

    @RequestMapping(value = "/responsebody", method = RequestMethod.GET)
    @ResponseBody
    public Object testResponseBody() {
        Object obj = "123" + 12;
        return obj;
    }
}
