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
	private TemperatureReadingsDto temperatureReadingsDto;

	@Autowired
	private TemperatureService service;

	@Test
	void EidMaximunIncreseTest() {
		final int regarding[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		when(temperatureReadingsDto.getReadings()).thenReturn(regarding);

		final ResultMaximumIncreaseDto resultMaximumIncreaseDto = service
				.maximumIncrease(temperatureReadingsDto.getReadings());

		final int expectedResult = 9;
		assertEquals(expectedResult, resultMaximumIncreaseDto.getMaximumIncrease());

		verify(temperatureReadingsDto).getReadings();
	}

	@Test
	void EidMaximunIncreseNegativeTest() {
		final int regarding[] = { 3, 2, 1 };
		when(temperatureReadingsDto.getReadings()).thenReturn(regarding);

		final ResultMaximumIncreaseDto resultMaximumIncreaseDto = service
				.maximumIncrease(temperatureReadingsDto.getReadings());

		final int expectedResult = 0;
		assertEquals(expectedResult, resultMaximumIncreaseDto.getMaximumIncrease());

		verify(temperatureReadingsDto).getReadings();
	}
	
	@Test
	void EidMaximunIncreseWithReadingsTest() {
		final int regarding[] = {};
		when(temperatureReadingsDto.getReadings()).thenReturn(regarding);

		final ResultMaximumIncreaseDto resultMaximumIncreaseDto = service
				.maximumIncrease(temperatureReadingsDto.getReadings());

		final int expectedResult = 0;
		assertEquals(expectedResult, resultMaximumIncreaseDto.getMaximumIncrease());

		verify(temperatureReadingsDto).getReadings();
	}
	
	@Test
	void EidMaximunIncreseMultipleCallTest() {
		final int regardingCallOne[] = { 60, 1, 4, 8, 100 };
		when(temperatureReadingsDto.getReadings()).thenReturn(regardingCallOne);

		ResultMaximumIncreaseDto resultMaximumIncreaseDto = service
				.maximumIncrease(temperatureReadingsDto.getReadings());

		final int expectedResultCallOne = 99;
		assertEquals(expectedResultCallOne, resultMaximumIncreaseDto.getMaximumIncrease());

		final int regardingTestTwo[] = { 10, 15, 18, 1, 8 };
		when(temperatureReadingsDto.getReadings()).thenReturn(regardingTestTwo);

		resultMaximumIncreaseDto = service.maximumIncrease(temperatureReadingsDto.getReadings());

		final int expectedResultCallTwo = 8;
		assertEquals(expectedResultCallTwo, resultMaximumIncreaseDto.getMaximumIncrease());

		verify(temperatureReadingsDto, times(2)).getReadings();
	}

	@Test
	void EidMaximunIncreseSameResultTest() {
		final int regarding[] = { 60, 1, 4, 8, 100 };
		when(temperatureReadingsDto.getReadings()).thenReturn(regarding);

		final ResultMaximumIncreaseDto resultMaximumIncreaseDtoOne = service
				.maximumIncrease(temperatureReadingsDto.getReadings());

		final ResultMaximumIncreaseDto resultMaximumIncreaseDtoTwo = service
				.maximumIncrease(temperatureReadingsDto.getReadings());

		assertSame(resultMaximumIncreaseDtoOne.getMaximumIncrease(), resultMaximumIncreaseDtoTwo.getMaximumIncrease());

		verify(temperatureReadingsDto, times(2)).getReadings();
	}

}
