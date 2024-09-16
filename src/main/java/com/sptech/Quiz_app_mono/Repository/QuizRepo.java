package com.sptech.Quiz_app_mono.Repository;

import com.sptech.Quiz_app_mono.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<Quiz,Integer> {
}
