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
		builder.append("[ �а���: ");
		builder.append(dept_name);
		builder.append(", ����: ");
		builder.append(capactiy);
		builder.append("��, 1�г�: ");
		builder.append(first);
		builder.append("��, 2�г�: ");
		builder.append(second);
		builder.append("��, 3�г�: ");
		builder.append(third);
		builder.append("��, 4�г�: ");
		builder.append(forth);
		builder.append("�� ]");
		
		return builder.toString();
	}
	
	
	
	
}
