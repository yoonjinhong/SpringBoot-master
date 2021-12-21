package com.example.springboot.api.mapper.menu;

import com.example.springboot.model.vo.menu.MenuVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MenuMapper {
	/**
	 * 모든 메뉴 목록 조회
	 * @return
	 */
	List<MenuVO> findAll();

	/**
	 * 메뉴 상세 조회
	 * @param id 식별키
	 * @return
	 */
	Optional<MenuVO> findOneById(Long id);

	/**
	 * 상위 메뉴 목록 조회
	 * @param parentId 상위식별키
	 * @return
	 */
	List<MenuVO> findAllByParentId(Long parentId);

	/**
	 * 모든 메뉴 삭제
	 * @return
	 */
	int removeAll();

	/**
	 * 단일 메뉴 삭제
	 * @param id 식별키
	 * @return
	 */
	int removeById(Long id);

	/**
	 * 상위 메뉴 삭제
	 * @param parentId 삭제할 상위 메뉴 식별키
	 * @return
	 */
	int removeByParentId(Long parentId);

	/**
	 * 메뉴 저장
	 * @param vo 저장할 데이터
	 * @return
	 */
	int save(MenuVO vo);

	/**
	 * 다중 메뉴 저장
	 * @param vos 저장할 데이터 목록
	 * @return
	 */
	int saveAll(List<MenuVO> vos);
}
