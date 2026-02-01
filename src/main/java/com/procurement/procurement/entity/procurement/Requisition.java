// Requisition entity
package com.procurement.procurement.entity.procurement;

import com.procurement.procurement.entity.user.User;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "requisitions")
public class Requisition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String requisitionNumber;

    @ManyToOne
    @JoinColumn(name = "requested_by")
    private User requestedBy;

    private String status; // PENDING, APPROVED, REJECTED, COMPLETED

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "requisition", cascade = CascadeType.ALL)
    private List<RequisitionItem> items;

    @OneToMany(mappedBy = "requisition", cascade = CascadeType.ALL)
    private List<Approval> approvals;

    public Requisition() {
    }

    public Requisition(String requisitionNumber, User requestedBy, String status, LocalDateTime createdAt, LocalDateTime updatedAt, List<RequisitionItem> items, List<Approval> approvals) {
        this.requisitionNumber = requisitionNumber;
        this.requestedBy = requestedBy;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.items = items;
        this.approvals = approvals;
    }

    // ===================== Getters & Setters =====================
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRequisitionNumber() {
        return requisitionNumber;
    }

    public void setRequisitionNumber(String requisitionNumber) {
        this.requisitionNumber = requisitionNumber;
    }

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
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

    public List<RequisitionItem> getItems() {
        return items;
    }

    public void setItems(List<RequisitionItem> items) {
        this.items = items;
    }

    public List<Approval> getApprovals() {
        return approvals;
    }

    public void setApprovals(List<Approval> approvals) {
        this.approvals = approvals;
    }
}
