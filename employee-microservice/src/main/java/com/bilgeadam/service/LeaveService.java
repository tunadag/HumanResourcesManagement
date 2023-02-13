package com.bilgeadam.service;

import com.bilgeadam.dto.request.ApproveOrRejectLeaveRequestDto;
import com.bilgeadam.dto.request.CreateLeaveRequestDto;
import com.bilgeadam.dto.response.CreateLeaveResponseDto;
import com.bilgeadam.mapper.ILeaveMapper;
import com.bilgeadam.repository.ILeaveRepository;
import com.bilgeadam.repository.entity.Leave;
import com.bilgeadam.repository.entity.LeaveState;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LeaveService {

    private final ILeaveRepository leaveRepository;

    public CreateLeaveResponseDto createLeaveRequest(CreateLeaveRequestDto dto){
        try {
            Leave leave = ILeaveMapper.INSTANCE.toLeave(dto);
            Leave leaveResponse = leaveRepository.save(leave);
            return ILeaveMapper.INSTANCE.toCreateLeaveResponseDto(leaveResponse);
        } catch (Exception ex){
            throw new RuntimeException("İzin talebiniz oluşturulamadı.");
        }
    }

    public List<Leave> showLeaveRequests(){
        return ILeaveMapper.INSTANCE.toLeaves(leaveRepository.findAll());
    }

    public CreateLeaveResponseDto approveLeaveRequest(ApproveOrRejectLeaveRequestDto dto){
        Optional<Leave> leaveToApprove = leaveRepository.findById(dto.getLeaveId());
        leaveToApprove.get().setLeaveState(LeaveState.APPROVED);
        leaveToApprove.get().setReplyDate(System.currentTimeMillis());
        leaveRepository.save(leaveToApprove.get());
        return ILeaveMapper.INSTANCE.toCreateLeaveResponseDto(leaveToApprove.get());
    }

    public CreateLeaveResponseDto rejectLeaveRequest(ApproveOrRejectLeaveRequestDto dto){
        Optional<Leave> leaveToReject = leaveRepository.findById(dto.getLeaveId());
        leaveToReject.get().setLeaveState(LeaveState.REJECTED);
        leaveToReject.get().setReplyDate(System.currentTimeMillis());
        leaveRepository.save(leaveToReject.get());
        return ILeaveMapper.INSTANCE.toCreateLeaveResponseDto(leaveToReject.get());
    }
}
