package com.ohgiraffers.finalassignmentsejin.board.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class BoardDTO implements Serializable {
    private String boardCode;
    private String boardName;
}
