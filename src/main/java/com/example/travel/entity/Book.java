package com.example.travel.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="BOOKING")


public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "address", nullable = false)
    private String address;

    @ElementCollection
    @CollectionTable(name = "DESTINATIONS", joinColumns = @JoinColumn(name = "booking_id"))
    @Column(name = "destination")
    private List<String> destinations;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "BudgetAmount")
    private String BudgetAmount;


}

