package com.bilgeadam.dto.request;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Getter
public class BaseRequestDto {

    String token;
}
