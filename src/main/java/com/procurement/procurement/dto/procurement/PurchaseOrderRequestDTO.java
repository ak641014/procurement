package com.procurement.procurement.dto.procurement;

import java.util.List;

public class PurchaseOrderRequestDTO {

    private String poNumber;
    private Long vendorId; // For creating PO, send vendor ID
    private String status;

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
    public Long getVendorId() {
        return vendorId;
    }
    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
}
