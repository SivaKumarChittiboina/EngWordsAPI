package com.EngWordsAPI.back.entry;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "laxmikanth")
public class EntryEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -6874931112065537628L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String institutionId;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "institutionId")
//    @GenericGenerator(name = "institutionId", strategy = "com.project1.demo_project.entry.InstitutionIdGenerator")
//    private String institutionId;

    private String institutionName;

    private String adminName;

    private Long adminContactNumber;


    private String emailId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Long getAdminContactNumber() {
        return adminContactNumber;
    }

    public void setAdminContactNumber(Long adminContactNumber) {
        this.adminContactNumber = adminContactNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }


    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

}
