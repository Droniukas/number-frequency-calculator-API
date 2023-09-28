package com.KAYAK.numberfrequencycalculatorapi.controllers;

import com.KAYAK.numberfrequencycalculatorapi.dtos.NumberFrequencyCalculatorInputDto;
import com.KAYAK.numberfrequencycalculatorapi.services.NumberFrequencyCalculatorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@WebMvcTest(controllers = NumberFrequencyCalculatorController.class)
@RunWith(SpringRunner.class)
class NumberFrequencyCalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NumberFrequencyCalculatorService numberFrequencyCalculatorService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void calculateNumberFrequency() throws Exception {
        NumberFrequencyCalculatorInputDto inputNumbers =
                NumberFrequencyCalculatorInputDto
                        .builder().data(Arrays.asList(1, 2, 3)).build();
        String inputNumbersJson = objectMapper.writeValueAsString(inputNumbers);

        String URI = "/api/numberFrequencyCalculator";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputNumbersJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult output = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = output.getResponse();

        String outputJson = response.getContentAsString();
        assertThat(outputJson).isEqualTo("Successful, check the API console!");
        assertThat(HttpStatus.OK.value()).isEqualTo(response.getStatus());
    }

}