package com.apex.model;

import java.util.Objects;

import com.apex.exceptions.BaseWearFactorException;
import com.apex.exceptions.DifficultyException;
import com.apex.exceptions.LengthException;

public class TrackSection {
	private final String id;
	private final String name;
	private final double length;
	private final SectionType type;
	private final int difficulty;
	private final double baseWearFactor;

	public TrackSection(String id, String name, double length, SectionType type, int difficulty,
			double baseWearFactor) {
		if (length < 0)
			throw new LengthException("Length must be positive, but was: " + length);
		if (difficulty < 0 || difficulty > 10)
			throw new DifficultyException("Difficulty must be between 0 and 10, but was: " + difficulty);
		if (baseWearFactor < 0 || baseWearFactor > 1)
			throw new BaseWearFactorException("baseWearFactor must be between 0 and 1, but was: " + baseWearFactor);

		this.id = id;
		this.name = name;
		this.length = length;
		this.type = type;
		this.difficulty = difficulty;
		this.baseWearFactor = baseWearFactor;

	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getLength() {
		return length;
	}

	public SectionType getType() {
		return type;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public double getBaseWearFactor() {
		return baseWearFactor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrackSection other = (TrackSection) obj;
		return Objects.equals(id, other.id);
	}

	/*
	@Override
	public String toString() {
		return "TrackSection [id=" + id + ", name=" + name + ", length=" + length + ", type=" + type + ", difficulty="
				+ difficulty + ", baseWearFactor=" + baseWearFactor + "]";
	}
	*/
	
	// Alternative:
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("TrackSection [id=").append(id)
		  .append(", name=").append(name)
		  .append(", length=").append(length)
		  .append(", type=").append(type)
		  .append(", difficulty=").append(difficulty)
		  .append(", baseWearFactor=").append(baseWearFactor)
		  .append("]");
		
		return sb.toString();
	}
}