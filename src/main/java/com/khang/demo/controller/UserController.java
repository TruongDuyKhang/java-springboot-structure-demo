package com.khang.demo.controller;

import com.khang.demo.dto.request.ApiResponse;
import com.khang.demo.dto.request.UserCreationRequest;
import com.khang.demo.dto.request.UserUpdateRequest;
import com.khang.demo.dto.response.UserResponse;
import com.khang.demo.entity.User;
import com.khang.demo.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    @PostMapping()
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<UserResponse> apiResponse= new ApiResponse<>();
        apiResponse.setResult(userService.createRequest(request));
        return apiResponse;
    }

    @GetMapping()
    ApiResponse<List<UserResponse>> getUsers(){
        var authentication= SecurityContextHolder.getContext().getAuthentication();
        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info());
        return ApiResponse<>
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable String userId){
        return  userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    UserResponse updateUser (@PathVariable String userId,  @RequestBody UserUpdateRequest request){
        return  userService.updateRequest(userId, request);
    }
    @DeleteMapping("/{userId}")
    String deleteUser (@PathVariable String userId){
        userService.deleteUser(userId);
        return "User has been deleted";
    }

}
