package com.example.testetecnicocrea.modules.professional.domain.entities;

import com.example.testetecnicocrea.common.utils.CodeGenerator;
import com.example.testetecnicocrea.modules.title.domain.entities.Title;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class Professional {
    private int id;
    private String name;
    private String email;
    private String password;
    private LocalDate birthDate;
    private LocalDateTime registerDate;
    private String phoneNumber;
    private String code;
    private RegistrationStatus registrationStatus;
    private ProfessionalType professionalType;
    private LocalDateTime visaDate;
    private List<Title> titles;

    public String generateCodeNumber() {
        return CodeGenerator.generateCode();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public RegistrationStatus getRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(RegistrationStatus registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public ProfessionalType getProfessionalType() {
        return professionalType;
    }

    public void setProfessionalType(ProfessionalType professionalType) {
        this.professionalType = professionalType;
    }

    public LocalDateTime getVisaDate() {
        return visaDate;
    }

    public void setVisaDate(LocalDateTime visaDate) {
        this.visaDate = visaDate;
    }

    public List<Title> getTitles() {
        return titles;
    }

    public void setTitles(List<Title> titles) {
        this.titles = titles;
    }

    public void addTitle(Title title) {
        this.titles.add(title);
        if (this.registrationStatus == null) {
            this.registrationStatus = RegistrationStatus.ATIVO;
        }
    }

}
