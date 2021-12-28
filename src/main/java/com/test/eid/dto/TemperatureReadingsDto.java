package com.test.eid.dto;

import java.io.Serializable;
import java.util.Arrays;

public class TemperatureReadingsDto implements Serializable {

	private static final long serialVersionUID = 1971250230012304627L;

	private int[] readings;

	public int[] getReadings() {
		return readings;
	}

	public void setReadings(final int[] readings) {
		this.readings = readings;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(readings);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TemperatureReadingsDto other = (TemperatureReadingsDto) obj;
		return Arrays.equals(readings, other.readings);
	}

}
