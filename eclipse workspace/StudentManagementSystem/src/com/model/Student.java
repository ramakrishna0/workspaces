package com.model;

public class Student {
	private String studentId;
	private String studentpwd;
	private String studentName;
	private long mobileNo;
	private String age;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String studentId, String studentpwd, String studentName, long mobileNo, String age) {
		super();
		this.studentId = studentId;
		this.studentpwd = studentpwd;
		this.studentName = studentName;
		this.mobileNo = mobileNo;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentpwd=" + studentpwd + ", studentName=" + studentName
				+ ", mobileNo=" + mobileNo + ", age=" + age + "]";
	}

	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentpwd() {
		return studentpwd;
	}
	public void setStudentpwd(String studentpwd) {
		this.studentpwd = studentpwd;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	
	
}
