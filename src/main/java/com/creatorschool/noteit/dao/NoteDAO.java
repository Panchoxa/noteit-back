package com.creatorschool.noteit.dao;
import com.creatorschool.noteit.model.Note;
import com.creatorschool.noteit.model.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface NoteDAO extends JpaRepository<Note, UUID> {
    List<Note> findAllByNotebook(Notebook notebook);
}
