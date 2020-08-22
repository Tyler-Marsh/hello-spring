package org.launchcode.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

//     //Handles request at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public static String hello() {
//        return "Hello World!";
//    }

    @GetMapping("hello")
    // the Param here must be named Hello
    public static String withData(@RequestParam String name, Model model) {
        String greeting = "Hello " + name;
        // this says to add what's stored in greeting into a variable that will
        // be known as greeting inside the view
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("hello/{name}")
    @ResponseBody
    // PathVariable needs to be the same as the
    // parameter in the method
    public String pathMappin(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("form")
    public String HelloForm() {
        return "form";

    }

    @GetMapping("hello/language")
    @ResponseBody
    public static String createMessage(@RequestParam String name, @RequestParam String language) {
       // String greeting;

        if (language.equals("english")) {
            return "Hello " + name + "!";
        }
        else if (language.equals("french")) {
            return "Bonjour " + name + "!";
        }
        else if (language.equals("german")) {
            return "Guten tag " + name + "!";
        }
        else if (language.equals("chinese")) {
            return "你好 " + name + "!";
        }
        else if (language.equals("spanish")) {
            return "Hola " + name + "!";
        }
        else {
            return "error";
        }
    }
}