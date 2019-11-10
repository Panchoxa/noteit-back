package com.cratorschool.noteit.dao;
import com.cratorschool.noteit.model.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface NotebookDAO extends JpaRepository<Notebook, UUID> {
}
