package com.creatorschool.noteit.api;


import com.creatorschool.noteit.Mapper;
import com.creatorschool.noteit.api.viewmodel.NoteViewModel;
import com.creatorschool.noteit.dao.NoteDAO;
import com.creatorschool.noteit.dao.NotebookDAO;
import com.creatorschool.noteit.model.Note;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notes")
@CrossOrigin
public class NoteController {

    private NoteDAO noteDAO;
    private NotebookDAO notebookDAO;
    private Mapper mapper;

    public NoteController(NoteDAO noteDAO, NotebookDAO notebookDAO, Mapper mapper) {
        this.noteDAO = noteDAO;
        this.notebookDAO = notebookDAO;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public List<NoteViewModel> all() {
        List<Note> notes = this.noteDAO.findAll();

        return notes.stream()
                .map(note -> this.mapper.convertToNoteViewModel(note))
                .collect(Collectors.toList());
    }


}
