package com.chawy.edh_commander_test.service;

import com.chawy.edh_commander_test.model.Question;
import com.chawy.edh_commander_test.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getQuizQuestions() {
        return questionRepository.findOrderedQuestions();
    }
}
