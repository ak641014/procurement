package com.procurement.procurement.repository.procurement;

import com.procurement.procurement.entity.procurement.Approval;
import com.procurement.procurement.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovalRepository extends JpaRepository<Approval, Long> {

    // Find approvals by PurchaseOrder ID
    List<Approval> findByPurchaseOrderId(Long purchaseOrderId);

    // Find approvals by Requisition ID
    List<Approval> findByRequisitionId(Long requisitionId);

    // Find approvals by status
    List<Approval> findByStatus(String status);

    // Find approvals by approver (User entity)
    List<Approval> findByApprover(User approver);

    // Optional: find by approver username using JPQL
    // @Query("SELECT a FROM Approval a WHERE a.approver.username = :username")
    // List<Approval> findByApproverUsername(@Param("username") String username);
}
