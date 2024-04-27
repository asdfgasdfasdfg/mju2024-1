package univ;

import java.util.ArrayList;

public class Student {
	public int id;
	public String name;
	public ArrayList<String> lectureList;
	public int maxSizeLectureList;
	public int numOfLectureList;
	
	public Student(int max, int LectNum) {
		this.maxSizeLectureList = max;
		this.numOfLectureList = LectNum;
		this.lectureList = new ArrayList<>(max);
	}
	
	public Student(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public int getStudentId() {
		return id;
	}
	
	public String getStudentName() {
		return name;
	}
	
	public ArrayList<String> getLectureList() {
		return lectureList;
	}
	
	public void setStudentId(int id) {
		this.id = id;
	}
	
	public void setStudentName(String name) {
		this.name = name;
	}
	
	public void addNewLecture(String lecture) {
		this.lectureList.add(lecture);
	}
}
