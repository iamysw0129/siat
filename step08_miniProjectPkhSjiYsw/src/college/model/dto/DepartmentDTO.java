package college.model.dto;

public class DepartmentDTO {
	private String dept_name;
	private int capactiy;
	private int first;
	private int second;
	private int third;
	private int forth;
	
	public DepartmentDTO() {}

	public DepartmentDTO(String dept_name, int capactiy, int first, int second, int third, int forth) {
		this.dept_name = dept_name;
		this.capactiy = capactiy;
		this.first = first;
		this.second = second;
		this.third = third;
		this.forth = forth;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public int getCapactiy() {
		return capactiy;
	}

	public void setCapactiy(int capactiy) {
		this.capactiy = capactiy;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getThird() {
		return third;
	}

	public void setThird(int third) {
		this.third = third;
	}

	public int getForth() {
		return forth;
	}

	public void setForth(int forth) {
		this.forth = forth;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[ 학과명: ");
		builder.append(dept_name);
		builder.append(", 정원: ");
		builder.append(capactiy);
		builder.append("명, 1학년: ");
		builder.append(first);
		builder.append("명, 2학년: ");
		builder.append(second);
		builder.append("명, 3학년: ");
		builder.append(third);
		builder.append("명, 4학년: ");
		builder.append(forth);
		builder.append("명 ]");
		
		return builder.toString();
	}
	
	
	
	
}
