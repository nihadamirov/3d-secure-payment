package com.securepayment.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "THREE_D_SECURE_DETAILS")
@Data
public class ThreeDSecureDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authentication_status")
    private String authenticationStatus;

    @Column(name = "eci")
    private String eci;

    @Column(name = "cavv")
    private String cavv;

    @Column(name = "xid")
    private String xid;

    @OneToOne(mappedBy = "threeDSecureDetails")
    private Payment payment;
}
