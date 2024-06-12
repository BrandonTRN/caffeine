package com.brtn.traine.caffeine.service;

import com.brtn.traine.caffeine.dto.UserDTO;

public interface UserService {

    UserDTO findByUserName(String userName);
}
