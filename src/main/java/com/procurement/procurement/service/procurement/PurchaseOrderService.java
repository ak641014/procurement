package com.procurement.procurement.service.procurement;

import com.procurement.procurement.entity.procurement.PurchaseOrder;
import com.procurement.procurement.entity.vendor.Vendor;
import com.procurement.procurement.repository.procurement.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    // ===================== Create new Purchase Order =====================
    public PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrder.setCreatedAt(LocalDateTime.now());
        purchaseOrder.setUpdatedAt(LocalDateTime.now());
        return purchaseOrderRepository.save(purchaseOrder);
    }

    // ===================== Update Purchase Order =====================
    public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder updatedPO) {

        PurchaseOrder po = purchaseOrderRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Purchase Order not found with id: " + id));

        po.setVendor(updatedPO.getVendor());
        po.setItems(updatedPO.getItems());
        po.setStatus(updatedPO.getStatus());
        po.setUpdatedAt(LocalDateTime.now());

        return purchaseOrderRepository.save(po);
    }

    // ===================== Get all Purchase Orders =====================
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    // ===================== Get Purchase Orders by Vendor =====================
    public List<PurchaseOrder> getPurchaseOrdersByVendor(Vendor vendor) {
        return purchaseOrderRepository.findByVendor(vendor);
    }

    // ===================== Get Purchase Orders by Status =====================
    public List<PurchaseOrder> getPurchaseOrdersByStatus(String status) {
        return purchaseOrderRepository.findByStatus(status);
    }

    // ===================== Get Purchase Order by PO Number =====================
    public PurchaseOrder getPurchaseOrderByPoNumber(String poNumber) {
        return purchaseOrderRepository.findByPoNumber(poNumber)
                .orElseThrow(() ->
                        new RuntimeException("Purchase Order not found with PO number: " + poNumber));
    }
}
