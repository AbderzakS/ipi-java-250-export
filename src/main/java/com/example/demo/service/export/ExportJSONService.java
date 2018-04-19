package com.example.demo.service.export;

import java.io.IOException;
import java.io.Writer;

import org.osgi.service.component.annotations.Component;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dto.ClientDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ExportJSONService {

	@Autowired
    private ObjectMapper objectMapper;

    public void export(Writer writer, ClientDTO client) throws IOException {
        objectMapper.writeValue(writer, client);
    }
}
