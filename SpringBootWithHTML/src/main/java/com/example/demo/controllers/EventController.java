package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class EventController {

    ArrayList<Post> posts = new ArrayList<>();
    int view = 0;

    @GetMapping(value = "/post")
    public String post() {
        return "form.html";
    }

    @PostMapping(value = "/submit")
    public String redirectToDashboard(Model model, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("date") String date, @RequestParam("privacy") String privacy) {
        Post post = new Post(title, content, date, privacy);
        model.addAttribute("successpost", post);
        posts.add(post);
        return "redirect:/success";
    }

    @GetMapping(value = "/success")
    public String success(Model model) {

        model.addAttribute("title", posts.get(view).getTitle());
        model.addAttribute("content", posts.get(view).getContent());
        model.addAttribute("date", posts.get(view).getDate());
        model.addAttribute("privacy", posts.get(view).getPrivacy());

        view ++;
        return "success.html";
    }

    @GetMapping(value = "/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("posts", posts);

        return "dashboard.html";
    }


}
