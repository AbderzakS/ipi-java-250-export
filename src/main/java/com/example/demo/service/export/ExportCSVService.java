package com.example.demo.service.export;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ClientDTO;

@Service
public class ExportCSVService {

	public void export(Writer printWriter, List<ClientDTO> clients) throws IOException{
		printWriter.write("Nom;");
		printWriter.write("Prénom;");
		printWriter.write("Age;");
		printWriter.write("Adresse"+"\r\n");
		
		
		for(ClientDTO client : clients){
			printWriter.write(replace(client.getNom()));
			printWriter.write(";");
			printWriter.write(replace(client.getPrenom()));
			printWriter.write(";");
			printWriter.write(client.getAge().toString());
			printWriter.write(";");
			printWriter.write(client.getAdresse()+"\r\n");
		}
	}
	
	private String replace(String value) {
		value = value.replace("\"", "\"\"");
		if (value.contains(";")) {
			value = "\"" + value + "\"";
		}
		return value;
	}
}
