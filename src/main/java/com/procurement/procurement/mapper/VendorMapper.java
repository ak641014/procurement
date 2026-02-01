package com.procurement.procurement.mapper;

import com.procurement.procurement.dto.vendor.VendorRequestDTO;
import com.procurement.procurement.dto.vendor.VendorResponseDTO;
import com.procurement.procurement.entity.vendor.Vendor;
import com.procurement.procurement.entity.vendor.VendorRating;

import java.util.List;

public class VendorMapper {

    // ===================== Request DTO → Entity =====================
    public static Vendor toEntity(VendorRequestDTO dto) {
        if (dto == null) return null;

        Vendor vendor = new Vendor();
        vendor.setName(dto.getName());
        vendor.setEmail(dto.getEmail());
        vendor.setContactNumber(dto.getPhone()); // phone → contactNumber
        vendor.setAddress(dto.getAddress());
        vendor.setStatus(dto.getStatus());

        return vendor;
    }

    // ===================== Entity → Response DTO =====================
    public static VendorResponseDTO toResponseDTO(Vendor vendor) {
        if (vendor == null) return null;

        VendorResponseDTO dto = new VendorResponseDTO();
        dto.setId(vendor.getId());
        dto.setName(vendor.getName());
        dto.setEmail(vendor.getEmail());
        dto.setPhone(vendor.getContactNumber()); // contactNumber → phone
        dto.setAddress(vendor.getAddress());
        dto.setStatus(vendor.getStatus());

        // Optional: average rating
        dto.setRating(calculateAverageRating(vendor.getRatings()));

        // Optional: compliance (placeholder logic)
        dto.setCompliance(determineCompliance(vendor));

        return dto;
    }

    // ===================== Helper Methods =====================

    private static Double calculateAverageRating(List<VendorRating> ratings) {
        if (ratings == null || ratings.isEmpty()) return null;

        return ratings.stream()
                .mapToDouble(VendorRating::getRating)
                .average()
                .orElse(0.0);
    }

    private static String determineCompliance(Vendor vendor) {
        // Example logic – adjust as per business rules
        if ("ACTIVE".equalsIgnoreCase(vendor.getStatus())) {
            return "COMPLIANT";
        }
        return "NON_COMPLIANT";
    }
}
