// Approval entity
package com.procurement.procurement.entity.procurement;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "approvals")
public class Approval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Approval linked to either Requisition or PurchaseOrder
    @ManyToOne
    @JoinColumn(name = "requisition_id")
    private Requisition requisition;

    @ManyToOne
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;

    @ManyToOne
    @JoinColumn(name = "approver_id")
    private com.procurement.procurement.entity.user.User approver;

    private String status; // PENDING, APPROVED, REJECTED
    private String comments;

    private LocalDateTime approvedAt;

    public Approval() {
    }

    public Approval(Requisition requisition, PurchaseOrder purchaseOrder, com.procurement.procurement.entity.user.User approver, String status, String comments, LocalDateTime approvedAt) {
        this.requisition = requisition;
        this.purchaseOrder = purchaseOrder;
        this.approver = approver;
        this.status = status;
        this.comments = comments;
        this.approvedAt = approvedAt;
    }

    // ===================== Getters & Setters =====================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Requisition getRequisition() {
        return requisition;
    }

    public void setRequisition(Requisition requisition) {
        this.requisition = requisition;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    public com.procurement.procurement.entity.user.User getApprover() {
        return approver;
    }

    public void setApprover(com.procurement.procurement.entity.user.User approver) {
        this.approver = approver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public LocalDateTime getApprovedAt() {
        return approvedAt;
    }

    public void setApprovedAt(LocalDateTime approvedAt) {
        this.approvedAt = approvedAt;
    }
}
