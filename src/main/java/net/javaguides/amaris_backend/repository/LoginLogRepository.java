package net.javaguides.amaris_backend.repository;

import net.javaguides.amaris_backend.entity.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LoginLogRepository extends JpaRepository<LoginLog,Long> {

}
