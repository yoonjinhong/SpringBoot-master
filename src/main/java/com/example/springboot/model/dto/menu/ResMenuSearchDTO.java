package com.example.springboot.model.dto.menu;

import com.example.springboot.model.vo.menu.MenuVO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ResMenuSearchDTO {
	private Long id;
	private Long parentId;
	private String menuName;
	private int seq;
	private String regDate;
	private String regId;
	private String modDate;
	private String modId;

	public ResMenuSearchDTO(MenuVO vo) {
		SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);

		this.id = vo.getId();
		this.parentId = vo.getParentId();
		this.menuName = vo.getMenuName();
		this.seq = vo.getSeq();
		this.regDate = simpleFormat.format(vo.getRegDate());
		this.regId = vo.getRegId();
		this.modDate = simpleFormat.format(vo.getModDate());
		this.modId = vo.getModId();
	}
}
