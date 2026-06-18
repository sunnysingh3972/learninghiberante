package com.hibernatelearning.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="certificates")
public class Certicate {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int certificateId;
    private String certificateName;
    private String link;
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;
    public int getCertificateId() {
        return certificateId;
    }
    public void setCertificateId(int certificateId) {
        this.certificateId = certificateId;
    }
    public String getCertificateName() {
        return certificateName;
    }
    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }
    @Override
    public String toString() {
        return "Certicate [certificateId=" + certificateId + ", certificateName=" + certificateName + ", link=" + link
                + "]";
    }
  
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
}
