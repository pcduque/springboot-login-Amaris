package net.javaguides.amaris_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.amaris_backend.dto.LoginLogDto;
import net.javaguides.amaris_backend.entity.LoginLog;
import net.javaguides.amaris_backend.mapper.LoginLogMapper;
import net.javaguides.amaris_backend.repository.LoginLogRepository;
import net.javaguides.amaris_backend.service.LoginLogService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginLogServiceImpl implements LoginLogService {

    private LoginLogRepository loginLogRepository;

    @Override
    public LoginLogDto createLoginLog(LoginLogDto loginLogDto) {

        LoginLog loginLog = LoginLogMapper.mapToLoginLog(loginLogDto);
        LoginLog savedLogin = loginLogRepository.save(loginLog);
        return LoginLogMapper.mapToLoginLogDto(savedLogin);
    }
}
