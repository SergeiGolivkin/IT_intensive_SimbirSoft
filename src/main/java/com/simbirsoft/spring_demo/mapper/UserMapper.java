package com.simbirsoft.spring_demo.mapper;


import com.simbirsoft.spring_demo.dto.request.CreateUserRequest;
import com.simbirsoft.spring_demo.dto.response.UserResponse;
import com.simbirsoft.spring_demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "password", ignore = true)
    })

    User toUser(CreateUserRequest createUserRequest);

    UserResponse toUserResponse(User user);
}
