package com.example.travel.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "destination", uniqueConstraints = {
        @UniqueConstraint(name = "UNIQUE_destination_name", columnNames = "destinationName")
})


public class travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "destinationname", nullable = false)
    private String destinationname;

    @Column(name = "imageurl")
    private String imageurl;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "section")
    private String section;


}