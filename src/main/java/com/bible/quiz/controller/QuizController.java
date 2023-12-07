package com.bible.quiz.controller;

import com.bible.quiz.model.Question;
import com.bible.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("/quiz")
    public List<Question> greeting(@RequestParam(name="category", required=false, defaultValue="all") String category, Model model) {
        model.addAttribute("name", category);
        return quizService.getQuestions(category);
    }

    @GetMapping("/questions")
    public List<Question> questions(@RequestParam(name="category", required=false, defaultValue="All") String category, Model model) {
        List<Question> questionList = quizService.getQuestions(category);
        model.addAttribute("questions", questionList);
        return questionList;
    }

}
