package com.example.springboot.api.controller.board;

import com.example.springboot.api.service.board.BoardService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Board")
@RestController
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
}
