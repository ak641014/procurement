package com.procurement.procurement.repository.audit;

import com.procurement.procurement.entity.audit.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    // Find audit logs by entity type
    List<AuditLog> findByEntityName(String entityName);

    // Fix: use 'performedBy' instead of 'createdBy'
    List<AuditLog> findByPerformedBy(String performedBy);

    // Find audit logs by entity type and ID
    List<AuditLog> findByEntityNameAndEntityId(String entityName, Long entityId);

}
