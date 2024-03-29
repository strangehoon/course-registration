package com.strangehoon.courseregistration.domain;

import com.strangehoon.courseregistration.dto.BoardDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntityByBoard {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    private String author;

    private String title;

    private String content;

    public Board(BoardDto boardDto){
        this.id = boardDto.getId();
        this.author=boardDto.getAuthor();
        this.title=boardDto.getTitle();
        this.content=boardDto.getContent();
    }

    public void update(BoardDto boardDto) {
        this.id = boardDto.getId();
        this.author = boardDto.getAuthor();
        this.title = boardDto.getTitle();
        this.content = boardDto.getContent();
    }

}
