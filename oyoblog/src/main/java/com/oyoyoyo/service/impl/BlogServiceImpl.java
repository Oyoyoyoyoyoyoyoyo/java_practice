package com.oyoyoyo.service.impl;

import com.oyoyoyo.entity.Blog;
import com.oyoyoyo.mapper.BlogMapper;
import com.oyoyoyo.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author anonymous
 * @since 2020-11-04
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
