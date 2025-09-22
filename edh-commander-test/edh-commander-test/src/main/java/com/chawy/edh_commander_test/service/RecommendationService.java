package com.chawy.edh_commander_test.service;

import com.chawy.edh_commander_test.dto.UserAnswers;
import com.chawy.edh_commander_test.model.MonoCommander;
import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    public double calculateScore(MonoCommander commander, UserAnswers answers) {
        double score = 50.0;


        if (answers.getPlayStyle() != null && commander.getEstrategias() != null) {
            String playStyle = answers.getPlayStyle().toLowerCase();
            String strategies = String.join(", ", commander.getEstrategias()).toLowerCase();

            if (playStyle.equals("agresivo") &&
                    (strategies.contains("aggro") || strategies.contains("burn") || strategies.contains("tokens"))) {
                score += 50.0;
            } else if (playStyle.equals("control") &&
                    (strategies.contains("control") || strategies.contains("counterspells") || strategies.contains("removal"))) {
                score += 50.0;
            } else if (playStyle.equals("combo") &&
                    (strategies.contains("combo") || strategies.contains("infinite"))) {
                score += 50.0;
            } else if (playStyle.equals("temático") &&
                    (strategies.contains("tribal") || strategies.contains("theme"))) {
                score += 50.0;
            }
        }

        return score;
    }
}
