// Vendor service
package com.procurement.procurement.service.vendor;

import com.procurement.procurement.entity.vendor.Vendor;
import com.procurement.procurement.repository.vendor.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {

    @Autowired
    private VendorRepository vendorRepository;

    // ===================== Create new Vendor =====================
    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    // ===================== Update existing Vendor =====================
    public Vendor updateVendor(Long id, Vendor updatedVendor) {
        Optional<Vendor> optionalVendor = vendorRepository.findById(id);
        if (optionalVendor.isPresent()) {
            Vendor vendor = optionalVendor.get();
            vendor.setName(updatedVendor.getName());
            vendor.setEmail(updatedVendor.getEmail());
            vendor.setPhone(updatedVendor.getPhone());
            vendor.setAddress(updatedVendor.getAddress());
            vendor.setStatus(updatedVendor.getStatus());
            return vendorRepository.save(vendor);
        }
        throw new RuntimeException("Vendor not found with id: " + id);
    }

    // ===================== Get all Vendors =====================
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    // ===================== Get Vendor by ID =====================
    public Vendor getVendorById(Long id) {
        return vendorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendor not found with id: " + id));
    }

    // ===================== Search Vendors by Name =====================
    public List<Vendor> getVendorsByName(String name) {
        return vendorRepository.findByNameContainingIgnoreCase(name);
    }

    // ===================== Delete Vendor =====================
    public void deleteVendor(Long id) {
        Vendor vendor = getVendorById(id);
        vendorRepository.delete(vendor);
    }
}
