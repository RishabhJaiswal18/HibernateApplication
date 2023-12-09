package com.durgasoft.pojo;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "std_id")
	private int studentId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "address")
	private String address;

	@Column(name = "sex")
	private String sex;

	@Column(name = "standard")
	private String standard;

	@Column(name = "roll_no")
	private int rollNo;

	@Column(name = "marks")
	private int marks;

	@Column(name = "insertion_date")
	private Date insertionDate;

	@Column(name = "insertion_time")
	private Timestamp insertionTime;

	public Timestamp getInsertionTime() {
		return insertionTime;
	}

	public void setInsertionTime(Timestamp insertionTime) {
		this.insertionTime = insertionTime;
	}

	public Date getInsertionDate() {
		return insertionDate;
	}

	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", sex=" + sex + ", standard=" + standard + ", rollNo=" + rollNo + ", marks=" + marks
				+ ", insertionDate=" + insertionDate + ", insertionTime=" + insertionTime + "]";
	}
}
