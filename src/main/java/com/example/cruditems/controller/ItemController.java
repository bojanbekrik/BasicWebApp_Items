package com.example.cruditems.controller;

import com.example.cruditems.entity.Item;
import com.example.cruditems.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public String getHome () {
        return "home";
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @GetMapping("/items")
    public ModelAndView getAllItems() {
        List<Item> list = itemService.getAllItems();
        return new ModelAndView("viewAll","items",list);
    }

    @PostMapping("/save")
    public String addItem (@ModelAttribute Item i) {
        itemService.save(i);
        return "redirect:/items";
    }

    @RequestMapping("/delete/{id}")
    public String deleteItem (@PathVariable int id) {
        itemService.deleteById(id);
        return "redirect:/items";
    }

    @RequestMapping("/edit/{id}")
    public String editItem (@PathVariable int id, Model model) {
        Item i = itemService.getItemById(id);
        model.addAttribute("item", i);
        return "edit";
    }




}
