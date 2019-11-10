package com.cratorschool.noteit.dao;

import com.cratorschool.noteit.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteDAO extends JpaRepository<Note, UUID> {
}
