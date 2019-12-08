package com.creatorschool.noteit.dao;
import com.creatorschool.noteit.model.Notebook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
public interface NotebookDAO extends JpaRepository<Notebook, UUID> {
}
