package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.AllowanceRequestDto;
import com.bilgeadam.repository.entity.Allowance;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-14T16:34:51+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.jar, environment: Java 17.0.6 (Amazon.com Inc.)"
)
@Component
public class IAllowanceMapperImpl implements IAllowanceMapper {

    @Override
    public Allowance toAllowance(AllowanceRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Allowance.AllowanceBuilder<?, ?> allowance = Allowance.builder();

        allowance.authId( dto.getAuthId() );
        allowance.allowanceType( dto.getAllowanceType() );
        allowance.amount( dto.getAmount() );
        allowance.currency( dto.getCurrency() );

        return allowance.build();
    }
}
