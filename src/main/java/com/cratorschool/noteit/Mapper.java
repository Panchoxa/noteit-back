package com.cratorschool.noteit;


import com.cratorschool.noteit.api.viewmodel.NoteViewModel;
import com.cratorschool.noteit.dao.NotebookDAO;
import com.cratorschool.noteit.model.Note;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private NotebookDAO notebookDAO;

    public Mapper(NotebookDAO notebookDAO) {
        this.notebookDAO = notebookDAO;
    }
    public NoteViewModel convertToNoteViewModel(Note note){
        NoteViewModel viewModel = new NoteViewModel();
        viewModel.setTitle(note.getTitle());
        viewModel.setText(note.getText());
        viewModel.setId(note.getId().toString());
        viewModel.setLastModifiedOn(note.getLastModifiedOn());
        viewModel.setNotebookId(note.getNotebook().getId().toString());


        return viewModel;
    }

}
