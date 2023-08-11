package JSF_HelloWorld.src.main.java.com.journaldev.jsf.helloworld;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class StudentController {

	private List<Student> students;
	private StudentDbUtil studentDbUtil;
	private String theSearchName;
	private Logger logger = Logger.getLogger(getClass().getName());

	public StudentController() throws Exception {
		students = new ArrayList<>();
		studentDbUtil = StudentDbUtil.getInstance();
	}

	public List<Student> getStudents() {
		return students;
	}

	public String getTheSearchName() {
		return theSearchName;
	}

	public void setTheSearchName(String theSearchName) {
		this.theSearchName = theSearchName;
	}

	public void loadStudents() {
		logger.info("Loading students");
		logger.info("theSearchName " + theSearchName);
		students.clear();
		try {
			if (theSearchName != null && theSearchName.trim().length() > 0) {
				students = studentDbUtil.searchStudents(theSearchName);
			} else {
				students = studentDbUtil.getStudents();
			}
		} catch (Exception exc) {
			logger.log(Level.SEVERE, "Error loading students", exc);
			addErrorMessage(exc);
		} finally {
			theSearchName = null;
		}
	}

	public String addStudent(Student theStudent) {
		logger.info("Adding student: " + theStudent);
		try {
			studentDbUtil.addStudent(theStudent);
		} catch (Exception exc) {
			logger.log(Level.SEVERE, "Error adding students", exc);
			addErrorMessage(exc);
			return null;
		}
		return "list-students?faces-redirect=true";
	}

	public String loadStudent(int studentId) {
		logger.info("loading student: " + studentId);
		try {
			Student theStudent = studentDbUtil.getStudent(studentId);
			ExternalContext externalContext =
					FacesContext.getCurrentInstance().getExternalContext();
			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("student", theStudent);
		} catch (Exception exc) {
			logger.log(Level.SEVERE, "Error loading student id:" + studentId, exc);
			addErrorMessage(exc);
			return null;
		}

		return "update-student-form.xhtml";
	}

	public String updateStudent(Student theStudent) {
		logger.info("updating student: " + theStudent);
		try {
			studentDbUtil.updateStudent(theStudent);
		} catch (Exception exc) {
			logger.log(Level.SEVERE, "Error updating student: " + theStudent, exc);
			addErrorMessage(exc);
			return null;
		}
		return "list-students?faces-redirect=true";
	}

	public String deleteStudent(int studentId) {
		logger.info("Deleting student id: " + studentId);
		try {
			studentDbUtil.deleteStudent(studentId);
		} catch (Exception exc) {
			logger.log(Level.SEVERE, "Error deleting student id: " + studentId, exc);
			addErrorMessage(exc);
			return null;
		}
		return "list-students";
	}

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

}
