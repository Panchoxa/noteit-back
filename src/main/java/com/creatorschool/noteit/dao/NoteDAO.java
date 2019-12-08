package com.creatorschool.noteit.dao;
import com.creatorschool.noteit.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface NoteDAO extends JpaRepository<Note, UUID> {
}
