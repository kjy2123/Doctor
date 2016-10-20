package com.doctors;

public class DoctorSpecialization {
	
	public Doctor getSpecialization(int id, String name, int review, Specialization specialization) {
		switch(specialization.speciality) {
			case "gynacologist" : return new Gynacologist(id, name, review);
			case "cardiologist" : return new Cardiologist(id, name, review);
			case "ophthomologist" : return new Ophthomologist(id, name, review);
			default: return null;
		}
	}
}
