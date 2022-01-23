package com.example.img_test.controller;

import com.example.img_test.entity.Board;
import com.example.img_test.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BoardCheckController {

    private final BoardService boardService;

    @GetMapping("/board")
    public String getBoard(@RequestParam long id, Model model) {
        Board board = boardService.findBoard(id).orElseThrow(RuntimeException::new);
        String imgPath = board.getStoredFileName();
        log.info(imgPath);
        model.addAttribute("img", imgPath);
        return "board";
    }
}
