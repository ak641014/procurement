package com.procurement.procurement.controller.procurement;

import com.procurement.procurement.entity.procurement.PurchaseOrder;
import com.procurement.procurement.entity.procurement.PurchaseOrderItem;
import com.procurement.procurement.repository.procurement.PurchaseOrderRepository;
import com.procurement.procurement.repository.procurement.PurchaseOrderItemRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/procurement/purchase-order")
public class PurchaseOrderController {

    private final PurchaseOrderRepository purchaseOrderRepository;
    private final PurchaseOrderItemRepository purchaseOrderItemRepository;

    public PurchaseOrderController(PurchaseOrderRepository purchaseOrderRepository,
                                   PurchaseOrderItemRepository purchaseOrderItemRepository) {
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.purchaseOrderItemRepository = purchaseOrderItemRepository;
    }

    // ===================== Create Purchase Order =====================
    @PostMapping("/create")
    public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        // Save purchase order first
        PurchaseOrder po = purchaseOrderRepository.save(purchaseOrder);

        // Save items if present
        if (po.getItems() != null) {
            for (PurchaseOrderItem item : po.getItems()) {
                item.setPurchaseOrder(po);
                purchaseOrderItemRepository.save(item);
            }
        }

        return ResponseEntity.ok(po);
    }

    // ===================== Get all Purchase Orders =====================
    @GetMapping("/all")
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders() {
        List<PurchaseOrder> orders = purchaseOrderRepository.findAll();
        return ResponseEntity.ok(orders);
    }

    // ===================== Get Purchase Order by ID =====================
    @GetMapping("/{id}")
    public ResponseEntity<?> getPurchaseOrderById(@PathVariable Long id) {
        Optional<PurchaseOrder> poOpt = purchaseOrderRepository.findById(id);
        if (poOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Purchase Order not found");
        }
        return ResponseEntity.ok(poOpt.get());
    }

    // ===================== Update Purchase Order Status =====================
    @PatchMapping("/update-status/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable Long id,
                                               @RequestParam String status) {
        Optional<PurchaseOrder> poOpt = purchaseOrderRepository.findById(id);
        if (poOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Purchase Order not found");
        }

        PurchaseOrder po = poOpt.get();
        po.setStatus(status);
        purchaseOrderRepository.save(po);

        return ResponseEntity.ok("Purchase Order status updated to " + status);
    }
}
