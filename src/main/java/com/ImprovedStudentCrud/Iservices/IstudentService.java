package com.ImprovedStudentCrud.Iservices;

import java.util.List;

import com.ImprovedStudentCrud.entities.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

public interface IstudentService 
{
   public Student getStudentById(int id);
   public List<Student> getAllStudents();
   public Student createStudentRecord(Student student);
   public Student updateStudentRecord(int id,Student student);
   public Student patchStudentRecord(int id,JsonPatch student) throws JsonProcessingException, IllegalArgumentException, JsonPatchException;
   public void deleteStudentRecord(int id);
}
