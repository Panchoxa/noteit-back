package com.creatorschool.noteit.api;
import com.creatorschool.noteit.Mapper;
import com.creatorschool.noteit.api.viewmodel.NotebookViewModel;
import com.creatorschool.noteit.dao.NotebookDAO;
import com.creatorschool.noteit.model.Notebook;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api/notebooks") //http:localhost:8080/api/notebooks
public class NotebookController {
    private NotebookDAO notebookDAO;
    private Mapper mapper;
    public NotebookController(NotebookDAO notebookDAO, Mapper mapper) {
        this.notebookDAO = notebookDAO;
        this.mapper = mapper;
    }
    @GetMapping("/all")
    public List<Notebook> all(){
        return notebookDAO.findAll();
    }
    @PostMapping
    public Notebook save(@RequestBody NotebookViewModel notebookViewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException();
        }
        Notebook notebookEntity = this.mapper.convertToNotebookEntity(notebookViewModel);
        this.notebookDAO.save(notebookEntity);
        return notebookEntity;
    }
}
