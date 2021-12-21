package com.example.springboot.model.vo.board;

import lombok.Getter;

@Getter
public class BoardVO {
	private Long id;
	private Long menuId;
	private String title;
	private String content;
	private String regDate;

	public BoardVO() {

	}
	public void setIdInfo(Long id, Long menuId) {
		this.id = id;
		this.menuId = menuId;
	}
}
