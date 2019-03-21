package college.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import college.model.dao.CollegeDAO;
import college.model.dao.DepartmentDAO;
import college.model.dao.ProfessorDAO;
import college.model.dto.CollegeDTO;
import college.model.dto.DepartmentDTO;
import college.model.dto.ProfessorDTO;
import college.view.EndView;

public class CollegeInformation {
	
	//�ܰ����� ������ �˻�
	/*
	 �˻� �ɼ� ���� ��ü ������ �˻��Ϸ��� opt = "all", coll_name�� �ƹ� ���ڳ� ���
	Ư�� �ܰ����и��� �����͸� �˻��Ϸ��� opt = "by coll_name", coll_name�� �˻��� �ܰ����и�
	 */
	public static ArrayList<CollegeDTO> getCollege(String opt, String coll_name) {
		ArrayList<CollegeDTO> allList = null;
		try {
			allList = CollegeDAO.getCollege(opt, coll_name);
		} catch (Exception e) {
			EndView.ShowError("��ȸ�� �����Ͽ����ϴ�.");
		}
		return allList;
	}
	
	//�ܰ����� ������ ����
	//�а��� �̿��Ͽ� �ش� �а��� ���� ��� ����
	public static void updateCollege(String coll_name, String qual) {
		try {
			CollegeDAO.updateCollege(coll_name, qual);
		} catch (SQLException e) {
			EndView.ShowError("������ �����Ͽ����ϴ�.");
		}
	}
	
	//��ü �а��� ���� �ο� ������ �˻�
	public static ArrayList<DepartmentDTO> getAllDepartment() {
		ArrayList<DepartmentDTO> list = null;
		try {
			list = DepartmentDAO.getAllDepartment();
		} catch (Exception e) {
			EndView.ShowError("��ȸ�� �����Ͽ����ϴ�.");
		}
		return list;
	}
	
	//��ü ���� ������ ����ϱ�
	/*
	 �˻� �ɼ� ���� ��ü ������ �˻��Ϸ��� opt = "all", prof_name�� �ƹ� ���ڳ� ���
	Ư�� �ܰ����и��� �����͸� �˻��Ϸ��� opt = "by prof_name", prof_name�� �˻��� �ܰ����и�
	 */
	public static ArrayList<ProfessorDTO> getProfessor(String opt, String prof_name) {
		ArrayList<ProfessorDTO> list = null;
		try {
			list = ProfessorDAO.getProfessor(opt, prof_name);
		} catch (Exception e) {
			EndView.ShowError("��ȸ�� �����Ͽ����ϴ�.");
		}
		return list;
	}
	
	//���ο� ���� �߰�
	public static void addProfessor(ProfessorDTO prof) {
		try {
			ProfessorDAO.addProfessor(prof);
		} catch (Exception e) {
			EndView.ShowError("�߰��� �����Ͽ����ϴ�.");
		}
	}
	
	//���� ���� ���� 
	public static void deleteProfessor(String prof_Name) {
		try {
			ProfessorDAO.deleteProfessor(prof_Name);
		} catch (SQLException e) {
			EndView.ShowError("������ �����Ͽ����ϴ�.");
		}
	}
}
