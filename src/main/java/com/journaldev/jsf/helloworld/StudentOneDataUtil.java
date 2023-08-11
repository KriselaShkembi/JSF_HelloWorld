package com.journaldev.jsf.helloworld;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class StudentOneDataUtil {

	private List<StudentOne> studentOneList;
	
	public StudentOneDataUtil() {
		loadSampleData();
	}
	
	public void loadSampleData() {
		studentOneList = new ArrayList<>();

		studentOneList.add(new StudentOne("Mary", "Public", "mary@luv2code.com"));
		studentOneList.add(new StudentOne("John", "Doe", "john@luv2code.com"));
		studentOneList.add(new StudentOne("Ajay", "Rao", "ajay@luv2code.com"));
	}

	public List<StudentOne> getStudentOneList() {
		return studentOneList;
	}
}
