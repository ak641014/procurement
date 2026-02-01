package com.procurement.procurement.dto.procurement;

import java.time.LocalDateTime;
import java.util.List;

public class PurchaseOrderResponseDTO {

    private String poNumber;
    private String vendorName;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Item> items;

    public static class Item {
        private String productName;
        private Integer quantity;
        private Double unitPrice;

        // Getters & Setters
        public String getProductName() {
            return productName;
        }
        public void setProductName(String productName) {
            this.productName = productName;
        }
        public Integer getQuantity() {
            return quantity;
        }
        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }
        public Double getUnitPrice() {
            return unitPrice;
        }
        public void setUnitPrice(Double unitPrice) {
            this.unitPrice = unitPrice;
        }
    }

    // Getters & Setters
    public String getPoNumber() {
        return poNumber;
    }
    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }
    public String getVendorName() {
        return vendorName;
    }
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
}
