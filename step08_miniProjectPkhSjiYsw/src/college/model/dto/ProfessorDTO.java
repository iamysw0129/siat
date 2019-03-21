package college.model.dto;

import javax.crypto.spec.PSource;

public class ProfessorDTO {
	private String prof_name;
	private String dept_name;
	private String position;
	private String major;
	private String prof_loc;
	
	public ProfessorDTO() {}

	public ProfessorDTO(String prof_name, String dept_name, String position, String major, String prof_loc) {
		this.prof_name = prof_name;
		this.dept_name = dept_name;
		this.position = position;
		this.major = major;
		this.prof_loc = prof_loc;
	}

	public String getProf_name() {
		return prof_name;
	}

	public void setProf_name(String prof_name) {
		this.prof_name = prof_name;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getProf_loc() {
		return prof_loc;
	}

	public void setProf_loc(String prof_loc) {
		this.prof_loc = prof_loc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ 교수명: ");
		builder.append(prof_name);
		builder.append(", 소속 학과: ");
		builder.append(dept_name);
		builder.append(", 직위: ");
		builder.append(position);
		builder.append(", 전공과목: ");
		builder.append(major);
		builder.append(", 연구실: ");
		builder.append(prof_loc);
		builder.append(" ]");
		
		return builder.toString();
	}
	
	
	
	
	
	
	
}
