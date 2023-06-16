package com.example.familywallet.utilities;

import com.example.familywallet.user.UserConverter;

public class UtilitiesConverter {

    UserConverter userConverter = new UserConverter();

    public UtilitiesDto mapToDto(Utilities utilities) {
        UtilitiesDto dto = new UtilitiesDto();
        dto.setUuid(utilities.getUuid());
        dto.setName(utilities.getName());
        dto.setCost(utilities.getCost());
        dto.setAmount(utilities.getAmount());
        dto.setTotal(utilities.getTotal());
        dto.setUser(userConverter.mapToDto(utilities.getUser()));
        return dto;
    }

    public Utilities mapToDao(UtilitiesDto utilitiesDto) {
        Utilities dao = new Utilities();
        dao.setUuid(utilitiesDto.getUuid());
        dao.setName(utilitiesDto.getName());
        dao.setCost(utilitiesDto.getCost());
        dao.setAmount(utilitiesDto.getAmount());
        dao.setTotal(utilitiesDto.getTotal());
        dao.setUser(userConverter.mapToDao(utilitiesDto.getUser()));
        return dao;
    }
}
