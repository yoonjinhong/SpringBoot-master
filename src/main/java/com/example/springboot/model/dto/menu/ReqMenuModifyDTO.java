package com.example.springboot.model.dto.menu;

import com.example.springboot.common.annotation.enums.Enum;
import com.example.springboot.common.enums.YnValue;
import com.example.springboot.model.vo.menu.MenuVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ReqMenuModifyDTO {

	@Schema(description = "메뉴명", example = "메뉴1", required = true)
	@NotBlank
	private String menuName;

	@Schema(description = "메뉴순서", example = "1", required = true)
	@NotNull
	@Min(1)
	private int seq;

	@Schema(description = "사용유무(Y:사용, N:미사용)", example = "Y", required = true)
	@NotBlank
	@Enum(enumClass = YnValue.class, message = "useYn은 Y,N 값만 입력 가능합니다.")
	private String useYn;

	List<ReqMenuModifyDTO> children = new ArrayList<>();

	public MenuVO toVO() {
		return MenuVO.builder()
				.menuName(this.menuName)
				.seq(this.seq)
				.useYn(this.useYn)
				.children(this.children.stream()
						.map(ReqMenuModifyDTO::toVO)
						.collect(Collectors.toList()))
				.build();
	}

	@Getter
	@NoArgsConstructor
	public static class ModifyList {
		
		@Schema(description = "수정할 메뉴 목록", required = true, type = "array")
		@NotEmpty
		private List<@Valid ReqMenuModifyDTO> list = new ArrayList<>();
	}
}
