package com.ImprovedStudentCrud.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ImprovedStudentCrud.Iservices.IstudentService;
import com.ImprovedStudentCrud.entities.Student;
import com.ImprovedStudentCrud.repositories.StudentRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService implements IstudentService
{
	private final StudentRepo studentRepo;
	
	private final ObjectMapper objectMapper;

	@Override
	public Student getStudentById(int id) {
		Student student = studentRepo.findById(id)
				.orElseThrow(()->new RuntimeException("user not found with id "+id));
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> all = studentRepo.findAll();
		return all;
	}

	@Override
	public Student createStudentRecord(Student student) {
		Student save = studentRepo.save(student);
		return save;
	}

	@Override
	public Student updateStudentRecord(int id, Student student) {
	  Student studentFromDb =	studentRepo.findById(id)
		             .orElseThrow(()->new RuntimeException("user not found with id "+id));
		if(student.getEmail()!=null)
		{
			studentFromDb.setEmail(student.getEmail());
		}
		if(student.getFirstname()!=null)
		{
			studentFromDb.setEmail(student.getFirstname());
		}
		if(student.getLastname()!=null)
		{
			studentFromDb.setEmail(student.getLastname());
		}
		if(student.getPhoneNumber()!=null)
		{
			studentFromDb.setEmail(student.getPhoneNumber());
		}
		Student save = studentRepo.save(studentFromDb);
	  return save;
	}

	@Override
	public Student patchStudentRecord(int id, JsonPatch student) throws JsonProcessingException, IllegalArgumentException, JsonPatchException {
		 Student studentFromDb =	studentRepo.findById(id)
	             .orElseThrow(()->new RuntimeException("user not found with id "+id));
          
		 Student applyPatch = applyPatch(studentFromDb,student);
		 Student save = studentRepo.save(applyPatch);
		return save;
	}

	private Student applyPatch(Student studentFromDb, JsonPatch student) throws IllegalArgumentException, JsonPatchException, JsonProcessingException {
	  
		JsonNode apply = student.apply(objectMapper.convertValue(studentFromDb, JsonNode.class));
		
		Student treeToValue = objectMapper.treeToValue(apply, Student.class);
		return treeToValue;
		
	}

	@Override
	public void deleteStudentRecord(int id) {
		studentRepo.deleteById(id);
		
	}

}
