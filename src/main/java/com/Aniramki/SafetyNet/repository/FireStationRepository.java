package com.Aniramki.SafetyNet.repository;

import com.Aniramki.SafetyNet.model.FireStation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FireStationRepository {

    private final DataHandler dataHandler;

    public FireStationRepository(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    public List<FireStation> findAllFS() {
        return dataHandler.getData().getFirestations();
    }
}
