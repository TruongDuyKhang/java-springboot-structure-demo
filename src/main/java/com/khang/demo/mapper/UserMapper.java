package com.khang.demo.mapper;

import com.khang.demo.dto.request.UserCreationRequest;
import com.khang.demo.dto.request.UserUpdateRequest;
import com.khang.demo.dto.response.UserResponse;
import com.khang.demo.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);
    UserResponse toUserResponse(User user);
    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
