package com.example.demo_leave_management.controller;

import com.example.demo_leave_management.entity.Leave;
import com.example.demo_leave_management.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    /**
     * GET /api/leaves - Get all leaves
     */
    @GetMapping
    public ResponseEntity<List<Leave>> getAllLeaves() {
        List<Leave> leaves = leaveService.getAllLeaves();
        return ResponseEntity.ok(leaves);
    }

    /**
     * GET /api/leaves/{id} - Get leave by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<Leave> getLeaveById(@PathVariable Long id) {
        Optional<Leave> leave = leaveService.getLeaveById(id);
        if (leave.isPresent()) {
            return ResponseEntity.ok(leave.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * GET /api/leaves/employee/{employeeId} - Get leaves by employee ID
     */
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<Leave>> getLeavesByEmployeeId(@PathVariable String employeeId) {
        List<Leave> leaves = leaveService.getLeavesByEmployeeId(employeeId);
        return ResponseEntity.ok(leaves);
    }

    /**
     * GET /api/leaves/status/{status} - Get leaves by status
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Leave>> getLeavesByStatus(@PathVariable String status) {
        List<Leave> leaves = leaveService.getLeavesByStatus(status);
        return ResponseEntity.ok(leaves);
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<Map<String, Object>> getHello(@PathVariable String name) {
        Map<String, Obejct> response = new HashMap<>();
        String greeting = "Hello, " + name + "! Welcome to the Leave Management System.";
        response.put("message", greeting);
        return ResponseEntity.ok(response);
    }
}
