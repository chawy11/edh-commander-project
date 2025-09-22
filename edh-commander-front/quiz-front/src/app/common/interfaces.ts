export interface Question {
  id: number;
  questionText: string;
  orderIndex: number;
  answerOptions: AnswerOption[];
}

 interface AnswerOption {
  id: number;
  answerText: string;
  colorWeight: string | null;
  strategyWeight: string | null;
  popularityWeight: string | null;
}

export interface MonoCommander {
  id: number;
  comandante: string;
  color: string;
  popularidad: number;
  estrategias: string[];
  score: number;
}

export interface UserAnswers {
  favoriteColor: string;
  playStyle: string;
  budget: string;
}

