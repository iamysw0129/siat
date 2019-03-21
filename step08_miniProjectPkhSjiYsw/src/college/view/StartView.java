package college.view;

import college.controller.CollegeInformation;
import college.model.dto.DepartmentDTO;
import college.model.dto.ProfessorDTO;

public class StartView {

	public static void main(String[] args) {
		
		//��ü �ܰ����к� �а� ���� �˻��Ͽ� ����ϱ�
		EndView.ListView(CollegeInformation.getCollege("all", ""));
		
		//�ܰ����и��� �̿��Ͽ� Ư�� �ܰ������� �а� ���� �˻��Ͽ� ����ϱ�
		EndView.ListView(CollegeInformation.getCollege("by coll_name", "�ڿ����д���"));
		//������ �ܰ�����
		EndView.ListView(CollegeInformation.getCollege("by coll_name", "��������"));
		//�˻� �ɼ� �Է� ������ ���
		EndView.ListView(CollegeInformation.getCollege("abc", "�ڿ����д���"));
		
		//�а����� �̿��Ͽ� �ش� �а��� ���� ��� �����ϱ�
		CollegeInformation.updateCollege("������а�", "TOEIC 800�� �̻� ���");
		EndView.ListView(CollegeInformation.getCollege("all", ""));
		CollegeInformation.updateCollege("������а�", "TOEIC 900�� �̻� ���");
		
		//��ü �а� ���� �ο� ������ �˻��Ͽ� ����ϱ�
		EndView.ListView(CollegeInformation.getAllDepartment());
		
		//��ü ���� ������ �˻��Ͽ� ����ϱ�
		EndView.ListView(CollegeInformation.getProfessor("all", ""));
		
		//Ư�� ���� ������ �˻��Ͽ� ����ϱ�
		EndView.ListView(CollegeInformation.getProfessor("by prof_name", "���ҿ�"));
		//������ ����
		EndView.ListView(CollegeInformation.getProfessor("by prof_name", "������"));
		//�˻� �ɼ� �Է� ������ ���
		EndView.ListView(CollegeInformation.getProfessor("by asdf", "���ҿ�"));
		
		//���ο� ���� �߰��ϱ�
		CollegeInformation.addProfessor(new ProfessorDTO("�����", "������а�", "������", "���̹��л�","�ι��� 517"));
		EndView.ListView(CollegeInformation.getProfessor("all", ""));
		//�� �а��� �а����� �ߺ� ���� �õ��� ���
		CollegeInformation.addProfessor(new ProfessorDTO("������", "ȭ�а�", "�а���", "�б�ȭ��","���а� 312"));
		EndView.ListView(CollegeInformation.getProfessor("all", ""));
		
		//���� ���� �����ϱ�
		//�а����� �ƴ� ���� ����
		CollegeInformation.deleteProfessor("�����");
		//���� �а����� ����
		CollegeInformation.deleteProfessor("�����");
		//�������� �����ϴ� ����
		CollegeInformation.deleteProfessor("�輼��");
		//������ ����
		CollegeInformation.deleteProfessor("������");
	}

}
