package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persistent_logins")
@Getter
@Setter
public class PersistentLogin {
    @Id
    @Column(name = "Series", length = 64, nullable = false)
    private String series;

    @Column(name = "Username", length = 64, nullable = false)
    private String userName;

    @Column(name = "Token", length = 64, nullable = false)
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Last_Used", nullable = false)
    private Date lastUsed;
}
