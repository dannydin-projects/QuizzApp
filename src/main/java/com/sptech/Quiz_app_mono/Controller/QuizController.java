package com.sptech.Quiz_app_mono.Controller;

import com.sptech.Quiz_app_mono.model.QuestionWrapper;
import com.sptech.Quiz_app_mono.model.Responses;
import com.sptech.Quiz_app_mono.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService service;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ, @RequestParam String title){
        return service.createQuiz(category,numQ,title);
    }
    @GetMapping("getQuiz/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer quizId){
        return service.getQuiz(quizId);
    }
    @PostMapping("submit/{quizId}")
    public ResponseEntity<Integer> calculateResult(@PathVariable Integer quizId,@RequestBody List<Responses> res){
        return service.calculateResult(quizId,res);
    }
}
