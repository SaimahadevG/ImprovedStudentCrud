package com.ImprovedStudentCrud.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  
  @Column(name="first_name")
  private String firstname;
  
  @Column(name="last_name")
  private String lastname;
  
  @Column(name="email")
  private String email;
  
  @Column(name="phone_number")
  private String phoneNumber;
  
}
