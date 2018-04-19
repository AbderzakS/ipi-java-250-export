package com.example.demo.service.export;


import java.io.IOException;
import javax.servlet.ServletOutputStream;
import org.springframework.stereotype.Service;
import com.example.demo.dto.FactureDTO;
import com.example.demo.dto.LigneFactureDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class ExportPDFITextService {


	public void export(ServletOutputStream servletOutputStream, FactureDTO facture) throws IOException, DocumentException {
		Document document = new Document();
		PdfWriter.getInstance(document, servletOutputStream);
		document.open();
		
		document.add(new Paragraph("La Facture de " +  facture.getClient().getNom() + " " + facture.getClient().getPrenom()));
		document.add(new Paragraph(" "));
        PdfPTable table = new PdfPTable(4);
        table.addCell("Designation");
        table.addCell("Quantité");
        table.addCell("Prix Unitaire");
        table.addCell("Prix Total");
        
        Double total = 0.0;
        
        for (LigneFactureDTO ls : facture.getLigneFactures()) {
        table.addCell(""+ls.getDesignation());
        table.addCell(""+ls.getQuantite());
        table.addCell(""+ls.getPrixUnitaire());
        table.addCell(""+ls.getPrixUnitaire()*ls.getQuantite());
        total = ls.getPrixUnitaire()*ls.getQuantite() + total;
        }
        document.add(table);      
        document.add(new Paragraph("Votre facture est d'un montant de : " + total + "€"));
        document.close();
		
	}
}
