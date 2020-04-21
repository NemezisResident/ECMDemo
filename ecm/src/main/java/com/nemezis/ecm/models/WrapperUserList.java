package com.nemezis.ecm.models;

import com.nemezis.models.UserDto;
import com.nemezis.models.Wrapper;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
public class WrapperUserList extends Wrapper<ArrayList<UserDto>> {
    public WrapperUserList(String message, ArrayList<UserDto> data) {
        super(message, data);
    }
}