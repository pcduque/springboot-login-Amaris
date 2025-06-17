package net.javaguides.amaris_backend.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginLogDto {

    private Long id;

    private String userName;

    private String loginTime;

    private String accessToken;

    private String refreshToken;
}
