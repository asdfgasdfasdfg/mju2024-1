package univ;

public class Professor {
	public String name;
	public String department;
	public String lecture;
	
	public Professor(String name, String department, String lecture) {
		this.name = name;
		this.department = department;
		this.lecture = lecture;
	}
	
	public String getProfessorName() {
		return name;
	}
	
	public String getProfessorDepartment() {
		return department;
	}

	public String getProfessorLecture() {
		return lecture;
	}
}
