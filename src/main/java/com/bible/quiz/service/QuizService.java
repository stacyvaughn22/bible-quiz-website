package com.bible.quiz.service;

import com.bible.quiz.dao.QuestionDao;
import com.bible.quiz.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuestionDao questionDao;

    public List<Question> getQuestions(String category) {
        List<Question> questionList;

        if (category.equals("All")) {
            questionList = questionDao.findAll();
        } else {
            questionList = questionDao.findByQtype(category);
        }
        return questionList;

    }

}
