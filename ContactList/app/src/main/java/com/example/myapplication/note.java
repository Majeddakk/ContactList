package com.example.myapplication;

public class note {
    String name;
    String subject;
    Boolean checked = Boolean.FALSE;
    String othernotes;
    Integer ID;

    public note(String name, String subject, String othernotes, Integer ID){
        this.name = name;
        this.subject = subject;
        this.othernotes = othernotes;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public Boolean isChecked(){
        return checked;
    }
}
