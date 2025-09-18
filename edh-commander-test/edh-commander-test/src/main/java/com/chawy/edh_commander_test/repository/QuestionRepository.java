package com.chawy.edh_commander_test.repository;

import com.chawy.edh_commander_test.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("SELECT q FROM Question q ORDER BY q.orderIndex ASC")
    List<Question> findOrderedQuestions();
}
