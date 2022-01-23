package com.example.img_test.controller;

import com.example.img_test.entity.Board;
import com.example.img_test.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {
    
    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<?> createBoard(
            @Validated @RequestParam("files") List<MultipartFile> files
    ) throws Exception {
        boardService.addBoard(Board.builder()
                .build(), files);

        return ResponseEntity.ok().build();
    }

}
