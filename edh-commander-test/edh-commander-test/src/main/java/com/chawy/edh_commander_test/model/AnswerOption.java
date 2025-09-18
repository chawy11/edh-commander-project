package com.chawy.edh_commander_test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table (name = "answer_options")
public class AnswerOption {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "answer_text")
    private String answerText;

    @Column(name = "color_weight")
    private String colorWeight;

    @Column(name = "strategy_weight")
    private String strategyWeight;

    @Column(name = "popularity_weight")
    private String popularityWeight;

    @ManyToOne
    @JoinColumn(name = "question_id")
    @JsonIgnore
    private Question question;

    public AnswerOption() {
    }

    public AnswerOption(Integer id, String answerText, String colorWeight, String strategyWeight, String popularityWeight, Question question) {
        this.id = id;
        this.answerText = answerText;
        this.colorWeight = colorWeight;
        this.strategyWeight = strategyWeight;
        this.popularityWeight = popularityWeight;
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public String getColorWeight() {
        return colorWeight;
    }

    public void setColorWeight(String colorWeight) {
        this.colorWeight = colorWeight;
    }

    public String getStrategyWeight() {
        return strategyWeight;
    }

    public void setStrategyWeight(String strategyWeight) {
        this.strategyWeight = strategyWeight;
    }

    public String getPopularityWeight() {
        return popularityWeight;
    }

    public void setPopularityWeight(String popularityWeight) {
        this.popularityWeight = popularityWeight;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
