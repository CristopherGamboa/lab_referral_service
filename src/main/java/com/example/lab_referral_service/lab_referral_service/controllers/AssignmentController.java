package com.example.lab_referral_service.lab_referral_service.controllers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.lab_referral_service.lab_referral_service.dtos.AssignmentRequestDTO;
import com.example.lab_referral_service.lab_referral_service.dtos.AssignmentResponseDTO;
import com.example.lab_referral_service.lab_referral_service.services.interfaces.IAssignmentService;

@RestController
@RequestMapping("/api/v1/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final IAssignmentService assignmentService;

    // Solo TECHNICIANs y ADMINs pueden crear asignaciones.
    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('TECHNICIAN')")
    public ResponseEntity<AssignmentResponseDTO> createAssignment(@Valid @RequestBody AssignmentRequestDTO requestDTO) {
        AssignmentResponseDTO newAssignment = assignmentService.createAssignment(requestDTO);
        return new ResponseEntity<>(newAssignment, HttpStatus.CREATED);
    }
    
    // Solo el ADMIN o el TECHNICIAN pueden consultar cualquier asignación.
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('TECHNICIAN')") 
    public ResponseEntity<AssignmentResponseDTO> getAssignmentById(@PathVariable Long id) {
        AssignmentResponseDTO assignment = assignmentService.getAssignmentById(id);
        return ResponseEntity.ok(assignment);
    }
}
