package com.tecup.eva02Chocce.views.score;
import java.awt.Color;
import java.util.List;
import java.util.Map;



import com.tecup.eva02Chocce.domain.entities.Score;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("/score/ver")

public class ScorePdfView extends AbstractPdfView{
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Score> scores = (List<Score>) model.get("scores");

        PdfPTable tabla = new PdfPTable(1);
        tabla.setSpacingAfter(20);

        PdfPCell cell = new PdfPCell(new Phrase("Lista de Puntajes"));
        cell.setBackgroundColor(new Color(184, 218, 255));
        cell.setPadding(8f);
        tabla.addCell(cell);

        PdfPTable tabla2 = new PdfPTable(4);  // Cambia el número de columnas según la estructura de Career
        tabla2.addCell("ID");
        tabla2.addCell("Carrera");
        tabla2.addCell("Puntaje");
        tabla2.addCell("Top");


        for(Score score : scores) {
            tabla2.addCell(String.valueOf(score.getId()));
            tabla2.addCell(score.getCareer());
            tabla2.addCell(String.valueOf(score.getScore()));
            tabla2.addCell(String.valueOf(score.getTop()));
        }

        document.add(tabla);
        document.add(tabla2);
    }
}
