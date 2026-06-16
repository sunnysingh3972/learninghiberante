package com.hibernatelearning.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int StudentId;
    @Column(name="student_name" ,length=50, nullable=false)
    private String name;
    @Column(name="student_college", length=100)
    private String college;
    @Column(name="student_phone", length=15)
    private String phone;
    @Column(name="student_email", length=100, unique=true)
    private String email;
    @Column(name="is_active")
    private boolean isActive=true;
    @Lob
    private String about;
    public int getStudentId() {
        return StudentId;
    }
    public void setStudentId(int studentId) {
        StudentId = studentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCollege() {
        return college;
    }
    public void setCollege(String college) {
        this.college = college;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }
    @Override
    public String toString() {
        return "Student [StudentId=" + StudentId + ", name=" + name + ", college=" + college + ", phone=" + phone
                + ", email=" + email + ", isActive=" + isActive + ", about=" + about + "]";
    }
    
    
}
