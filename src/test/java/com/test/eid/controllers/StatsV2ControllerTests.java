package com.test.eid.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.eid.dto.ResultMaximumIncreaseDto;
import com.test.eid.dto.TemperatureReadingsDto;
import com.test.eid.services.TemperatureServiceImpl;

@WebMvcTest(StatsV2Controller.class)
public class StatsV2ControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private TemperatureServiceImpl service;

	private ObjectMapper objectMapper;

	@BeforeEach
	void setUp() {
		objectMapper = new ObjectMapper();
	}

	@Test
	public void StatsComputePostTest() throws Exception {
		// Given
		final int maximumIncrease = 8;
		final ResultMaximumIncreaseDto result = new ResultMaximumIncreaseDto(maximumIncrease);
		final TemperatureReadingsDto dto = new TemperatureReadingsDto();
		dto.setReadings(new int[] { 10, 15, 18, 1, 8 });

		// When
		when(service.maximumIncrease(dto.getReadings())).thenReturn(result);
		mvc.perform(post("/v2/stats/compute").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(dto)))

				// Then
				.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.maximumIncrease").value(result.getMaximumIncrease()));

	}
}
