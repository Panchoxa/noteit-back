package com.cratorschool.noteit.model;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
public class Notebook {

    @Id
    @Column(columnDefinition = "BINARY(16)")
    @GeneratedValue
    private UUID id;
    private String name;


    // it includes many notes
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "notebook", cascade = CascadeType.ALL)
    private List<Note> notes;

    public Notebook(){
        this.notes = new ArrayList<>();
    }

    //Notebook notebook = new Notebook("things to buy");
    public Notebook(String name){
        this();
        this.name = name;
    }

    public Notebook(String id, String name){
        this();
        if(id != null){
            this.id = UUID.fromString(id);
        }

        Note note = new Note();
        Note note2 = new Note("title", "sdfgds", this);
        this.name = name;
    }

    public int getNBOfNotes() {
        return notes.size();
    }

}

