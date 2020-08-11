package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "id.user")
    private List<Candidate> candidates;

    @OneToMany(mappedBy = "id.user")
    private List<Submission> submissions;

    @NotNull
    @Size(min = 1, max = 100)
    private String fullName;

    @NotNull
    @Email
    @Size(min = 1, max = 100)
    private String email;

    @NotNull
    @Size(min = 1, max = 50)
    private String nickname;

    @NotNull
    @Size(min = 1, max = 255)
    private String password;

    @NotNull
    @CreatedDate
    private LocalDateTime createdAt;
}
