package com.project.board.controller;

import com.project.board.config.SHA256Util;
import com.project.board.dto.UserDto;
import com.project.board.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userInfo")
    public String selectUser(Model model) {
        model.addAttribute("userList", userService.getUser());
        return "user/userInfo.html";
    }

    @GetMapping("/{userNum}")
    public String userNum(Model model, @PathVariable("userNum") Integer userNum) {
        model.addAttribute("user", userService.userNum(userNum));
        return "user/selectUser.html";
    }

    @GetMapping("/join")
    public String insertUser() {

        return "user/join.html";
    }

    @PostMapping("/join-pro")
    @ResponseBody
    public int userInsert(@RequestBody UserDto userDto) {

        return userService.insertUser(userDto);
    }

    @GetMapping("/login")
    public String userLogin(HttpSession session) {

        return "user/login.html";
    }

    @PostMapping("/login-pro")
    @ResponseBody
    public int loginUser(@RequestBody UserDto userDto, HttpSession session) {

        String pwd = userDto.getUserPwd();
        String newPwd = SHA256Util.getEncrypt(pwd, SHA256Util.generateSalt());

        UserDto userDto1 = userService.loginInfo(userDto);

        if (userDto1 != null) {
            session.setAttribute("userNum", userDto1.getUserNum());
            session.setAttribute("userName", userDto1.getUserName());
            return 1;
        } else {
            return 0;
        }

    }

    @GetMapping("/updateUser/{userNum}")
    public String updateUser(Model model, @PathVariable("userNum") Integer userNum) {
        model.addAttribute("user", userService.userNum(userNum));
        return "user/modify.html";
    }

    @PostMapping("/userUpdate")
    public String userUpdate(UserDto userDto) {
        userService.updateUser(userDto);
        return "user/modify-success.html";
    }

    @GetMapping("/remove/{userNum}")
    public String deleteUser(Model model, @PathVariable("userNum") Integer userNum) {
        model.addAttribute("user", userService.userNum(userNum));
        return "user/remove.html";
    }

    @PostMapping("/userDelete")
    public String userDelete(UserDto userDto) {
        userService.deleteUser(userDto);
        return "user/remove-success.html";
    }

    @GetMapping("/logout")
    public String logout() {
        return "user/logout.html";
    }

    @GetMapping("/main")
    public String home(HttpSession session) {
        System.out.println(session.getAttribute("userName"));
        return "main.html";
    }

}
