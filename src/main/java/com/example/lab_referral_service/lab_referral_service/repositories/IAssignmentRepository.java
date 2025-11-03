package com.example.lab_referral_service.lab_referral_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lab_referral_service.lab_referral_service.models.Assignment;

public interface IAssignmentRepository extends JpaRepository<Assignment, Long> { }
