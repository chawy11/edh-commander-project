package com.chawy.edh_commander_test.controllers;

import com.chawy.edh_commander_test.dto.UserAnswers;
import com.chawy.edh_commander_test.model.MonoCommander;
import com.chawy.edh_commander_test.repository.MonoCommanderRepository;
import com.chawy.edh_commander_test.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CommanderController {

    @Autowired
    private MonoCommanderRepository monoCommanderRepository;

    @Autowired
    private RecommendationService recommendationService;


    @GetMapping("/api/mono-commanders")
    public List<MonoCommander> getAllMonoCommanders() {
        return monoCommanderRepository.findAll();
    }


    @GetMapping("/api/mono-commanders/{color}")
    public List<MonoCommander> getMonoCommandersByColor(@PathVariable String color) {
        return monoCommanderRepository.findByColor(color);
    }

    @PostMapping("/api/recommend")
    public List<MonoCommander> getRecommendations(@RequestBody UserAnswers userAnswers) {
        List<MonoCommander> allCommanders = monoCommanderRepository.findAll();

        List<MonoCommander> filteredCommanders = allCommanders.stream()
                .filter(commander -> {
                    if (userAnswers.getFavoriteColor() != null) {
                        return commander.getColor().equalsIgnoreCase(userAnswers.getFavoriteColor());
                    }
                    return true;
                })
                .collect(Collectors.toList());


        for(MonoCommander commander : filteredCommanders) {
            double score = recommendationService.calculateScore(commander, userAnswers);
            commander.setScore(score);
        }


        return filteredCommanders.stream()
                .sorted(Comparator.comparing(MonoCommander::getScore).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }


}
