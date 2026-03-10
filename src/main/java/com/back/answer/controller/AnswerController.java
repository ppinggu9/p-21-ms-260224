package com.back.answer.controller;

import com.back.answer.form.AnswerForm;
import com.back.answer.service.AnswerService;
import com.back.question.entitiy.Question;
import com.back.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createaAnswer(@PathVariable("id") Integer id,
                                @Valid AnswerForm answerForm, BindingResult bindingResult,
                                Model model) {
        Question question = questionService.getQuestion(id);
        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }
        answerService.create(question, answerForm.getContent());
        return "redirect:/question/detail/%d".formatted(id); // GET요청
    }

}
