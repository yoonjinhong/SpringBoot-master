package com.example.springboot.model.dto.menu;

import com.example.springboot.model.vo.menu.MenuVO;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ResMenuModifyListDTO {
	private Long id;
	private Long parentId;
	private String menuName;
	private int seq;
	private String useYn;

	private List<ResMenuModifyListDTO> children;

	public ResMenuModifyListDTO(MenuVO vo) {
		this.id = vo.getId();
		this.parentId = vo.getParentId();
		this.menuName = vo.getMenuName();
		this.seq = vo.getSeq();
		this.useYn = vo.getUseYn();

		this.children = vo.getChildren().stream()
				.map(ResMenuModifyListDTO::new)
				.collect(Collectors.toList());
	}
}
