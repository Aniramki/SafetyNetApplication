package com.Aniramki.SafetyNet.repository;

import com.Aniramki.SafetyNet.model.Data;
import com.jsoniter.JsonIterator;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class DataHandler {

    private final Data data;

    public DataHandler() throws IOException {
        String temp = getFromResource("data.json");
        this.data = JsonIterator.deserialize(temp,Data.class);
    }

    private String getFromResource(String s) throws  IOException {
        InputStream is = new ClassPathResource(s).getInputStream();
        return new String(is.readAllBytes(), StandardCharsets.UTF_8);

    }

    public Data getData() {
        return data;
    }
}
