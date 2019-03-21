//수정할 것

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
	
	//단과대학 데이터 검색
	/*
	 검색 옵션 없이 전체 데이터 검색하려면 opt = "all", coll_name은 아무 문자나 허용
	특정 단과대학명의 데이터만 검색하려면 opt = "by coll_name", coll_name은 검색할 단과대학명
	 */
	public static ArrayList<CollegeDTO> getCollege(String opt, String coll_name) {
		ArrayList<CollegeDTO> allList = null;
		try {
			allList = CollegeDAO.getCollege(opt, coll_name);
		} catch (Exception e) {
			EndView.ShowError("조회에 실패하였습니다.");
		}
		return allList;
	}
	
	//단과대학 데이터 수정
	//학과명 이용하여 해당 학과의 졸업 요건 수정
	public static void updateCollege(String coll_name, String qual) {
		try {
			CollegeDAO.updateCollege(coll_name, qual);
		} catch (SQLException e) {
			EndView.ShowError("수정에 실패하였습니다.");
		}
	}
	
	//전체 학과의 재학 인원 데이터 검색
	public static ArrayList<DepartmentDTO> getAllDepartment() {
		ArrayList<DepartmentDTO> list = null;
		try {
			list = DepartmentDAO.getAllDepartment();
		} catch (Exception e) {
			EndView.ShowError("조회에 실패하였습니다.");
		}
		return list;
	}
	
	//전체 교수 데이터 출력하기
	/*
	 검색 옵션 없이 전체 데이터 검색하려면 opt = "all", prof_name은 아무 문자나 허용
	특정 단과대학명의 데이터만 검색하려면 opt = "by prof_name", prof_name은 검색할 단과대학명
	 */
	public static ArrayList<ProfessorDTO> getProfessor(String opt, String prof_name) {
		ArrayList<ProfessorDTO> list = null;
		try {
			list = ProfessorDAO.getProfessor(opt, prof_name);
		} catch (Exception e) {
			EndView.ShowError("조회에 실패하였습니다.");
		}
		return list;
	}
	
	//새로운 교수 추가
	public static void addProfessor(ProfessorDTO prof) {
		try {
			ProfessorDAO.addProfessor(prof);
		} catch (Exception e) {
			EndView.ShowError("추가에 실패하였습니다.");
		}
	}
	
	//기존 교수 삭제 
	public static void deleteProfessor(String prof_Name) {
		try {
			ProfessorDAO.deleteProfessor(prof_Name);
		} catch (SQLException e) {
			EndView.ShowError("삭제에 실패하였습니다.");
		}
	}
}
