package com.creatorschool.noteit;

import com.creatorschool.noteit.api.viewmodel.NoteViewModel;
import com.creatorschool.noteit.api.viewmodel.NotebookViewModel;
import com.creatorschool.noteit.dao.NotebookDAO;
import com.creatorschool.noteit.model.Note;
import com.creatorschool.noteit.model.Notebook;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class Mapper {

    private NotebookDAO notebookDAO;

    public Mapper(NotebookDAO notebookDAO) {
        this.notebookDAO = notebookDAO;
    }

    public NoteViewModel convertToNoteViewModel(Note note) {
        NoteViewModel viewModel = new NoteViewModel();
        viewModel.setTitle(note.getTitle());
        viewModel.setText(note.getText());
        viewModel.setId(note.getId().toString());
        viewModel.setLastModifiedOn(note.getLastModifiedOn());
        viewModel.setNotebookId(note.getNotebook().getId().toString());

        return viewModel;
    }
    public Note convertToNoteEntity(NoteViewModel noteViewModel) {
        Notebook notebook = new Notebook();
        UUID notebookId = UUID.fromString(noteViewModel.getNotebookId());
        Optional<Notebook > optional = this.notebookDAO.findById(notebookId);
        if (optional.isPresent()) {
            notebook = optional.get();
            return new Note(noteViewModel.getId(), noteViewModel.getTitle(), noteViewModel.getText(), notebook);
        }
        return new Note(noteViewModel.getId(), noteViewModel.getTitle(), noteViewModel.getText(), notebook);
    }
    public Notebook convertToNotebookEntity(NotebookViewModel notebookViewModel) {

        Notebook notebook = new Notebook(notebookViewModel.getId(), notebookViewModel.getName());
        return notebook;

    }
}
