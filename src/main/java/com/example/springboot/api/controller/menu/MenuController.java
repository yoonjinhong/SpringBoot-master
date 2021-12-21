package com.example.springboot.api.controller.menu;

import com.example.springboot.api.service.menu.MenuService;
import com.example.springboot.common.response.success.SuccessCode;
import com.example.springboot.common.response.success.SuccessResponse;
import com.example.springboot.model.dto.menu.ReqMenuModifyDTO;
import com.example.springboot.model.dto.menu.ResMenuSearchDTO;
import com.example.springboot.model.dto.menu.ResMenuSearchListDTO;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "Menu")
@RequiredArgsConstructor
@RestController
public class MenuController {
	private final MenuService menuService;

	@Operation(summary = "메뉴 목록 조회", description = "사용중인 모든 메뉴를 조회한다.")
	@GetMapping("/api/v1/menu")
	public SuccessResponse<List<ResMenuSearchListDTO>> getAllMenu() {
		return new SuccessResponse<>(SuccessCode.OK, menuService.getAllMenu());
	}

	@Operation(summary = "단일 메뉴 조회", description = "단일 메뉴를 조회한다.")
	@GetMapping("/api/v1/menu/{id}")
	public SuccessResponse<ResMenuSearchDTO> getOneMenu(
			@Parameter(description = "식별키", required = true, example = "1, 2, 3, ...")
			@PathVariable("id") Long id) {
		return new SuccessResponse<>(SuccessCode.OK, menuService.getOneMenu(id));
	}

	@Operation(summary = "메뉴 수정", description = "메뉴를 수정한다.")
	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/api/v1/menu")
	public SuccessResponse modifyMenu(@RequestBody @Valid ReqMenuModifyDTO.ModifyList dto) {
		return new SuccessResponse<>(SuccessCode.MODIFIED, menuService.modifyMenu(dto));
	}

	@Operation(summary = "메뉴 삭제", description = "메뉴를 삭제한다.")
	@ResponseStatus(HttpStatus.CREATED)
	@DeleteMapping("/api/v1/menu/{id}")
	public SuccessResponse removeMenu(
			@Parameter(description = "식별키", required = true, example = "1, 2, 3, ...")
			@PathVariable("id") Long id) {
		menuService.removeMenu(id);
		return new SuccessResponse<>(SuccessCode.DELETED);
	}
}
