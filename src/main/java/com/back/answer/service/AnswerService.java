package com.back.answer.service;

import com.back.answer.entity.Answer;
import com.back.answer.repository.AnswerRepository;
import com.back.question.entitiy.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public Answer create(Question question, String content) {
        Answer answer = new Answer(question, content);
        answerRepository.save(answer);
        return answer;
    }

    public List<Answer> findAll(){
        return answerRepository.findAll();
    }

}
