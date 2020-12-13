package com.simbirsoft.spring_demo.mapper;

import com.simbirsoft.spring_demo.dto.UserDto;
import com.simbirsoft.spring_demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "password", ignore = true)
    })
    User toUser(UserDto userDto);
}
