package com.project.board.mapper;

import com.project.board.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserDto> selectUser();

    UserDto UserNum (@Param("userNum") Integer userNum);

    UserDto loginInfo (UserDto userDto);

    int insertUser (UserDto userDto);

    int updateUser (UserDto userDto);

    int deleteUser (UserDto userDto);
}
