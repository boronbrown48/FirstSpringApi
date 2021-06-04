package com.database.database.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
public class student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idstudent;

    private String full_name;
    private String major_id;

    public student() {

    }
    public student(String id, String name, String major) {
        this.idstudent = id;
        this.full_name = name;
        this.major_id = major;
    }

    public String getId() {
        return this.idstudent;
    }
    public void setId(String newId) {
        this.idstudent = newId;
    }

    @Column(name = "full_name", nullable = false)
    public String getName() {
        return this.full_name;
    }
    public void setName(String newFirstName) {
        this.full_name = newFirstName;
    }

    @Column(name = "major_id", nullable = false)
    public String getMajorId() {
        return this.major_id;
    }
    public void setMajorId(String newMajorId) {
        this.major_id = newMajorId;
    }
}
