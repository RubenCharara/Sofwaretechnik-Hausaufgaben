package com.example.demo;

public class Student {

    static Integer Id;
    String Name;
    String matNr;
    String subject;


    // Getter and Setter for Id
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    // Getter and Setter for Name
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    // Getter and Setter for matNr
    public String getMatNr() {
        return matNr;
    }

    public void setMatNr(String matNr) {
        this.matNr = matNr;
    }

    // Getter and Setter for subject
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
