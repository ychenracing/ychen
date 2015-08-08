/**
 * ychen
 * Copyright (c).
 */
package cn.edu.fudan.iipl.exception;

import org.springframework.stereotype.Component;

import cn.edu.fudan.iipl.enums.BlogExceptionEnum;

/**
 * 全局Exception
 * @author racing
 * @version $Id: BlogException.java, v 0.1 Aug 8, 2015 4:18:46 PM racing Exp $
 */
@Component
public class BlogException extends RuntimeException {

    /**  */
    private static final long serialVersionUID = 1848107438259593418L;

    private BlogExceptionEnum blogExceptionEnum;

    public BlogException() {
        super(BlogExceptionEnum.SYSTEM_ERROR.getDescription());
        this.blogExceptionEnum = BlogExceptionEnum.SYSTEM_ERROR;
    }

    public BlogException(BlogExceptionEnum blogExceptionEnum) {
        super(blogExceptionEnum.getDescription());
        this.blogExceptionEnum = blogExceptionEnum;
    }

    /**
     * 获取错误码
     * @return messageCode
     */
    public String getMessageCode() {
        return blogExceptionEnum.getMessageCode();
    }

    /**
     * 获取错误描述
     * @return description
     */
    public String getDescription() {
        return blogExceptionEnum.getDescription();
    }
}
