package com.sangheon.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column; // 테이블 컬럼
import javax.persistence.Entity; // 테이블과 링크 될 클래스
import javax.persistence.GeneratedValue; //PK 생성 규칙
import javax.persistence.GenerationType;
import javax.persistence.Id; // 해당 테이블의 PK 필드

@Getter // 클래스 내 모든 필드의 Gatter 메소드를 자동 생성
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity // Entity 클래스에서는 절대 Setter 메소드를 만들지 않는다.
public class Posts extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //
    private Long id;

    @Column(length = 500, nullable = false) //
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) //
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
