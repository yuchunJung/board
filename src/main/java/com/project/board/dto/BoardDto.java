package com.project.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BoardDto {

    private Long boardNum;
    private String boardTitle;
    private String boardContent;
    private Long boardWriter;
    private LocalDateTime boardDate;
    private Long boardCnt;

}
