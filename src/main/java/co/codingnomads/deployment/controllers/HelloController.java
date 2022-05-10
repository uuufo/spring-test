package co.codingnomads.deployment.controllers;

import co.codingnomads.deployment.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping("/")
    public String sayHello(Model model) {
        model.addAttribute("hello", helloService.getHello());
        return "hello";
    }
}