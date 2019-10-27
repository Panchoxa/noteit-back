package com.creatoreschool.noteit.model;

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
    //TODO: google about FetchTypes and CascadeTypes;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "notebook", cascade = CascadeType.ALL)
    private List<Note> notes;
    public Notebook(){
        this.notes = new ArrayList<>();
    }
    public Notebook(String name){
        this();
        this.name = name;
    }

    public Notebook(String id, String name){
        this();
        if (id != null){
            this.id = UUID.fromString(id);
        }
        this.name = name;
    }
    public int getNBOfNotes(){
        return this.notes.size();
    }
}

