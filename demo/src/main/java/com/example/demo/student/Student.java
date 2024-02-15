package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1

    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    private Long Loginid;
    private String name;
    private String email;

    @Transient
    private Integer age;
    private LocalDate dob;

    public Student(Long loginid, String name, String email, LocalDate dob) {
        Loginid = loginid;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student() {

    }



    // Geeters
    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public Long getLoginid() {
        return Loginid;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setAge(Integer age) {
        this.age = age;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLoginid(Long loginid) {
        Loginid = loginid;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return "student{"+
        "id = "+Loginid+
        ", name = "+name + '\''+
        ", email = "+email + '\''+
        ", dob = "+dob + '\''+
        ", age = "+age + '\''+
        '}';
    }
}
