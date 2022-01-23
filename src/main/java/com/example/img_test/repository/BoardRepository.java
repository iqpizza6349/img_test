package com.example.img_test.repository;

import com.example.img_test.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Board save(Board board);

    List<Board> findAllByBoardIdx(Long boardIdx);

}
