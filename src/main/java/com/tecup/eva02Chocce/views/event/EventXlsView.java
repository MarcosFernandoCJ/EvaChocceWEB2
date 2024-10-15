package com.tecup.eva02Chocce.views.event;

import com.tecup.eva02Chocce.domain.entities.Event;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;
import java.util.Map;

@Component("/event/ver.xlsx")
public class EventXlsView extends AbstractXlsxView {

        @Override
        protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
                                          HttpServletResponse response) throws Exception {
            response.setHeader("Content-Disposition", "attachment; filename=\"events_view.xlsx\"");

            List<Event> events = (List<Event>) model.get("events");
            Sheet sheet = workbook.createSheet("Lista de Eventos");

            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("Lista de Eventos");

            // Estilos de encabezado
            CellStyle theaderStyle = workbook.createCellStyle();
            theaderStyle.setBorderBottom(BorderStyle.MEDIUM);
            theaderStyle.setBorderTop(BorderStyle.MEDIUM);
            theaderStyle.setBorderRight(BorderStyle.MEDIUM);
            theaderStyle.setBorderLeft(BorderStyle.MEDIUM);
            theaderStyle.setFillForegroundColor(IndexedColors.GOLD.index);
            theaderStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Estilos de cuerpo de la tabla
            CellStyle tbodyStyle = workbook.createCellStyle();
            tbodyStyle.setBorderBottom(BorderStyle.THIN);
            tbodyStyle.setBorderTop(BorderStyle.THIN);
            tbodyStyle.setBorderRight(BorderStyle.THIN);
            tbodyStyle.setBorderLeft(BorderStyle.THIN);

            // Crear encabezado de la tabla
            Row header = sheet.createRow(6);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Nombre");
            header.createCell(2).setCellValue("Descripcion");


            header.getCell(0).setCellStyle(theaderStyle);
            header.getCell(1).setCellStyle(theaderStyle);
            header.getCell(2).setCellStyle(theaderStyle);


            int rownum = 6;

            for (Event event : events) {
                Row fila = sheet.createRow(rownum++);

                cell = fila.createCell(0);
                cell.setCellValue(event.getId());
                cell.setCellStyle(tbodyStyle);

                cell = fila.createCell(1);
                cell.setCellValue(event.getName());
                cell.setCellStyle(tbodyStyle);

                cell = fila.createCell(2);
                cell.setCellValue(event.getDescription());
                cell.setCellStyle(tbodyStyle);


            }
        }
    }

