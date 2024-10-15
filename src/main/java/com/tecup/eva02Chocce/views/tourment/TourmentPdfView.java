package com.tecup.eva02Chocce.views.tourment;
import java.awt.Color;
import java.util.List;
import java.util.Map;



import com.tecup.eva02Chocce.domain.entities.Tourment;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("/tourment/ver")
public class TourmentPdfView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Tourment> tourments = (List<Tourment>) model.get("tourments");

        PdfPTable tabla = new PdfPTable(1);
        tabla.setSpacingAfter(20);

        PdfPCell cell = new PdfPCell(new Phrase("Lista de Puntajes"));
        cell.setBackgroundColor(new Color(184, 218, 255));
        cell.setPadding(8f);
        tabla.addCell(cell);

        PdfPTable tabla2 = new PdfPTable(4);  // Cambia el número de columnas según la estructura de Career
        tabla2.addCell("ID");
        tabla2.addCell("Nombre");
        tabla2.addCell("Ronda");
        tabla2.addCell("Tipo");


        for(Tourment tourment : tourments) {
            tabla2.addCell(String.valueOf(tourment.getId()));
            tabla2.addCell(tourment.getName());
            tabla2.addCell(String.valueOf(tourment.getRound()));
            tabla2.addCell(tourment.getType());
        }

        document.add(tabla);
        document.add(tabla2);
    }
}
