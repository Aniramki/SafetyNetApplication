package com.Aniramki.SafetyNet.service.DTO;

import java.util.List;

public class AdultChildDto {

    public List<FireStationDto> getFireStationDtos() {
        return fireStationDtos;
    }

    public void setFireStationDtos(List<FireStationDto> fireStationDtos) {
        this.fireStationDtos = fireStationDtos;
    }

    private List<FireStationDto> fireStationDtos;
    private int adult;

    public int getAdult() {
        return adult;
    }

    public void setAdult(int adult) {
        this.adult = adult;
    }

    public int getChild() {
        return child;
    }

    public void setChild(int child) {
        this.child = child;
    }

    public AdultChildDto(int adult, int child, List<FireStationDto> fireStationDtos) {
        this.fireStationDtos =fireStationDtos;
        this.adult = adult;
        this.child = child;
    }

    private int child;

    public AdultChildDto(){}

}
