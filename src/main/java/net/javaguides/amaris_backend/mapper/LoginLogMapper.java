package net.javaguides.amaris_backend.mapper;
import net.javaguides.amaris_backend.dto.LoginLogDto;
import net.javaguides.amaris_backend.entity.LoginLog;

public class LoginLogMapper {

    public static LoginLogDto mapToLoginLogDto(LoginLog loginLog){
        return new LoginLogDto(
                loginLog.getId(),
                loginLog.getUserName(),
                loginLog.getAccessToken(),
                loginLog.getRefreshToken(),
                loginLog.getLoginTime()
        );
    }

    public static LoginLog mapToLoginLog(LoginLogDto loginLogDto){
        return new LoginLog(
                loginLogDto.getId(),
                loginLogDto.getUserName(),
                loginLogDto.getAccessToken(),
                loginLogDto.getRefreshToken(),
                loginLogDto.getAccessToken()
        );
    }
}
