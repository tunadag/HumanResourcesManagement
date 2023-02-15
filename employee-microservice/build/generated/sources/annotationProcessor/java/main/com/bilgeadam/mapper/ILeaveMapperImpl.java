package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.LeaveRequestDto;
import com.bilgeadam.dto.response.LeaveResponseDto;
import com.bilgeadam.repository.entity.Leave;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T16:38:32+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class ILeaveMapperImpl implements ILeaveMapper {

    @Override
    public Leave toLeave(LeaveRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Leave.LeaveBuilder<?, ?> leave = Leave.builder();

        leave.authId( dto.getAuthId() );
        leave.leaveType( dto.getLeaveType() );
        leave.startDate( dto.getStartDate() );
        leave.endDate( dto.getEndDate() );
        leave.leaveRequestText( dto.getLeaveRequestText() );

        return leave.build();
    }

    @Override
    public List<Leave> toLeaves(List<Leave> leaves) {
        if ( leaves == null ) {
            return null;
        }

        List<Leave> list = new ArrayList<Leave>( leaves.size() );
        for ( Leave leave : leaves ) {
            list.add( leave );
        }

        return list;
    }

    @Override
    public LeaveResponseDto toCreateLeaveResponseDto(Leave leave) {
        if ( leave == null ) {
            return null;
        }

        LeaveResponseDto.LeaveResponseDtoBuilder leaveResponseDto = LeaveResponseDto.builder();

        leaveResponseDto.leaveId( leave.getLeaveId() );
        leaveResponseDto.authId( leave.getAuthId() );
        leaveResponseDto.leaveType( leave.getLeaveType() );
        leaveResponseDto.startDate( leave.getStartDate() );
        leaveResponseDto.endDate( leave.getEndDate() );
        leaveResponseDto.leaveRequestText( leave.getLeaveRequestText() );
        leaveResponseDto.requestDate( leave.getRequestDate() );
        leaveResponseDto.leaveDay( leave.getLeaveDay() );
        leaveResponseDto.requestState( leave.getRequestState() );
        leaveResponseDto.replyDate( leave.getReplyDate() );

        return leaveResponseDto.build();
    }
}
