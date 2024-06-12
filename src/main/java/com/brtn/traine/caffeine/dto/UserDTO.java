package com.brtn.traine.caffeine.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String dorsal;

}
