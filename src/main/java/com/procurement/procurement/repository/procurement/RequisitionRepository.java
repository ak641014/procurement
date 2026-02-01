package com.procurement.procurement.repository.procurement;

import com.procurement.procurement.entity.procurement.Requisition;
import com.procurement.procurement.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequisitionRepository extends JpaRepository<Requisition, Long> {

    // Find all requisitions by requested user
    List<Requisition> findByRequestedBy(User requestedBy);

    // Find all requisitions by status
    List<Requisition> findByStatus(String status);
}
