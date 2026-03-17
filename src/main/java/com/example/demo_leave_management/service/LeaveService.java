package com.example.demo_leave_management.service;

import com.example.demo_leave_management.entity.Leave;
import com.example.demo_leave_management.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    /**
     * Get all leaves
     */
    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    /**
     * Get leave by ID
     */
    public Optional<Leave> getLeaveById(Long id) {
        return leaveRepository.findById(id);
    }

    /**
     * Get leaves by employee ID
     */
    public List<Leave> getLeavesByEmployeeId(String employeeId) {
        return leaveRepository.findByEmployeeId(employeeId);
    }

    /**
     * Get leaves by status
     */
    public List<Leave> getLeavesByStatus(String status) {
        return leaveRepository.findByStatus(status);
    }
}
