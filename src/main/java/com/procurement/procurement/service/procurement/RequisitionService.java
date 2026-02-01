package com.procurement.procurement.service.procurement;

import com.procurement.procurement.entity.procurement.Requisition;
import com.procurement.procurement.entity.user.User;
import com.procurement.procurement.repository.procurement.RequisitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RequisitionService {

    @Autowired
    private RequisitionRepository requisitionRepository;

    // ===================== Create new Requisition =====================
    public Requisition createRequisition(Requisition requisition) {
        requisition.setCreatedAt(LocalDateTime.now());
        requisition.setUpdatedAt(LocalDateTime.now());
        return requisitionRepository.save(requisition);
    }

    // ===================== Update Requisition =====================
    public Requisition updateRequisition(Long id, Requisition updatedReq) {
        Requisition req = requisitionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Requisition not found with id: " + id));

        req.setRequisitionNumber(updatedReq.getRequisitionNumber());
        req.setRequestedBy(updatedReq.getRequestedBy());
        req.setItems(updatedReq.getItems());
        req.setStatus(updatedReq.getStatus());
        req.setUpdatedAt(LocalDateTime.now());

        return requisitionRepository.save(req);
    }

    // ===================== Get all Requisitions =====================
    public List<Requisition> getAllRequisitions() {
        return requisitionRepository.findAll();
    }

    // ===================== Get Requisitions by User =====================
    public List<Requisition> getRequisitionsByUser(User user) {
        return requisitionRepository.findByRequestedBy(user);
    }

    // ===================== Get Requisitions by Status =====================
    public List<Requisition> getRequisitionsByStatus(String status) {
        return requisitionRepository.findByStatus(status);
    }
}
