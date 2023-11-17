package ra.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ra.academy.model.Student;
import ra.academy.service.impl.StudentService;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/form-add")
    public String add(){
        return "add-student";
    }
    @GetMapping("/list-student")
    public String listStudent(Model model){
        model.addAttribute("students",studentService.findAll());
        return "list-student";
    }
    @GetMapping("/form-edit")
    public String edit(@RequestParam("id") int id,Model model){
        Student s = studentService.findById(id);
        if(s!=null){
            model.addAttribute("editStudent",s);
            return "edit-student";
        }
        return "list-student";
    }
    @GetMapping("/delete")
    public String doDelete(@RequestParam("id") int id,Model model){
        studentService.delete(id);
        List<Student> students = studentService.findAll();
        if(students!= null){
            model.addAttribute("students", students);
        }
        return "list-student";
    }
    @PostMapping("/handle-add")
    public String doAdd(@RequestParam String name, @RequestParam int age, @RequestParam boolean gen, Model model){
        studentService.save(new Student(name,age,gen));
        model.addAttribute("students", studentService.findAll());
        return "list-student";
    }
    @PostMapping("/handle-edit")
    public String doEdit(@ModelAttribute Student student, Model model){
        studentService.save(student);
        model.addAttribute("students",studentService.findAll());
        return "list-student";
    }
}
