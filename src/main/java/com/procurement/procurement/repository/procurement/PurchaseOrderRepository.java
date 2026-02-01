// Purchase order repository
package com.procurement.procurement.repository.procurement;

import com.procurement.procurement.entity.procurement.PurchaseOrder;
import com.procurement.procurement.entity.vendor.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

    List<PurchaseOrder> findByVendor(Vendor vendor);

    List<PurchaseOrder> findByStatus(String status);

    Optional<PurchaseOrder> findByPoNumber(String poNumber);
}

