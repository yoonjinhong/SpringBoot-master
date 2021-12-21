package com.example.springboot.model.dto.menu;

import com.example.springboot.model.vo.menu.MenuVO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ResMenuSearchListDTO {
	private Long id;
	private Long parentId;
	private String menuName;
	private int seq;
	private List<ResMenuSearchListDTO> children;

	@Builder
	public ResMenuSearchListDTO(MenuVO vo) {
		this.id = vo.getId();
		this.parentId = vo.getParentId();
		this.menuName = vo.getMenuName();
		this.seq = vo.getSeq();
		this.children = vo.getChildren().stream()
				.map(ResMenuSearchListDTO::new)
				.collect(Collectors.toList());
	}
}
