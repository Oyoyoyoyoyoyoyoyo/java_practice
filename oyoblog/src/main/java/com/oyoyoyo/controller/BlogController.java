package com.oyoyoyo.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oyoyoyo.common.CommonResult;
import com.oyoyoyo.entity.Blog;
import com.oyoyoyo.service.BlogService;
import com.oyoyoyo.util.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * 博客接口
 *
 * @author anonymous
 * @since 2020-11-04
 */
@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public CommonResult list(@RequestParam(defaultValue = "1") Integer currentPage) {
        Page page = new Page(currentPage,5);
        IPage pageData = blogService.page(page, new QueryWrapper<Blog>().orderByDesc("created"));
        return CommonResult.success(pageData);
    }

    @GetMapping("/blogs/{id}")
    public CommonResult detail(@PathVariable(name = "id") Long id) {
        Blog blog = blogService.getById(id);
        Assert.notNull(blog, "该博客已被删除");
        return CommonResult.success(blog);
    }

    /**
     * 文章编辑
     *
     * @param blog
     * @return
     */
    @RequiresAuthentication
    //认证后方可访问该接口
    @PostMapping("/blogs/edit")
    public CommonResult edit(@Validated @RequestBody Blog blog) {

        Blog temp = null;
        Long currentUserId = ShiroUtils.getProfile().getId().longValue();
        //获取当前用户id
        if (blog.getId() != null) {
            temp = blogService.getById(blog.getId());
            // 只能编辑自己的文章
            Assert.isTrue(temp.getUserId().longValue() == currentUserId, "无编辑权限");
        } else {
            //初始化新文章
            temp = new Blog();
            temp.setUserId(Math.toIntExact(currentUserId));
            temp.setCreated(LocalDateTime.now());
            temp.setStatus(0);
        }
        System.out.println("temp = " + temp.toString());
        //保存更新文章数据
        BeanUtil.copyProperties(blog, temp, "id", "userId", "created", "status");

        blogService.saveOrUpdate(temp);
        return CommonResult.success("成功发表文章");
    }
}
