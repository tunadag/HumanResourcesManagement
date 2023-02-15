package com.bilgeadam.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@MappedSuperclass
public class Request {

    private String requestDate;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private RequestState requestState = RequestState.PENDING;
    @Builder.Default
    private String replyDate = null;
}
