import {Component, inject, OnInit} from '@angular/core';
import { QuizService } from '../../services/quiz.service';
import { Question, UserAnswers, MonoCommander } from '../../common/interfaces';
import {FormsModule} from '@angular/forms';
import {NgForOf, NgIf} from '@angular/common';


@Component({
  selector: 'app-inicio',
  standalone: true,
  templateUrl: './inicio.component.html',
  imports: [
    FormsModule,
    NgForOf,
    NgIf
  ],
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {
  questions: Question[] = [];
  userAnswers: UserAnswers = {
    favoriteColor: '',
    playStyle: '',
    budget: ''
  };
  recommendations: MonoCommander[] = [];
  showRecommendations = false;

  private readonly quizService = inject(QuizService);

  ngOnInit(): void {
    this.loadQuestions();
  }

  loadQuestions(): void {
    this.quizService.getQuestions().subscribe(
      questions => this.questions = questions
    );
  }

  onSubmit(): void {
    console.log('Enviando respuestas:', this.userAnswers); // Debug

    this.quizService.getRecommendations(this.userAnswers).subscribe({
      next: (recommendations) => {
        console.log('Recomendaciones recibidas:', recommendations); // Debug
        this.recommendations = recommendations;
        this.showRecommendations = true;
      },
      error: (error) => {
        console.error('Error al obtener recomendaciones:', error);
      }
    });
  }


  resetQuiz(): void {
    this.userAnswers = {
      favoriteColor: '',
      playStyle: '',
      budget: ''
    };
    this.recommendations = [];
    this.showRecommendations = false;
  }

}
