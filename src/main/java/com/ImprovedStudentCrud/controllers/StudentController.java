package com.ImprovedStudentCrud.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ImprovedStudentCrud.entities.Student;
import com.ImprovedStudentCrud.services.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController 
{
   private final StudentService studentService;
   
   @GetMapping("/{id}")
   public ResponseEntity<Student> getStudentById(@PathVariable int id)
   {
	   Student studentById = studentService.getStudentById(id);
	   return studentById!=null?ResponseEntity.ok(studentById):ResponseEntity.notFound().build();
   }
   
   @GetMapping
   public ResponseEntity<List<Student>> getAllStudentById()
   {
	   List<Student> studentById = studentService.getAllStudents();
	   return studentById!=null?ResponseEntity.ok(studentById):ResponseEntity.notFound().build();
   }
   
   @PostMapping()
   public ResponseEntity<Student> createStudentRecord(@RequestBody Student student)
   {
	   Student studentRecord = studentService.createStudentRecord(student);
	   return ResponseEntity.status(HttpStatus.CREATED).body(studentRecord);
   }
   
   @PutMapping("/{id}")
   public ResponseEntity<Student> updateStudentRecord(@PathVariable int id,@RequestBody Student student)
   {
	   Student updateStudentRecord = studentService.updateStudentRecord(id, student);
       return ResponseEntity.ok(updateStudentRecord);
   }
   
   @PatchMapping("/{id}")
   public ResponseEntity<Student> patchStudentRecord(@PathVariable int id,@RequestBody JsonPatch jsonPatch) throws JsonProcessingException, IllegalArgumentException, JsonPatchException
   {
	   Student patchStudentRecord = studentService.patchStudentRecord(id, jsonPatch);
	   return ResponseEntity.ok(patchStudentRecord);
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<?> deleteStudentRecord(@PathVariable int id)
   {
	   studentService.deleteStudentRecord(id);
	   return ResponseEntity.noContent().build();
   }
   
   
}
