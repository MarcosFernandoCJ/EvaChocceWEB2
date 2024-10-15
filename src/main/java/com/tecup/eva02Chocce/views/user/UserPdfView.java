package com.tecup.eva02Chocce.views.user;

import java.awt.Color;
import java.util.List;
import java.util.Map;


import com.tecup.eva02Chocce.domain.entities.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("/usuario/ver")
public class UserPdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response) throws Exception {

        List<Usuario> usuarios = (List<Usuario>) model.get("usuarios");

        PdfPTable tabla = new PdfPTable(1);
        tabla.setSpacingAfter(20);

        PdfPCell cell = new PdfPCell(new Phrase("Lista de Usuarios"));
        cell.setBackgroundColor(new Color(184, 218, 255));
        cell.setPadding(8f);
        tabla.addCell(cell);

        PdfPTable tabla2 = new PdfPTable(4);  // Cambia el número de columnas según la estructura de Career
        tabla2.addCell("ID");
        tabla2.addCell("Nombre");
        tabla2.addCell("Email");
        tabla2.addCell("Password");


        for(Usuario usuario : usuarios) {
            tabla2.addCell(String.valueOf(usuario.getId()));
            tabla2.addCell(usuario.getName());
            tabla2.addCell(usuario.getEmail());
            tabla2.addCell(usuario.getPassword());
        }

        document.add(tabla);
        document.add(tabla2);
    }
}
