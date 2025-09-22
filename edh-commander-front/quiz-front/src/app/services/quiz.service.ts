import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {MonoCommander, Question, UserAnswers} from '../common/interfaces';
import {environment} from '../environment/environment';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  private readonly http: HttpClient = inject(HttpClient);

  getQuestions(): Observable<Question[]> {
    return this.http.get<Question[]>(environment.apiUrl + '/quiz/questions');  // ← Agrega /quiz
  }

  getRecommendations(userAnswers: UserAnswers): Observable<MonoCommander[]> {
    return this.http.post<MonoCommander[]>(environment.apiUrl + '/recommend', userAnswers);
    }


}
