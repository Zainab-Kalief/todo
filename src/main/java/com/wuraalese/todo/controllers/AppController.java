package com.wuraalese.todo.controllers;

import com.wuraalese.todo.models.List;
import com.wuraalese.todo.models.User;
import com.wuraalese.todo.services.AppService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
    private final AppService service;

    public AppController(AppService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String index(@ModelAttribute("newUser") User user) {
        System.out.println("**********");

        return "index";
    }

    @PostMapping("/user")
    public String newUser(@ModelAttribute("newUser") User user) {
        service.addUser(user);
        return "redirect:/";
    }

    @RequestMapping("/list")
    public String list(@ModelAttribute("newItem")List item, Model model) {

        for (User user:service.allUsers()) {
            System.out.println(user.getName() + " USER");
            for (List list: user.getLists()){
                System.out.println(list.getItem() + " ITEM");
            }
        }
        model.addAttribute("users", service.allUsers());
        return "list";
    }
    @PostMapping("/list")
    public String newList(@ModelAttribute("newItem")List item, @RequestParam("user") Long id) {
        User user = service.findUser(id);
        List list = service.addList(item);
        service.addItem(user, list);
        return "redirect:/";
    }
}
