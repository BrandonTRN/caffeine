package com.brtn.traine.caffeine.repository;

import com.brtn.traine.caffeine.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
@Slf4j
public class UserRepository implements InitializingBean {

    private Map<String, UserDTO> userDB = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {

        userDB.put("pulga", UserDTO.builder().nombre("Leonel Andrés").apellidoPaterno("Messi").build());
        userDB.put("bicho", UserDTO.builder().nombre("Cristiano").apellidoPaterno("Ronaldo").build());
        userDB.put("chicharito", UserDTO.builder().nombre("Javier").apellidoPaterno("Hernández").build());
    }

    public UserDTO findByUserName(String userName) {
        log.info("Entro a consultar a repository");
        return Optional.ofNullable(userDB.get(userName)).orElseThrow(() -> new RuntimeException("user not found"));
    }
}
