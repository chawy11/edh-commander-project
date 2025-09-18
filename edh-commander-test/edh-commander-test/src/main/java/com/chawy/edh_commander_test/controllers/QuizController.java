package com.chawy.edh_commander_test.controllers;


import com.chawy.edh_commander_test.model.Question;
import com.chawy.edh_commander_test.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/questions")
    public List<Question> getQuizQuestions() {
        return quizService.getQuizQuestions();
    }
}
