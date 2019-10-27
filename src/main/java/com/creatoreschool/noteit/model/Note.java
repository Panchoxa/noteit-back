package com.creatoreschool.noteit.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
public class Note {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
    private String title;
    private String text;
    @ManyToOne(fetch = FetchType.LAZY)
    private Notebook notebook;
    @Setter
    private LocalDateTime lastModifiedOn;
    //Note note = newNote();
    public Note(){
       this.lastModifiedOn = LocalDateTime.now();
    }
    //Note note = new Note("Things to buy", "tomatoes...");
    public Note(String title, String text, Notebook notebook){
        this();
        this.title = title;
        this.text = text;
        this.notebook = notebook;
    }

}
