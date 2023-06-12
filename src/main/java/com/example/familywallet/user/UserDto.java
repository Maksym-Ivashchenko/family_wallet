package com.example.familywallet.user;

import com.example.familywallet.role.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class UserDto {

    private UUID id;
    private String email;
    private String password;
    private String name;
    private List<Role> roles;
}
