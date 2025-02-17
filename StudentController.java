package com.example.studentlist;

     import org.springframework.beans.factory.annotation.Autowired;
     import org.springframework.stereotype.Controller;
     import org.springframework.ui.Model;
     import org.springframework.web.bind.annotation.*;

     @Controller
     public class StudentController {

         @Autowired
         private StudentRepository studentRepository;

         @GetMapping("/students")
         public String listStudents(Model model) {
             model.addAttribute("students", studentRepository.findAll());
             return "students";
         }

         @GetMapping("/students/new")
         public String showStudentForm(Model model) {
             model.addAttribute("student", new Student());
             return "student-form";
         }

         @PostMapping("/students")
         public String saveStudent(@ModelAttribute("student") Student student) {
             studentRepository.save(student);
             return "redirect:/students";
         }

@GetMapping("/students/edit/{id}")
         public String editStudentForm(@PathVariable Long id, Model model) {
             Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
             model.addAttribute("student", student);
             return "student-form";
         }

         @GetMapping("/students/delete/{id}")
         public String deleteStudent(@PathVariable Long id) {
             studentRepository.deleteById(id);
             return "redirect:/students";
         }
     }
