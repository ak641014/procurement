// Requisition request DTO
package com.procurement.procurement.dto.procurement;

import java.util.List;

public class RequisitionRequestDTO {

    private String requisitionNumber;
    private Long requestedByUserId;
    private String status;  // e.g., PENDING, APPROVED
    private List<RequisitionItemDTO> items;

    public RequisitionRequestDTO() {
    }

    public RequisitionRequestDTO(String requisitionNumber, Long requestedByUserId, String status, List<RequisitionItemDTO> items) {
        this.requisitionNumber = requisitionNumber;
        this.requestedByUserId = requestedByUserId;
        this.status = status;
        this.items = items;
    }

    // ===================== Getters & Setters =====================
    public String getRequisitionNumber() {
        return requisitionNumber;
    }

    public void setRequisitionNumber(String requisitionNumber) {
        this.requisitionNumber = requisitionNumber;
    }

    public Long getRequestedByUserId() {
        return requestedByUserId;
    }

    public void setRequestedByUserId(Long requestedByUserId) {
        this.requestedByUserId = requestedByUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<RequisitionItemDTO> getItems() {
        return items;
    }

    public void setItems(List<RequisitionItemDTO> items) {
        this.items = items;
    }

    // ===================== Inner DTO for Requisition Items =====================
    public static class RequisitionItemDTO {
        private String itemName;
        private Integer quantity;
        private String description;

        public RequisitionItemDTO() {
        }

        public RequisitionItemDTO(String itemName, Integer quantity, String description) {
            this.itemName = itemName;
            this.quantity = quantity;
            this.description = description;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
