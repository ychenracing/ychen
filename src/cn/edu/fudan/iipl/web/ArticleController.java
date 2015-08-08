/**
 * ychen
 * Copyright (c).
 */
package cn.edu.fudan.iipl.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.edu.fudan.iipl.dao.ArticleDao;
import cn.edu.fudan.iipl.entity.Article;
import cn.edu.fudan.iipl.enums.BlogExceptionEnum;
import cn.edu.fudan.iipl.exception.BlogException;

/**
 * 文章controller
 * @author racing
 * @version $Id: ArticleList.java, v 0.1 Aug 8, 2015 3:49:42 PM racing Exp $
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    /** articleDao对象 */
    @Resource(type = ArticleDao.class)
    private ArticleDao          articleDao;

    /** 文章列表页面 */
    private static final String ARTICLE_LIST_JSP    = "/WEB-INF/jsp/article/article_list.jsp";

    /** 文章详情页面 */
    private static final String ARTICLE_PROFILE_JSP = "/WEB-INF/jsp/article/article_profile.jsp";

    /**
     * 显示文章列表页面
     * @param request
     * @return
     */
    @RequestMapping(value = "/list", method = { RequestMethod.GET })
    public String showList(ModelMap model) {
        List<Article> articleList = articleDao.getAll();
        model.addAttribute("articles", articleList);
        return ARTICLE_LIST_JSP;
    }

    /**
     * 显示文章内容页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/profile/{id}", method = { RequestMethod.GET })
    public String showProfile(ModelMap model, @PathVariable String id) {
        int articleId;
        try {
            articleId = Integer.parseInt(id);
        } catch (Exception e) {
            throw new BlogException(BlogExceptionEnum.ARTICLE_ID_NOT_FOUND);
        }

        Article article = articleDao.getById(articleId);
        model.addAttribute("article", article);
        return ARTICLE_PROFILE_JSP;
    }
}
