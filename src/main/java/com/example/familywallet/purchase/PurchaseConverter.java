package com.example.familywallet.purchase;

import com.example.familywallet.user.UserConverter;
import com.example.familywallet.utilities.UtilitiesConverter;

public class PurchaseConverter {

    UserConverter userConverter = new UserConverter();
    UtilitiesConverter utilitiesConverter = new UtilitiesConverter();

    public PurchaseDto mapToDto(Purchase purchase) {
        PurchaseDto dto = new PurchaseDto();
        dto.setUuid(purchase.getUuid());
        dto.setName(purchase.getName());
        dto.setCost(purchase.getCost());
        dto.setAmount(purchase.getAmount());
        dto.setTotal(purchase.getTotal());
        dto.setUser(userConverter.mapToDto(purchase.getUser()));
        dto.setUtilities(utilitiesConverter.mapToDto(purchase.getUtilities()));
        return dto;
    }

    public Purchase mapToDao(PurchaseDto purchaseDto) {
        Purchase dao = new Purchase();
        dao.setUuid(purchaseDto.getUuid());
        dao.setName(purchaseDto.getName());
        dao.setCost(purchaseDto.getCost());
        dao.setAmount(purchaseDto.getAmount());
        dao.setTotal(purchaseDto.getTotal());
        dao.setUser(userConverter.mapToDao(purchaseDto.getUser()));
        dao.setUtilities(utilitiesConverter.mapToDao(purchaseDto.getUtilities()));
        return dao;
    }
}
