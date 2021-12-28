package com.test.eid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.test.eid.dto.ResultMaximumIncreaseDto;
import com.test.eid.dto.TemperatureReadingsDto;
import com.test.eid.services.TemperatureService;

@SpringBootTest
class EidApplicationTests {

	@MockBean
	TemperatureReadingsDto temperatureReadingsDto;

	@Autowired
	TemperatureService service;

	@Test
	void EideMaximunIncreseTest() {
		int regarding[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		when(temperatureReadingsDto.getReadings()).thenReturn(regarding);

		ResultMaximumIncreaseDto resultMaximumIncreaseDto = service
				.maximumIncrease(temperatureReadingsDto.getReadings());

		assertEquals(9, resultMaximumIncreaseDto.getMaximumIncrease());

		verify(temperatureReadingsDto).getReadings();
	}

	@Test
	void EideMaximunIncreseMultipleCallTest() {
		int regarding[] = { 60, 1, 4, 8, 100 };
		when(temperatureReadingsDto.getReadings()).thenReturn(regarding);

		ResultMaximumIncreaseDto resultMaximumIncreaseDto = service
				.maximumIncrease(temperatureReadingsDto.getReadings());

		assertEquals(99, resultMaximumIncreaseDto.getMaximumIncrease());

		int regarding2[] = { 10, 15, 18, 1, 8 };
		when(temperatureReadingsDto.getReadings()).thenReturn(regarding2);

		resultMaximumIncreaseDto = service.maximumIncrease(temperatureReadingsDto.getReadings());

		assertEquals(8, resultMaximumIncreaseDto.getMaximumIncrease());

		verify(temperatureReadingsDto, times(2)).getReadings();
	}

	@Test
	void EideMaximunIncreseSameResultTest() {
		int regarding[] = { 60, 1, 4, 8, 100 };
		when(temperatureReadingsDto.getReadings()).thenReturn(regarding);

		ResultMaximumIncreaseDto resultMaximumIncreaseDto1 = service
				.maximumIncrease(temperatureReadingsDto.getReadings());

		ResultMaximumIncreaseDto resultMaximumIncreaseDto2 = service
				.maximumIncrease(temperatureReadingsDto.getReadings());

		assertSame(resultMaximumIncreaseDto1.getMaximumIncrease(), resultMaximumIncreaseDto2.getMaximumIncrease());

		verify(temperatureReadingsDto, times(2)).getReadings();
	}

}
