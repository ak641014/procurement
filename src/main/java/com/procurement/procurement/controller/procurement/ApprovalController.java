package com.procurement.procurement.controller.procurement;

import com.procurement.procurement.entity.procurement.Approval;
import com.procurement.procurement.entity.procurement.PurchaseOrder;
import com.procurement.procurement.entity.user.User;
import com.procurement.procurement.repository.procurement.ApprovalRepository;
import com.procurement.procurement.repository.procurement.PurchaseOrderRepository;
import com.procurement.procurement.repository.user.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/procurement/approval")
public class ApprovalController {

    private final ApprovalRepository approvalRepository;
    private final PurchaseOrderRepository purchaseOrderRepository;
    private final UserRepository userRepository;

    public ApprovalController(ApprovalRepository approvalRepository,
                              PurchaseOrderRepository purchaseOrderRepository,
                              UserRepository userRepository) {
        this.approvalRepository = approvalRepository;
        this.purchaseOrderRepository = purchaseOrderRepository;
        this.userRepository = userRepository;
    }

    // ===================== Get all approvals =====================
    @GetMapping("/all")
    public ResponseEntity<List<Approval>> getAllApprovals() {
        return ResponseEntity.ok(approvalRepository.findAll());
    }

    // ===================== Approve a Purchase Order =====================
    @PostMapping("/approve/{poId}")
    public ResponseEntity<String> approvePurchaseOrder(@PathVariable Long poId,
                                                       @RequestParam Long approverId) {
        Optional<PurchaseOrder> poOpt = purchaseOrderRepository.findById(poId);
        if (poOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Purchase Order not found");
        }

        PurchaseOrder po = poOpt.get();

        // Fetch User as approver
        Optional<User> userOpt = userRepository.findById(approverId);
        if (userOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Approver user not found");
        }
        User approver = userOpt.get();

        // Create Approval
        Approval approval = new Approval();
        approval.setPurchaseOrder(po);
        approval.setApprover(approver);
        approval.setStatus("APPROVED");
        approval.setApprovedAt(LocalDateTime.now());

        approvalRepository.save(approval);

        // Update PO status
        po.setStatus("APPROVED");
        purchaseOrderRepository.save(po);

        return ResponseEntity.ok("Purchase Order approved successfully");
    }

    // ===================== Reject a Purchase Order =====================
    @PostMapping("/reject/{poId}")
    public ResponseEntity<String> rejectPurchaseOrder(@PathVariable Long poId,
                                                      @RequestParam Long approverId,
                                                      @RequestParam String reason) {
        Optional<PurchaseOrder> poOpt = purchaseOrderRepository.findById(poId);
        if (poOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Purchase Order not found");
        }

        PurchaseOrder po = poOpt.get();

        // Fetch User as approver
        Optional<User> userOpt = userRepository.findById(approverId);
        if (userOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Approver user not found");
        }
        User approver = userOpt.get();

        // Create Approval
        Approval approval = new Approval();
        approval.setPurchaseOrder(po);
        approval.setApprover(approver);
        approval.setStatus("REJECTED");
        approval.setComments(reason);
        approval.setApprovedAt(LocalDateTime.now());

        approvalRepository.save(approval);

        // Update PO status
        po.setStatus("REJECTED");
        purchaseOrderRepository.save(po);

        return ResponseEntity.ok("Purchase Order rejected successfully");
    }
}
