package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") //url
    public String hello(Model model) {
        model.addAttribute("data", "hello!!"); //data가 hello!!로 치환
        return "hello"; //templetes의 hello.html
    }
}
