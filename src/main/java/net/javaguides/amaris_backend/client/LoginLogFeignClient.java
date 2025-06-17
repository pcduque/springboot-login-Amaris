package net.javaguides.amaris_backend.client;

import net.javaguides.amaris_backend.configuration.FeignClientConfig;
import net.javaguides.amaris_backend.dto.LoginLogDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;

public interface LoginLogFeignClient {

    @GetMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    LoginLogDto createLoginLog(@RequestParam("username") String username, @RequestParam("password") String password);
}
