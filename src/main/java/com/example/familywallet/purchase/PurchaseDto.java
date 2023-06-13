package com.example.familywallet.purchase;

import com.example.familywallet.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
public class PurchaseDto {
    private UUID uuid;
    private String name;
    private List<User> users;
}
