package com.develop.devcourse.domain.security.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "token")
public class Token {
    @Id
    @Column(name = "token_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;

    @Column(name = "token")
    private String token;

    @Column(name = "token_type")
    private String tokenType;

    @Column(name = "expiration_date")
    private LocalDateTime expirationDate;

    @Column(name = "expired")
    private boolean expired;

    @Column(name = "revoked")
    private boolean revoked;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "refresh_expiration_date")
    private LocalDateTime refreshExpirationDate;

    @Column(name = "is_mobile", columnDefinition = "TINYINT(1)")
    private boolean isMobile;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @JsonIgnore
    private Users user;

}
