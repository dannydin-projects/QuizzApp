package com.sptech.Quiz_app_mono.service;

import com.sptech.Quiz_app_mono.Repository.QuestionRepo;
import com.sptech.Quiz_app_mono.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepo repo;


    public ResponseEntity<List<Question>> getAllQuestion() {
        try {
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Question>> findByCategory(String category) {
        try {
            return new ResponseEntity<>(repo.findByCategory(category),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        repo.save(question);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    public Optional<Question> deleteById(int qid) {
        Optional<Question> q = repo.findById(qid);
        repo.deleteById(qid);
        return q;


    }

    public Optional<Question> updateQuestion(Question question) {
        repo.save(question);
        return repo.findById(question.getId());
    }
}
