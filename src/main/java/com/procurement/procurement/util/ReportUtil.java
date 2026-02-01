package com.procurement.procurement.util;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportUtil {

    // ===================== Generate JasperPrint from data =====================
    public static JasperPrint generateJasperPrint(String reportPath, List<?> data, Map<String, Object> parameters) throws JRException {

        if (parameters == null) {
            parameters = new HashMap<>();
        }

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
        JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);

        // LTR is default, no need for JRParameter
        return JasperFillManager.fillReport(jasperReport, parameters, dataSource);
    }

    // ===================== Export JasperPrint to PDF =====================
    public static byte[] exportToPdf(JasperPrint jasperPrint) throws JRException {
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }

    // ===================== Export JasperPrint to Excel (XLSX) =====================
    public static byte[] exportToExcel(JasperPrint jasperPrint) throws JRException {
        JRXlsxExporter exporter = new JRXlsxExporter();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporter.exportReport();

        return outputStream.toByteArray();
    }
}
