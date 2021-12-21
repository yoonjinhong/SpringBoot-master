package com.example.springboot.api.service.board;

import com.example.springboot.api.mapper.board.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardMapper boardMapper;
}
