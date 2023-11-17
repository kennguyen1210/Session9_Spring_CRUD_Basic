package ra.academy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.academy.model.Student;

@Controller
public class HomeController {
//    @RequestMapping("/hello") // get
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name,
                        @RequestParam("age") int age, Model model){
        model.addAttribute("stu", new Student(name,age, true));
        return "hello";
    }
    @PostMapping("/handle-add")
    public String doAdd(@RequestParam String name, @RequestParam String phone, Model model){
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        return "profile";
    }
    @GetMapping("/form")
    public String viewForm(){
        return "form";
    }
}
