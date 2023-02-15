package com.bilgeadam.service;

import com.bilgeadam.dto.request.ApproveOrRejectLeaveRequestDto;
import com.bilgeadam.dto.request.LeaveRequestDto;
import com.bilgeadam.dto.response.LeaveResponseDto;
import com.bilgeadam.mapper.ILeaveMapper;
import com.bilgeadam.repository.ILeaveRepository;
import com.bilgeadam.repository.entity.Leave;
import com.bilgeadam.repository.entity.RequestState;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class LeaveService {

    private final ILeaveRepository leaveRepository;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    public LeaveService(ILeaveRepository leaveRepository) {
        super();
        this.leaveRepository = leaveRepository;
    }

    public LeaveResponseDto createLeaveRequest(LeaveRequestDto dto){
        try {
            Leave leave = ILeaveMapper.INSTANCE.toLeave(dto);
            leave.setRequestDate(sdf.format(new Date(System.currentTimeMillis())));
            leave.setLeaveDay(TimeUnit.MILLISECONDS.toDays(
                    sdf.parse(dto.getEndDate()).getTime()-sdf.parse(dto.getStartDate()).getTime()) %24);
            leaveRepository.save(leave);
            return ILeaveMapper.INSTANCE.toCreateLeaveResponseDto(leave);
        } catch (Exception ex){
            throw new RuntimeException("İzin talebiniz oluşturulamadı.");
        }
    }

    public List<Leave> showLeaveRequests(){
        return ILeaveMapper.INSTANCE.toLeaves(leaveRepository.findAll());
    }

    public LeaveResponseDto approveLeaveRequest(ApproveOrRejectLeaveRequestDto dto){
        Optional<Leave> leaveToApprove = leaveRepository.findById(dto.getLeaveId());
        leaveToApprove.get().setRequestState(RequestState.APPROVED);
        leaveToApprove.get().setReplyDate(sdf.format(new Date(System.currentTimeMillis())));
        leaveRepository.save(leaveToApprove.get());
        return ILeaveMapper.INSTANCE.toCreateLeaveResponseDto((Leave) leaveToApprove.get());
    }

    public LeaveResponseDto rejectLeaveRequest(ApproveOrRejectLeaveRequestDto dto){
        Optional<Leave> leaveToReject = leaveRepository.findById(dto.getLeaveId());
        leaveToReject.get().setRequestState(RequestState.REJECTED);
        leaveToReject.get().setReplyDate(sdf.format(new Date(System.currentTimeMillis())));
        leaveRepository.save(leaveToReject.get());
        return ILeaveMapper.INSTANCE.toCreateLeaveResponseDto((Leave) leaveToReject.get());
    }
}
