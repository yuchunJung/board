package com.project.board.service;

import com.project.board.dto.BoardDto;
import com.project.board.dto.Criteria;
import com.project.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper boardMapper;

    public List<BoardDto> getBoard(Criteria cri) {

        return boardMapper.selectBoard(cri);
    }

    public int getTotal(Criteria cri) {

        return boardMapper.getTotal(cri);
    }

    public BoardDto boardNum(Integer id) {

        return boardMapper.boardNum(id);
    }

    public int insertBoard (BoardDto boardDto) {

        return boardMapper.insertBoard(boardDto);
    }

    public int updateBoard (BoardDto boardDto) {

        return boardMapper.updateBoard(boardDto);
    }

    public int deleteBoard (BoardDto boardDto) {

        return boardMapper.deleteBoard(boardDto);
    }

}
