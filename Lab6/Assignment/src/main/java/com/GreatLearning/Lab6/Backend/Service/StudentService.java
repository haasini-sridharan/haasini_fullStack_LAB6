package com.GreatLearning.Lab6.Backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GreatLearning.Lab6.Backend.Entity.Students;
import com.GreatLearning.Lab6.Backend.Repository.StudentRepository;
import java.util.List;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepo;

	public List<Students> getAllStudents() {

		return studentRepo.findAll();
	}

	public void saveStudent(Students student) {
		studentRepo.saveAndFlush(student);
	}

	public Students getStudentById(int id) {
		return studentRepo.findById(id).get();
	}

	public void deleteStudentById(int id) {

		studentRepo.deleteById(id);
	}

}
