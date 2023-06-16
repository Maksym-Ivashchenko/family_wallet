package com.example.familywallet.utilities;

import com.example.familywallet.user.UserDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class UtilitiesDto {

    private UUID uuid;
    private String name;
    private Integer cost;
    private Integer amount;
    private Integer total;
    private UserDto user;

}
