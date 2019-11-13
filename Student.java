package jiu;

public class Student {
	private String studentNum;
	private String studentName;
	private String studentgender;
	public String getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(String num) {
		this.studentNum=num;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName =studentName;
	}
	public String getStudentgender() {
		return studentgender;
	}
	public void setStudentgender(String gender) {
		this.studentgender =gender;
	}
	public String toString() {
		return "学号："+this.getStudentNum()+"\n名字："+this.getStudentName()+"\n性别："+this.getStudentgender();
		
	}
	
}
