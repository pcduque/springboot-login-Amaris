package net.javaguides.amaris_backend.controller;

import net.javaguides.amaris_backend.dto.LoginLogDto;
import net.javaguides.amaris_backend.service.LoginLogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class LoginLogControllerTest {

    private LoginLogService loginLogService;
    private LoginLogController loginLogController;

    @BeforeEach
    void setUp() {
        // Use a real (simple) implementation of LoginLogService
        loginLogService = new LoginLogService() {
            @Override
            public LoginLogDto createLoginLog(LoginLogDto loginLogDto) {
                return null;
            }
        };
        loginLogController = new LoginLogController(loginLogService);
    }

    @Test
    void createLoginLogTest() {
        LoginLogDto input = new LoginLogDto(1L, "username", "timestamp", "codigo1sf", "codifo2asd");
        ResponseEntity<LoginLogDto> response = loginLogController.createLoginLog(input);
        assertNotNull(response);
    }

}