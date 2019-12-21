package com.creatorschool.noteit;

import com.creatorschool.noteit.dao.NoteDAO;
import com.creatorschool.noteit.dao.NotebookDAO;
import com.creatorschool.noteit.model.Note;
import com.creatorschool.noteit.model.Notebook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


/**
 * This component will only execute (and get instantiated) if the
 * property noteit.db.recreate is set to true in the
 * application.properties file
 */

@Component
@ConditionalOnProperty(name = "noteit.db.recreate", havingValue = "true")
public class DbSeeder implements CommandLineRunner {

    private NotebookDAO notebookDAO;
    private NoteDAO noteDAO;

    public DbSeeder(NotebookDAO notebookDAO, NoteDAO noteDAO) {
        this.notebookDAO = notebookDAO;
        this.noteDAO = noteDAO;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started database initialization...");

        this.notebookDAO.deleteAll();
        this.noteDAO.deleteAll();

        Notebook defaultNotebook = new Notebook("Default");
        this.notebookDAO.save(defaultNotebook);

        Notebook quotesNotebook = new Notebook("Quotes");
        this.notebookDAO.save(quotesNotebook);

        Note note = new Note("Hello", "Welcome to Note It", defaultNotebook);
        this.noteDAO.save(note);

        Note quoteNote = new Note("Latin Quote", "Carpe Diem", quotesNotebook);
        this.noteDAO.save(quoteNote);

        System.out.println("Initialized database");

    }

}
