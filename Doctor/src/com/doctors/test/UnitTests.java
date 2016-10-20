package com.doctors.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Test;
import com.doctors.Doctor;
import com.doctors.DoctorList;
import com.doctors.DoctorSpecialization;
import com.doctors.Specialization;

public class UnitTests {

	@Test
	public void AddDoctor() {
		DoctorSpecialization ds = new DoctorSpecialization();
		Doctor doc = ds.getSpecialization(1, "Ana", 100, new Specialization("cardiologist"));
		assertSame(1, doc.getId());
		assertSame("Ana", doc.getName());
		assertSame(100, doc.getReview());
		assertSame("cardiologist", doc.getSpecialization().getSpecilization());
	}
	
	@Test
	public void GetDoctors() {
		DoctorSpecialization ds = new DoctorSpecialization();
		Doctor doc1 = ds.getSpecialization(1, "Ana", 100, new Specialization("cardiologist"));
		Doctor doc2 = ds.getSpecialization(2, "Baity", 562, new Specialization("gynacologist"));
		Doctor doc3 = ds.getSpecialization(3, "Caty", 5, new Specialization("ophthomologist"));
		Doctor doc4 = ds.getSpecialization(4, "Dally", 895, new Specialization("cardiologist"));
		Doctor doc5 = ds.getSpecialization(5, "Emily", 12, new Specialization("gynacologist"));
		Doctor doc6 = ds.getSpecialization(6, "Emily", 45, new Specialization("ophthomologist"));
		Doctor doc7 = ds.getSpecialization(7, "John", 0, new Specialization("ophthomologist"));
		Doctor doc8 = ds.getSpecialization(8, "Sally", 452, new Specialization("gynacologist"));
		Doctor doc9 = ds.getSpecialization(9, "Sally", 5, new Specialization("gynacologist"));
		Doctor doc10 = ds.getSpecialization(10, "Sally", 8, new Specialization("gynacologist"));
		
		List<Doctor> docs = new ArrayList<Doctor>();
		docs.add(doc1);
		docs.add(doc2);
		docs.add(doc3);
		docs.add(doc4);
		docs.add(doc5);
		docs.add(doc6);
		docs.add(doc7);
		docs.add(doc8);
		docs.add(doc9);
		docs.add(doc10);
		
		DoctorList dl = new DoctorList();
		PriorityQueue<Doctor> result = dl.getRelatedDoctors(docs, doc2);
		assertNotSame(doc1, result.peek());
		assertSame(doc9, result.remove());
		assertSame(doc10, result.remove());
		assertSame(doc5, result.remove());
		assertSame(doc8, result.remove());
		assertSame(doc2, result.remove());
	}
	
	@Test
	public void negativeTest() {
		DoctorSpecialization ds = new DoctorSpecialization();
		Doctor doc1 = ds.getSpecialization(1, "Ana", 100, new Specialization("cardiologist"));
		Doctor doc2 = ds.getSpecialization(2, "Baity", 562, new Specialization("gynacologist"));
		Doctor doc3 = ds.getSpecialization(3, "Caty", 5, new Specialization("ophthomologist"));
		
		List<Doctor> docs = new ArrayList<Doctor>();
		docs.add(doc1);
		docs.add(doc2);
		docs.add(doc3);
		
		DoctorList dl = new DoctorList();
		PriorityQueue<Doctor> result = dl.getRelatedDoctors(docs, doc1);
		assertNotSame(doc2, result.peek());
		assertNotSame(doc3, result.peek());
	}
}
