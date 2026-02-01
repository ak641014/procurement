// Requisition controller
package com.procurement.procurement.controller.procurement;

import com.procurement.procurement.entity.procurement.Requisition;
import com.procurement.procurement.repository.procurement.RequisitionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/procurement/requisition")
public class RequisitionController {

    private final RequisitionRepository requisitionRepository;

    public RequisitionController(RequisitionRepository requisitionRepository) {
        this.requisitionRepository = requisitionRepository;
    }

    // ===================== Create Requisition =====================
    @PostMapping("/create")
    public ResponseEntity<Requisition> createRequisition(@RequestBody Requisition requisition) {
        requisition.setStatus("PENDING"); // Default status
        Requisition savedReq = requisitionRepository.save(requisition);
        return ResponseEntity.ok(savedReq);
    }

    // ===================== Get all Requisitions =====================
    @GetMapping("/all")
    public ResponseEntity<List<Requisition>> getAllRequisitions() {
        List<Requisition> requisitions = requisitionRepository.findAll();
        return ResponseEntity.ok(requisitions);
    }

    // ===================== Get Requisition by ID =====================
    @GetMapping("/{id}")
    public ResponseEntity<?> getRequisitionById(@PathVariable Long id) {
        Optional<Requisition> reqOpt = requisitionRepository.findById(id);
        if(reqOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Requisition not found");
        }
        return ResponseEntity.ok(reqOpt.get());
    }

    // ===================== Update Requisition Status =====================
    @PatchMapping("/update-status/{id}")
    public ResponseEntity<String> updateRequisitionStatus(@PathVariable Long id,
                                                          @RequestParam String status) {
        Optional<Requisition> reqOpt = requisitionRepository.findById(id);
        if(reqOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Requisition not found");
        }

        Requisition requisition = reqOpt.get();
        requisition.setStatus(status);
        requisitionRepository.save(requisition);

        return ResponseEntity.ok("Requisition status updated to " + status);
    }
}

