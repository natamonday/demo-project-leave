package com.example.demo_leave_management.repository;

import com.example.demo_leave_management.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {
    List<Leave> findByEmployeeId(String employeeId);
    List<Leave> findByStatus(String status);
}
