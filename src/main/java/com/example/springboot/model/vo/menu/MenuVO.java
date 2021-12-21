package com.example.springboot.model.vo.menu;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
public class MenuVO {
	private Long id;
	private Long parentId;
	private String menuName;
	private int seq;
	private String useYn;
	private Date regDate;
	private String regId;
	private Date modDate;
	private String modId;

	private List<MenuVO> children = new ArrayList<>();
	public List<MenuVO> getChildren(Long parentId) {
		for(MenuVO vo : children) {
			vo.setParentId(parentId);
		}
		return children;
	}

	private void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Builder
	public MenuVO(String menuName, int seq, String useYn, List<MenuVO> children) {
		this.menuName = menuName;
		this.seq = seq;
		this.useYn = useYn;
		this.children = children;
	}
}
