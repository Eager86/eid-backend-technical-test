package com.test.eid.dto;

import java.io.Serializable;
import java.util.Objects;

public class ResultMaximumIncreaseDto implements Serializable {

	private static final long serialVersionUID = 7750456938117411810L;

	private int maximumIncrease;

	public ResultMaximumIncreaseDto(final int maximumIncrease) {
		super();
		this.maximumIncrease = maximumIncrease;
	}

	public int getMaximumIncrease() {
		return maximumIncrease;
	}

	public void setMaximumIncrease(final int maximumIncrease) {
		this.maximumIncrease = maximumIncrease;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maximumIncrease);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultMaximumIncreaseDto other = (ResultMaximumIncreaseDto) obj;
		return maximumIncrease == other.maximumIncrease;
	}

}
