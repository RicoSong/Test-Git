package com.example.blog.Controller;

import com.example.blog.Service.Test_Service;
import com.example.blog.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DetailsController {
    @Autowired
    Test_Service test_service;
    @RequestMapping("/f")
    public String Details(@PathVariable(name = "id") int id, Model model){
        //查找相应id的 blog 内容
        Blog blog = test_service.findbyId(id);
        model.addAttribute("blog",blog);
        return "Details_page";
    }
}
