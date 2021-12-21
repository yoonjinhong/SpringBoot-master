package com.example.springboot.api.mapper.board;

import com.example.springboot.model.vo.board.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
	List<BoardVO> findAll();
}
