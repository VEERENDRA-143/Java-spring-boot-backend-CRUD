package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;


@Service
public class StudentService {
	private final StudentRepository studentRepository;

	@Autowired
	public StudentService(StudentRepository studentRepository){
		this.studentRepository = studentRepository;
	}
    
	public List<Student> getstStudents() {

		return studentRepository.findAll();

	}

    public void addNewStudents(Student student) throws Exception {

		Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		if (studentByEmail.isPresent()) {
			throw new IllegalStateException("User Exists");
		}
		studentRepository.save(student);
	}

	public void deletestudent(Long studentId) {
		boolean exists = studentRepository.existsById(studentId);
		if (!exists) {
			throw new IllegalStateException("Student With id "+ studentId + " does not exits!");
		}
		studentRepository.deleteById(studentId);
	}

	// @Transactional
	// public void updateStudent(Long studentId, String name, String email) throws Exception{

	// 	Student student = studentRepository.findById(studentId)
	// 	.orElseThrow(
	// 		() -> new Exception("student with id "+ studentId+" does not exists")
	// 	)
		
	// 	if (name != null && name.length()>0 && !Objects.equals(student.getName(), name)) {
	// 		student.setName(name);
	// 	}
	// 	if (email != null && email.length()>0 && !Objects.equals(student.getEmail(), email)) {
	// 		Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

	// 		if (studentOptional.isPresent()) {
	// 			throw new Exception("Email taken");
	// 		}
	// 		student.setEmail(email);
	// 	}
	// }
}
