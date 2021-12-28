package com.test.eid.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.test.eid.dto.ResultMaximumIncreaseDto;

@Service
public class TemperatureServiceImpl implements TemperatureService {

	private static final Logger logger = LoggerFactory.getLogger(TemperatureService.class);

	public ResultMaximumIncreaseDto maximumIncrease(final int[] readings) {
		int maxDiff = readings[1] - readings[0];
		int minElement = readings[0];
		int i;
		for (i = 1; i < readings.length; i++) {
			if (readings[i] - minElement > maxDiff) {
				maxDiff = readings[i] - minElement;
			}
			if (readings[i] < minElement) {
				minElement = readings[i];
			}
		}
		logger.debug("Maximum Increase {} from regardings {}", maxDiff, readings);
		return new ResultMaximumIncreaseDto(maxDiff);
	}
}
