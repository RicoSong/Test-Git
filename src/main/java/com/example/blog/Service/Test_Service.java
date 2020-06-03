package com.example.blog.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.blog.dao.Mapper;
import com.example.blog.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Test_Service {
    @Autowired
    private Mapper mapper;
    @Value("${pageNumber}")
    private int pageSize;
    public List<Blog> select(){
       return  mapper.select();
    }

    public void insert(Blog blog) {
        mapper.insert(blog);
    }
    //获取总页面数
    public int count() {
        int total = mapper.count();
        int pageNumber = (total%pageSize==0?total/pageSize:total/pageSize+1);
        return pageNumber;
    }

    public List<Blog> limit_blog(int firstPage, int pageNumber) {
        int page=(firstPage-1)*pageNumber;
        return mapper.limit_blog(page,pageNumber);
    }

    public Blog findbyId(int id) {
        return mapper.findbyId(id);
    }
    public void test(){
        System.out.println("hrllo");
    }
    public void tet(){
        System.out.println("hrllo");
    }

}
