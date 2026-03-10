package com.back.question.entitiy;

import com.back.answer.entity.Answer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 20)
    private String subject;
    @Column(columnDefinition = "TEXT")
    private String content;
    @CreatedDate
    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Answer> answerList;

    public Question(String subject, String content, LocalDateTime createDate){
        this.subject = subject;
        this.content = content;
        this.createDate = createDate;
    }

}
