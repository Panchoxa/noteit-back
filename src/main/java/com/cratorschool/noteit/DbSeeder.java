package com.cratorschool.noteit;
import com.cratorschool.noteit.dao.NoteDAO;
import com.cratorschool.noteit.dao.NotebookDAO;
import com.cratorschool.noteit.model.Note;
import com.cratorschool.noteit.model.Notebook;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
@Component
@ConditionalOnProperty(name = "noteit.db.recreate", havingValue = "true")//We
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
        Note note = new Note("Hello","Welcome tp Note it!", defaultNotebook );
        this.noteDAO.save(note);
        Note quoteNote = new Note("Latin Quote", "Carpe Diem", quotesNotebook);
        this.noteDAO.save(quoteNote);
        System.out.println("Initialized database");
    }
}
