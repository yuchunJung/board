package com.project.board.mapper;

import com.project.board.dto.BoardDto;
import com.project.board.dto.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDto> selectBoard(Criteria cri);

    int getTotal(Criteria cri);

    BoardDto boardNum (@Param("id") Integer id);

    int insertBoard (BoardDto boardDto);

    int updateBoard (BoardDto boardDto);

    int deleteBoard (BoardDto boardDto);
}
