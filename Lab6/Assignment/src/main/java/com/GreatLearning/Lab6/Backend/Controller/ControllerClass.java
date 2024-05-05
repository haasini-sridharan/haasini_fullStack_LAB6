package com.GreatLearning.Lab6.Backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.GreatLearning.Lab6.Backend.Entity.Students;
import com.GreatLearning.Lab6.Backend.Service.StudentService;

@Controller
public class ControllerClass {

	@Autowired
	StudentService studentService;

	@RequestMapping("/studentsTable")
	public String studentsTable(Model model) {
		List<Students> students = studentService.getAllStudents();
		model.addAttribute("students", students);
		return "students";
	}

	@GetMapping("/students/new")
	public String newStudents(Model model) {
		Students s1 = new Students();
		model.addAttribute("student", s1);
		return "create_students";
	}

	@PostMapping("/students")
	public String addStudent(@ModelAttribute("student") Students student) {
		studentService.saveStudent(student);
		return "redirect:/studentsTable";
	}

	@GetMapping("/student/edit/{id}")
	public String editStudent(@PathVariable int id, Model model) {
		Students s1 = studentService.getStudentById(id);
		model.addAttribute("student", s1);
		return "edit_students";
	}

	@PostMapping("/student/newRecord/{id}")
	public String updatedStudent(@PathVariable int id, @ModelAttribute("student") Students newStudent) {
		Students s1 = studentService.getStudentById(id);
		s1.setFirstName(newStudent.getFirstName());
		s1.setLastName(newStudent.getLastName());
		s1.setCountry(newStudent.getCountry());
		s1.setCourse(newStudent.getCourse());
		studentService.saveStudent(s1);
		return "redirect:/studentsTable";
	}

	@GetMapping("/student/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		studentService.deleteStudentById(id);
		return "redirect:/studentsTable";
	}

	@GetMapping("/student/view/{id}")
	public String viewStudent(@PathVariable int id, Model model) {
		Students student = studentService.getStudentById(id);
		model.addAttribute("studentDetail", student);
		return "view_student";
	}

	@RequestMapping("/403")
	public String forbiddenAccess() {
		return "Error";
	}

}
