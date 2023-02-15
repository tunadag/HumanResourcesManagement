package com.bilgeadam.controller;

import com.bilgeadam.dto.request.ApproveOrRejectLeaveRequestDto;
import com.bilgeadam.dto.request.LeaveRequestDto;
import com.bilgeadam.dto.response.LeaveResponseDto;
import com.bilgeadam.repository.entity.Leave;
import com.bilgeadam.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")
@RequiredArgsConstructor
public class LeaveController {

    private final LeaveService leaveService;

    @PostMapping("/request")
    public ResponseEntity<LeaveResponseDto> requestLeave(@RequestBody LeaveRequestDto dto){
        return ResponseEntity.ok(leaveService.createLeaveRequest(dto));
    }

    @PostMapping("/approve")
    public ResponseEntity<LeaveResponseDto> approveLeave(@RequestBody ApproveOrRejectLeaveRequestDto dto){
        return ResponseEntity.ok(leaveService.approveLeaveRequest(dto));
    }

    @PostMapping("/reject")
    public ResponseEntity<LeaveResponseDto> rejectLeave(@RequestBody ApproveOrRejectLeaveRequestDto dto){
        return ResponseEntity.ok(leaveService.rejectLeaveRequest(dto));
    }

    @GetMapping("/showLeaveRequests")
    public ResponseEntity<List<Leave>> showLeaveRequests(){
        return ResponseEntity.ok(leaveService.showLeaveRequests());
    }

}
