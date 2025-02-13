package com.Aniramki.SafetyNet.service.DTO;

import java.util.List;

public class FloodDto {
private String address;
private List<FireDto> fireDtoList;

    public FloodDto(String address, List<FireDto> fireDtoList) {
        this.address = address;
        this.fireDtoList = fireDtoList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<FireDto> getFireDtoList() {
        return fireDtoList;
    }

    public void setFireDtoList(List<FireDto> fireDtoList) {
        this.fireDtoList = fireDtoList;
    }

    public FloodDto() {}
}
