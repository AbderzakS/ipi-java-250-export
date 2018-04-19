package com.example.demo.service.export;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.FactureDTO;


@Service
public class ExportXLSXService {
	
	public void export(ServletOutputStream servletOutputStream, List<ClientDTO> clients) throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("clients");
		XSSFRow headerRow = sheet.createRow(0);
		XSSFCell cellNom = headerRow.createCell(0);
		cellNom.setCellValue("Nom");
		XSSFCell cellPrenom = headerRow.createCell(1);
		cellPrenom.setCellValue("Prénom");
		XSSFCell cellAge = headerRow.createCell(2);
		cellAge.setCellValue("Age");
		XSSFCell cellAdresse = headerRow.createCell(3);
		cellAdresse.setCellValue("Adresse");
		
		Integer indexClient = 1;
		
		for(ClientDTO client : clients){
		XSSFRow row1 = sheet.createRow(indexClient);
		XSSFCell cell1 = row1.createCell(0);
		cell1.setCellValue(client.getNom());
		XSSFCell cell2 = row1.createCell(1);
		cell2.setCellValue(client.getPrenom());
		XSSFCell cell3 = row1.createCell(2);
		cell3.setCellValue(client.getAge());
		XSSFCell cell4 = row1.createCell(3);
		cell4.setCellValue(client.getAdresse());
        indexClient++;
		}
		
		workbook.write(servletOutputStream);
		workbook.close();
	}
	
	
	public void exportFacturesDUnClient(ServletOutputStream servletOutputStream, List<FactureDTO> factures) throws IOException{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("facture1");
		XSSFRow headerRow = sheet.createRow(0);
		XSSFCell cellNom = headerRow.createCell(0);
		cellNom.setCellValue("Nom");
		XSSFCell cellPrenom = headerRow.createCell(1);
		cellPrenom.setCellValue("Prénom");
		XSSFCell cellAge = headerRow.createCell(2);
		cellAge.setCellValue("Age");
		XSSFCell cellAdresse = headerRow.createCell(3);
		cellAdresse.setCellValue("Adresse");
		
		
		workbook.write(servletOutputStream);
		workbook.close();
	}
}
