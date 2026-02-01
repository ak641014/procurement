package com.procurement.procurement.mapper;

import com.procurement.procurement.dto.procurement.PurchaseOrderRequestDTO;
import com.procurement.procurement.dto.procurement.PurchaseOrderResponseDTO;
import com.procurement.procurement.entity.procurement.PurchaseOrder;
import com.procurement.procurement.entity.procurement.PurchaseOrderItem;
import com.procurement.procurement.entity.vendor.Vendor;

import java.util.stream.Collectors;

public class PurchaseOrderMapper {

    // ===================== Request DTO → Entity =====================
    public static PurchaseOrder toEntity(PurchaseOrderRequestDTO dto, Vendor vendor) {
        if (dto == null) return null;

        PurchaseOrder po = new PurchaseOrder();
        po.setPoNumber(dto.getPoNumber());
        po.setVendor(vendor);
        po.setStatus(dto.getStatus());

        // Map items
        if (dto.getItems() != null) {
            po.setItems(
                    dto.getItems().stream()
                            .map(itemDto -> {
                                PurchaseOrderItem item = new PurchaseOrderItem();
                                item.setProductName(itemDto.getProductName());
                                item.setQuantity(itemDto.getQuantity());
                                item.setUnitPrice(itemDto.getUnitPrice());
                                item.setPurchaseOrder(po);
                                return item;
                            })
                            .collect(Collectors.toList())
            );
        }

        return po;
    }

    // ===================== Entity → Response DTO =====================
    public static PurchaseOrderResponseDTO toResponseDTO(PurchaseOrder po) {
        if (po == null) return null;

        PurchaseOrderResponseDTO dto = new PurchaseOrderResponseDTO();
        dto.setPoNumber(po.getPoNumber());
        dto.setVendorName(po.getVendor() != null ? po.getVendor().getName() : null);
        dto.setStatus(po.getStatus());
        dto.setCreatedAt(po.getCreatedAt());
        dto.setUpdatedAt(po.getUpdatedAt());

        if (po.getItems() != null) {
            dto.setItems(po.getItems().stream()
                    .map(item -> {
                        PurchaseOrderResponseDTO.Item itemDto = new PurchaseOrderResponseDTO.Item();
                        itemDto.setProductName(item.getProductName());
                        itemDto.setQuantity(item.getQuantity());
                        itemDto.setUnitPrice(item.getUnitPrice());
                        return itemDto;
                    })
                    .collect(Collectors.toList()));
        }

        return dto;
    }
}
