package com.ohgiraffers.finalassignmentsejin.board.service;

import com.ohgiraffers.finalassignmentsejin.board.repository.BoardRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    // 의존성 주입해야함
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;
    public BoardService(BoardRepository boardRepository, ModelMapper modelMapper) {
        this.boardRepository = boardRepository;
        this.modelMapper = modelMapper;
    }
}
