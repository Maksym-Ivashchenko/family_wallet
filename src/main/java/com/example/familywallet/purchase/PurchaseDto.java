package com.example.familywallet.purchase;

import com.example.familywallet.user.UserDto;
import com.example.familywallet.utilities.UtilitiesDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class PurchaseDto {

    private UUID uuid;
    private String name;
    private Integer cost;
    private Integer amount;
    private Integer total;
    private UserDto user;
    private UtilitiesDto utilities;

}
