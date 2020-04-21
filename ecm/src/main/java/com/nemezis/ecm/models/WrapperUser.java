package com.nemezis.ecm.models;

import com.nemezis.models.UserDto;
import com.nemezis.models.Wrapper;
import lombok.NoArgsConstructor;

/**
 *
 */
@NoArgsConstructor
public class WrapperUser extends Wrapper<UserDto> {

    public WrapperUser(String message, UserDto data) {
        super(message, data);
    }
}