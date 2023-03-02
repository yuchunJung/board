package com.project.board.controller;

import com.project.board.dto.BoardDto;
import com.project.board.dto.Criteria;
import com.project.board.dto.PageDto;
import com.project.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/boardPage")
@RequiredArgsConstructor
public class BoardPageController {

    private final BoardService boardService;

    @GetMapping ("/{boardNum}")
    public String boardNum(Model model, @PathVariable("boardNum") Integer boardNum) {
        model.addAttribute("board", boardService.boardNum(boardNum));
        return "board/selectBoard.html";
    }

    @GetMapping ("/boardList")
    public String selectBoard(Model model, Criteria cri) {
        model.addAttribute("boardList", boardService.getBoard(cri));
        int total = boardService.getTotal(cri);

        PageDto pageMaker = new PageDto(cri, total);
        model.addAttribute("pageMaker", pageMaker);

        return "board/selectBoardAll.html";
    }

    @GetMapping ("/insertBoard")
    public String insertBoard () {
        return "board/insertBoard.html";
    }

    @PostMapping ("/boardInsert")
    public String boardInsert(BoardDto boardDto) {
        boardService.insertBoard(boardDto);
        return "board/insert-success.html";
    }

    @GetMapping ("/updateBoard/{boardNum}")
    public String updateBoard (Model model, @PathVariable("boardNum") Integer boardNum) {
        model.addAttribute("board", boardService.boardNum(boardNum));
        return "board/updateBoard.html";
    }

    @PostMapping ("/boardUpdate")
    public String boardUpdate(BoardDto boardDto) {
        boardService.updateBoard(boardDto);
        return "board/update-success.html";
    }

    @GetMapping ("/deleteBoard/{boardNum}")
    public String deleteBoard (Model model, @PathVariable("boardNum") Integer boardNum) {
        model.addAttribute("board", boardService.boardNum(boardNum));
        return "board/deleteBoard.html";
    }

    @PostMapping ("/boardDelete")
    public String boardDelete (BoardDto boardDto) {
        boardService.deleteBoard(boardDto);
        return "board/delete-success.html";
    }

}
