package com.example.familywallet.purchase;

public class PurchaseConverter {

    public PurchaseDto mapToDto(Purchase purchase) {
        PurchaseDto dto = new PurchaseDto();
        dto.setUuid(purchase.getUuid());
        dto.setName(purchase.getName());
        dto.setUsers(purchase.getUsers());
        return dto;
    }

    public Purchase mapToDao(PurchaseDto dto) {
        Purchase dao = new Purchase();
        dao.setUuid(dto.getUuid());
        dao.setName(dto.getName());
        dao.setUsers(dto.getUsers());
        return dao;
    }
}
