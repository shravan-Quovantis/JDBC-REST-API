package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class MyController {

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(final Model model){
        System.out.println("Inside Handler");

        //Putting data in model
        model.addAttribute("name", "Shravan Kumar");
        model.addAttribute("currentDate", new Date().toString());

        return "about";
    }

    @RequestMapping("/example-loop")
    public String iterateHandler(Model m){

        List<String> students = Arrays.asList("Ankita", "Ram", "Shyam");
        m.addAttribute("students", students);
        return "iterate";
    }

    @RequestMapping("/name")
    @ResponseBody
    public String names(){
        return "wwwwwwwwwwwwwwwx";
    }


}
