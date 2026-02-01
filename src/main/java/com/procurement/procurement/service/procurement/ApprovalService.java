// Approval service
package com.procurement.procurement.service.procurement;

import com.procurement.procurement.entity.procurement.Approval;
import com.procurement.procurement.repository.procurement.ApprovalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprovalService {

    @Autowired
    private ApprovalRepository approvalRepository;

    // ===================== Create new approval =====================
    public Approval createApproval(Approval approval) {
        return approvalRepository.save(approval);
    }

    // ===================== Update approval status =====================
    public Approval updateApprovalStatus(Long approvalId, String status) {
        Optional<Approval> optionalApproval = approvalRepository.findById(approvalId);
        if (optionalApproval.isPresent()) {
            Approval approval = optionalApproval.get();
            approval.setStatus(status);
            return approvalRepository.save(approval);
        }
        throw new RuntimeException("Approval not found with id: " + approvalId);
    }

    // ===================== Get all approvals =====================
    public List<Approval> getAllApprovals() {
        return approvalRepository.findAll();
    }

    // ===================== Get approvals by PurchaseOrder ID =====================
    public List<Approval> getApprovalsByPurchaseOrderId(Long purchaseOrderId) {
        return approvalRepository.findByPurchaseOrderId(purchaseOrderId);
    }

    // ===================== Get approvals by Requisition ID =====================
    public List<Approval> getApprovalsByRequisitionId(Long requisitionId) {
        return approvalRepository.findByRequisitionId(requisitionId);
    }
}
