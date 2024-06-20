package com.nhnacademy.batch.entity.member;


import com.nhnacademy.batch.entity.MemberAuth;
import com.nhnacademy.batch.entity.member.enums.Grade;
import com.nhnacademy.batch.entity.member.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    private String password;

    @NotNull
    private Long point;

    @NotNull
    @Size(min = 1, max = 10)
    private String name;

    private int age;

    @NotNull
    @Size(min = 1, max = 11)
    private String phone;

    @NotNull
    @Column(unique = true)
    private String email;

    private ZonedDateTime birthday;

    @NotNull
    private Grade grade;

    @NotNull
    private Status status;

    private ZonedDateTime last_login_date;

    @NotNull
    private ZonedDateTime created_at;

    private ZonedDateTime modified_at;
    private ZonedDateTime deleted_at;


    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<MemberAuth> memberAuthSet = new ArrayList<>();


}
