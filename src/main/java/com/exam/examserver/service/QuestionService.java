package com.exam.examserver.service;

import com.exam.examserver.entity.exam.Question;
import com.exam.examserver.entity.exam.Quiz;

import java.util.Set;

public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getQuestions();
    public Question getQuestion(Long questionId);
    public void deleteQuestion(Long questionId);
  public Set<Question> getQuestionOfQuiz(Quiz quiz);
}
