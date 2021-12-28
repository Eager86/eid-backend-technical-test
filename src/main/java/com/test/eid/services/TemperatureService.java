package com.test.eid.services;

import com.test.eid.dto.ResultMaximumIncreaseDto;

public interface TemperatureService {

	public ResultMaximumIncreaseDto maximumIncrease(final int[] readings);
}
