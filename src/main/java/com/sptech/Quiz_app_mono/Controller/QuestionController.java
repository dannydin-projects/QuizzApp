package com.sptech.Quiz_app_mono.Controller;


import com.sptech.Quiz_app_mono.model.Question;
import com.sptech.Quiz_app_mono.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){

        return service.getAllQuestion();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> byCategory(@PathVariable("category") String category){
        return service.findByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addquestion(@RequestBody Question question){
        return service.addQuestion(question);
    }

    @DeleteMapping("delete/{qid}")
    public Optional<Question> deleteById(@PathVariable int qid){
        return service.deleteById(qid);
    }

    @PutMapping("update")
    public Optional<Question> updateQuestion(@RequestBody Question question){
        return service.updateQuestion(question);
    }
}
