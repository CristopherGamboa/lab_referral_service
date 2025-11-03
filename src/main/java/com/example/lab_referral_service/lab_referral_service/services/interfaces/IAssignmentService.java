package com.example.lab_referral_service.lab_referral_service.services.interfaces;

import com.example.lab_referral_service.lab_referral_service.dtos.AssignmentRequestDTO;
import com.example.lab_referral_service.lab_referral_service.dtos.AssignmentResponseDTO;

public interface IAssignmentService {
    AssignmentResponseDTO createAssignment(AssignmentRequestDTO requestDTO);
    AssignmentResponseDTO getAssignmentById(Long assignmentId);
    AssignmentResponseDTO updateAssignment(Long assignmentId, AssignmentRequestDTO requestDTO);
    void deleteAssignment(Long assignmentId);
}
