package com.KAYAK.numberfrequencycalculatorapi.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NumberFrequencyCalculatorInputDto {
    @NotEmpty
    private List<Integer> data;
}
