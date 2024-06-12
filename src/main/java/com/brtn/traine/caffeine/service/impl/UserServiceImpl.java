package com.brtn.traine.caffeine.service.impl;

import com.brtn.traine.caffeine.config.CacheConfig;
import com.brtn.traine.caffeine.dto.UserDTO;
import com.brtn.traine.caffeine.repository.UserRepository;
import com.brtn.traine.caffeine.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Cacheable(value = CacheConfig.USERS_INFO_CACHE, unless = "#result == null")
    public UserDTO findByUserName(String userName) {
        return this.userRepository.findByUserName(userName);
    }
}
