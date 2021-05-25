package com.akkurad.dashboard.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "owners")
public class Owner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 30, message = "username length doesn't.")
    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String phoneNumber;

    private String affiliation;
    private String imageUrl = "";
    @JsonIgnore
    private String password;

    @Column(unique = true)
    private String email;
    private boolean mailVerified = false;

    @ManyToOne(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private Organization organization;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Collection<Lockz> lockzs;

}