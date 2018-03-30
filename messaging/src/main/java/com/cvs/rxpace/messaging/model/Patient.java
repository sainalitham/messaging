package com.cvs.rxpace.messaging.model;

import java.io.Serializable;

public class Patient implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Patient() {
		
	}
	
	public Patient(int patientId, String patientName) {
		this.patientId = patientId;
		this.patientName = patientName;
	}
	
	
	private int patientId;
	
	private String patientName;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	

}
