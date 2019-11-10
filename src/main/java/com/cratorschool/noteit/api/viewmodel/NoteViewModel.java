package com.cratorschool.noteit.api.viewmodel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class NoteViewModel {
    private String id;
    private String title;
    private String text;
    private String notebookId;
    private LocalDateTime lastModifiedOn;
}
