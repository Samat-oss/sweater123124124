package com.example.sweater.controller;


import com.example.sweater.domians.Message;
import com.example.sweater.domians.User;
import com.example.sweater.domians.Zayavki;
import com.example.sweater.repos.MessageRepo;
import com.example.sweater.repos.ZayavkiRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Controller
public class MainController {
    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private ZayavkiRepos zayavkiRepos;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        return "greeting";
    }


    @GetMapping("/user-custom")
    public String userCustom(Map<String, Object> model, User user) {
        System.out.println(user.getId());

            Iterable<Zayavki> all = zayavkiRepos.findAll();
            model.put("messages", all);
        return "user_custom";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model, User user) {
       // Iterable<Message> messages = messageRepo.findAll();

//        if (filter != null && !filter.isEmpty()) {
//            messages = messageRepo.findByTag(filter);
//        } else {
//            messages = messageRepo.findAll();
//        }

        Iterable<Message> byUserId = messageRepo.findByUsersId(user.getId());
       // System.out.println(byUserId.size());
        System.out.println(user.getId());

        model.addAttribute("messages", byUserId);
     // model.addAttribute("messages", messages);
//        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag, Map<String, Object> model
    ) {
        Message message = new Message(text, tag, user, user.getId());

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);

        return "redirect:/user";
    }
}