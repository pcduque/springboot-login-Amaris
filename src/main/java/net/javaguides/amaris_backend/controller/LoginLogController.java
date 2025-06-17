package net.javaguides.amaris_backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.amaris_backend.dto.LoginLogDto;
import net.javaguides.amaris_backend.service.LoginLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@AllArgsConstructor
@RestController
@RequestMapping("api/loginLog")
public class LoginLogController {

    private LoginLogService  loginLogService;

    @PostMapping
    public ResponseEntity<LoginLogDto> createLoginLog(@RequestBody LoginLogDto loginLogDto){
        LoginLogDto savedLoginLogDto = loginLogService.createLoginLog(loginLogDto);
        return new ResponseEntity<>(savedLoginLogDto, HttpStatus.CREATED);
    }
}
