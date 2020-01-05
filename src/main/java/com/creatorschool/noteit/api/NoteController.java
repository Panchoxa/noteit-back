package com.creatorschool.noteit.api;
import com.creatorschool.noteit.Mapper;
import com.creatorschool.noteit.api.viewmodel.NoteViewModel;
import com.creatorschool.noteit.dao.NoteDAO;
import com.creatorschool.noteit.dao.NotebookDAO;
import com.creatorschool.noteit.model.Note;
import com.creatorschool.noteit.model.Notebook;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
    @GetMapping("/byNotebook/{notebookId}")
    public List<NoteViewModel> getAllByNotebookId(@PathVariable String notebookId) {
        List<Note> notes = new ArrayList<>();
        Optional<Notebook> notebook = this.notebookDAO.findById(UUID.fromString(notebookId));
        if (notebook.isPresent()) {
            notes = this.noteDAO.findAllByNotebook(notebook.get());
        }
        return notes.stream()
                .map(note -> this.mapper.convertToNoteViewModel(note))
                .collect(Collectors.toList());
    }
    @GetMapping("/byId/{id}")
    public NoteViewModel byId(@PathVariable String id) {
        Optional<Note> note = this.noteDAO.findById(UUID.fromString(id));
        if (note.isPresent()) {
            throw new EntityNotFoundException();
        }
        return this.mapper.convertToNoteViewModel(note.get());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        this.noteDAO.deleteById(UUID.fromString(id));
    }
    @PostMapping
    public NoteViewModel save(@RequestBody NoteViewModel noteViewModel) {
        Note note = this.mapper.convertToNoteEntity(noteViewModel);
        this.noteDAO.save(note);
        return this.mapper.convertToNoteViewModel(note);
    }
}