package com.example.travel.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class TravelDto {

    private Integer id;

    @NotNull
    private String destinationname;

    @NotNull
    private String imageurl;

    @NotNull
    private String price;

    @NotNull
    private String description;

    @NotNull
    private String category;

    @NotNull
    private String section;

}