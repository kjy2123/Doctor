package com.doctors;

public class Ophthomologist implements Doctor {
	private int id;
	private String name;
	int review;
	private Specialization specialization;
	
	public Ophthomologist(int id, String name, int review) {
		this.id = id;
		this.name = name;
		this.review = review;
		this.specialization = new Specialization("ophthomologist");
	}
	
	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getReview() {
		return review;
	}

	@Override
	public Specialization getSpecialization() {
		return specialization;
	}

}
