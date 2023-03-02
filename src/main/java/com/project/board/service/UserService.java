package com.project.board.service;

import com.project.board.config.SHA256Util;
import com.project.board.dto.UserDto;
import com.project.board.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    String salt = SHA256Util.generateSalt();


    public List<UserDto> getUser() {

        return userMapper.selectUser();
    }

    public UserDto userNum (Integer userNum) {

        return userMapper.UserNum(userNum);
    }

    public UserDto loginInfo (UserDto userDto) {
        userDto.setUserPwd(SHA256Util.getEncrypt(userDto.getUserPwd(), salt));
        return userMapper.loginInfo(userDto);
    }

    public int insertUser (UserDto userDto) {
        String password = SHA256Util.getEncrypt(userDto.getUserPwd(), salt);
        userDto.setUserPwd(password);

        try {
            return userMapper.insertUser(userDto);
        } catch (Exception e) {
            return 0;
        }
    }

    public int updateUser (UserDto userDto) {

        return userMapper.updateUser(userDto);
    }

    public int deleteUser (UserDto userDto) {

        return userMapper.deleteUser(userDto);
    }
}
