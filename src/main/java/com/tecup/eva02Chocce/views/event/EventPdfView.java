package com.tecup.eva02Chocce.views.event;
import java.awt.Color;
import java.util.List;
import java.util.Map;


import com.tecup.eva02Chocce.domain.entities.Event;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("/event/ver")
public class EventPdfView extends AbstractPdfView{

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Event> events = (List<Event>) model.get("events");

        PdfPTable tabla = new PdfPTable(1);
        tabla.setSpacingAfter(20);

        PdfPCell cell = new PdfPCell(new Phrase("Lista de Eventos"));
        cell.setBackgroundColor(new Color(184, 218, 255));
        cell.setPadding(8f);
        tabla.addCell(cell);

        PdfPTable tabla2 = new PdfPTable(3);  // Cambia el número de columnas según la estructura de Career
        tabla2.addCell("ID");
        tabla2.addCell("Evento");
        tabla2.addCell("Descripción");


        for(Event event : events) {
            tabla2.addCell(String.valueOf(event.getId()));
            tabla2.addCell(event.getName());
            tabla2.addCell(event.getDescription());
        }

        document.add(tabla);
        document.add(tabla2);
    }
}
