package com.procurement.procurement.mapper;

import com.procurement.procurement.dto.procurement.RequisitionRequestDTO;
import com.procurement.procurement.entity.procurement.Requisition;
import com.procurement.procurement.entity.procurement.RequisitionItem;
import com.procurement.procurement.entity.user.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class RequisitionMapper {

    // ===================== Request DTO → Entity =====================
    public static Requisition toEntity(
            RequisitionRequestDTO dto,
            User requestedByUser
    ) {
        if (dto == null) return null;

        Requisition requisition = new Requisition();
        requisition.setRequisitionNumber(dto.getRequisitionNumber());
        requisition.setRequestedBy(requestedByUser);
        requisition.setStatus(dto.getStatus());
        requisition.setCreatedAt(LocalDateTime.now());
        requisition.setUpdatedAt(LocalDateTime.now());

        // Map items
        if (dto.getItems() != null) {
            List<RequisitionItem> items = dto.getItems()
                    .stream()
                    .map(itemDTO -> {
                        RequisitionItem item = new RequisitionItem();
                        item.setItemName(itemDTO.getItemName());
                        item.setQuantity(itemDTO.getQuantity());
                        item.setDescription(itemDTO.getDescription());
                        item.setRequisition(requisition);
                        return item;
                    })
                    .collect(Collectors.toList());

            requisition.setItems(items);
        }

        return requisition;
    }

    // ===================== Entity → DTO =====================
    public static RequisitionRequestDTO toDTO(Requisition requisition) {
        if (requisition == null) return null;

        RequisitionRequestDTO dto = new RequisitionRequestDTO();
        dto.setRequisitionNumber(requisition.getRequisitionNumber());
        dto.setStatus(requisition.getStatus());

        if (requisition.getRequestedBy() != null) {
            dto.setRequestedByUserId(requisition.getRequestedBy().getId());
        }

        if (requisition.getItems() != null) {
            dto.setItems(
                    requisition.getItems()
                            .stream()
                            .map(item -> new RequisitionRequestDTO.RequisitionItemDTO(
                                    item.getItemName(),
                                    item.getQuantity(),
                                    item.getDescription()
                            ))
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }
}
