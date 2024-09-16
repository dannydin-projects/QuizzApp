package com.sptech.Quiz_app_mono.service;

import com.sptech.Quiz_app_mono.Repository.QuestionRepo;
import com.sptech.Quiz_app_mono.Repository.QuizRepo;
import com.sptech.Quiz_app_mono.model.Question;
import com.sptech.Quiz_app_mono.model.QuestionWrapper;
import com.sptech.Quiz_app_mono.model.Quiz;
import com.sptech.Quiz_app_mono.model.Responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionRepo quesRepo;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {


        List<Question> questions = quesRepo.getQuestionByCategory(category,numQ);

        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }


    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer quizId) {
        Optional<Quiz> quiz = quizRepo.findById(quizId);
        //getting list of ques for this quiz
        List<Question> quesFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> quesForUser = new ArrayList<>();

        //Converting to wrapper, hiding Answer
        for(Question q: quesFromDB){
            QuestionWrapper qw =
                    new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            quesForUser.add(qw);
        }
        return new ResponseEntity<>(quesForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer quizId, List<Responses> res) {
        Integer result =0;
        Quiz quiz = quizRepo.findById(quizId).get();
        List<Question> questions = quiz.getQuestions();

        int i=0;
        for(Responses r: res){
            if(r.getResponse().toLowerCase().equals(questions.get(i).getRightAnswer().toLowerCase())){
                result++;
            }
            i++;
        }

        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
