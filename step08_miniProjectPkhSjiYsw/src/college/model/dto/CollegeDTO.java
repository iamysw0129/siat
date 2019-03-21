package college.model.dto;

public class CollegeDTO {
	//변수 선언
	private String coll_name;
	private String dept_name;
	private String grad_qualification;
	private String prof_loc;
	private String dept_loc;
	
	public CollegeDTO() {}

	public CollegeDTO(String coll_name, String dept_name, String grad_qualification, String prof_loc, String dept_loc) {
		this.coll_name = coll_name;
		this.dept_name = dept_name;
		this.grad_qualification = grad_qualification;
		this.prof_loc = prof_loc;
		this.dept_loc = dept_loc;
	}
	
	public String getColl_name() {
		return coll_name;
	}

	public void setColl_name(String coll_name) {
		this.coll_name = coll_name;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getGrad_qualification() {
		return grad_qualification;
	}

	public void setGrad_qualification(String grad_qualification) {
		this.grad_qualification = grad_qualification;
	}

	public String getProf_loc() {
		return prof_loc;
	}

	public void setProf_loc(String prof_loc) {
		this.prof_loc = prof_loc;
	}

	public String getDept_loc() {
		return dept_loc;
	}

	public void setDept_loc(String dept_loc) {
		this.dept_loc = dept_loc;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ 단과대학: ");
		builder.append(coll_name);
		builder.append(", 학과명: ");
		builder.append(dept_name);
		builder.append(", 졸업 요건: ");
		builder.append(grad_qualification);
		builder.append(", 학과장 연구실: ");
		builder.append(prof_loc);
		builder.append(", 학과사무실: ");
		builder.append(dept_loc);
		builder.append(" ]");
		
		return builder.toString();
	}
	
}
