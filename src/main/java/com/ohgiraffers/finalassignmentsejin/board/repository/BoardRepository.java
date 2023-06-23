package com.ohgiraffers.finalassignmentsejin.board.repository;

import com.ohgiraffers.finalassignmentsejin.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Integer> {

    // 간단한 기능들은 JpaRepository안에 CRUD 레포에 있음
}
