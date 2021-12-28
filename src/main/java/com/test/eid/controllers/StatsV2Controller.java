package com.test.eid.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.eid.dto.ResultMaximumIncreaseDto;
import com.test.eid.dto.TemperatureReadingsDto;
import com.test.eid.exceptions.ComputeException;
import com.test.eid.services.TemperatureService;

@RestController
public class StatsV2Controller {

	private static final Logger logger = LoggerFactory.getLogger(StatsV2Controller.class);

	@Autowired
	private TemperatureService temperatureService;

	@PostMapping(path = "/v2/stats/compute", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<ResultMaximumIncreaseDto> compute(
			@RequestBody final TemperatureReadingsDto readings) throws ComputeException {
		logger.debug("Compute temperature regardings {}", readings.getReadings());
		try {
			final ResultMaximumIncreaseDto resultMaximumIncreaseDto = this.temperatureService
					.maximumIncrease(readings.getReadings());
			return ResponseEntity.ok(resultMaximumIncreaseDto);
		} catch (Exception e) {
			throw new ComputeException(e);
		}
	}

}
