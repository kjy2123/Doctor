package com.doctors;

public class Cardiologist implements Doctor {
	private int id;
	private String name;
	private int review;
	private Specialization specialization;
	
	public Cardiologist(int id, String name, int review) {
		this.id = id;
		this.name = name;
		this.review = review;
		this.specialization = new Specialization("cardiologist");
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
