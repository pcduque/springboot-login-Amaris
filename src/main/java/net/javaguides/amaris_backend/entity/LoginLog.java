package net.javaguides.amaris_backend.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "login_log")
public class LoginLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="username")
    private String userName;

    @Column(name ="login_time")
    private String loginTime;

    @Column(name ="access_token")
    private String accessToken;

    @Column(name ="refresh_token")
    private String refreshToken;
}
