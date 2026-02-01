// Report request DTO
package com.procurement.procurement.dto.report;

import java.time.LocalDate;

public class ReportRequestDTO {

    private Long vendorId;       // Optional: filter by vendor
    private Long poId;           // Optional: filter by purchase order
    private LocalDate startDate; // Optional: report start date
    private LocalDate endDate;   // Optional: report end date

    public ReportRequestDTO() {
    }

    public ReportRequestDTO(Long vendorId, Long poId, LocalDate startDate, LocalDate endDate) {
        this.vendorId = vendorId;
        this.poId = poId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // ===================== Getters & Setters =====================
    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getPoId() {
        return poId;
    }

    public void setPoId(Long poId) {
        this.poId = poId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
