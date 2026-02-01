// Vendor repository
package com.procurement.procurement.repository.vendor;

import com.procurement.procurement.entity.vendor.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {

    // Find vendor by name
    Optional<Vendor> findByName(String name);

    // Find all vendors by status (ACTIVE/INACTIVE)
    List<Vendor> findByStatus(String status);

    // Check if vendor exists by name
    boolean existsByName(String name);

    List<Vendor> findByNameContainingIgnoreCase(String name);
}
