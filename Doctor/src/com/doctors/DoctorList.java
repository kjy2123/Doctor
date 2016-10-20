package com.doctors;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DoctorList {
	
	public PriorityQueue<Doctor> getRelatedDoctors(List<Doctor> docs, Doctor doc) {
		PriorityQueue<Doctor> queue = new PriorityQueue<Doctor>(new Comparator<Doctor>() {
			@Override
			public int compare(Doctor doc1, Doctor doc2) {
				
				return doc1.getReview() > doc2.getReview() ? 1 : -1;
			}
		});
		for (Doctor d : docs) {
			if (d.getSpecialization().getSpecilization().equals(doc.getSpecialization().getSpecilization())) {
				queue.add(d);
			}
		}
		
		return queue;
	}
}
