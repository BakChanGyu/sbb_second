package org.example.question;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.answer.Answer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 200)
    private String subject;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;

    // 자바 세상에서의 편의를 위해 생성
    // 테이블에 생성되지 않음! DB는 배열이나 리스트를 저장할 수 없다!
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList = new ArrayList<>();

    public void addAnswer(Answer a1) {

    }
}
