package com.example.Bank.Project.controller;

import com.example.Bank.Project.bank_model.Bank;
import com.example.Bank.Project.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class BankController {

    @Autowired
    private BankService service;

    @GetMapping("/")
    public String Home(Model model){
        List<Bank> b = service.getclient();
        model.addAttribute("b",b);
        return "index";
    }

    @GetMapping("/addclient")
    public String addclient(){
      return   "clientadd";
    }
    @PostMapping("/register")
    public String submit(@ModelAttribute Bank B, HttpSession session){
        System.out.println(B);
        service.addclient(B);
        session.setAttribute("message","client added successfully");
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String updateclient(@PathVariable int id, Model model){
        Bank bank=service.getbyid(id);
        model.addAttribute("counter",bank);
        return "edit";
    }
    @GetMapping("/delete/{id}")
    public String deleteclient(@PathVariable int id, HttpSession session){
        service.deleteclient(id);
        session.setAttribute("message","Deleted_successfully");
        return "redirect:/";
    }



}
