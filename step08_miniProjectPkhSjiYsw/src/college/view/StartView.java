package college.view;

import college.controller.CollegeInformation;
import college.model.dto.DepartmentDTO;
import college.model.dto.ProfessorDTO;

public class StartView {

	public static void main(String[] args) {
		
		//전체 단과대학별 학과 정보 검색하여 출력하기
		EndView.ListView(CollegeInformation.getCollege("all", ""));
		
		//단과대학명을 이용하여 특정 단과대학의 학과 정보 검색하여 출력하기
		EndView.ListView(CollegeInformation.getCollege("by coll_name", "자연과학대학"));
		//미존재 단과대학
		EndView.ListView(CollegeInformation.getCollege("by coll_name", "예술대학"));
		//검색 옵션 입력 오류일 경우
		EndView.ListView(CollegeInformation.getCollege("abc", "자연과학대학"));
		
		//학과명을 이용하여 해당 학과의 졸업 요건 수정하기
		CollegeInformation.updateCollege("영어영문학과", "TOEIC 800점 이상 취득");
		EndView.ListView(CollegeInformation.getCollege("all", ""));
		CollegeInformation.updateCollege("영어영문학과", "TOEIC 900점 이상 취득");
		
		//전체 학과 재학 인원 데이터 검색하여 출력하기
		EndView.ListView(CollegeInformation.getAllDepartment());
		
		//전체 교수 데이터 검색하여 출력하기
		EndView.ListView(CollegeInformation.getProfessor("all", ""));
		
		//특정 교수 데이터 검색하여 출력하기
		EndView.ListView(CollegeInformation.getProfessor("by prof_name", "윤소원"));
		//미존재 교수
		EndView.ListView(CollegeInformation.getProfessor("by prof_name", "가나다"));
		//검색 옵션 입력 오류일 경우
		EndView.ListView(CollegeInformation.getProfessor("by asdf", "윤소원"));
		
		//새로운 교수 추가하기
		CollegeInformation.addProfessor(new ProfessorDTO("오요셉", "영어영문학과", "조교수", "영미문학사","인문관 517"));
		EndView.ListView(CollegeInformation.getProfessor("all", ""));
		//한 학과에 학과장을 중복 저장 시도할 경우
		CollegeInformation.addProfessor(new ProfessorDTO("임진택", "화학과", "학과장", "분광화학","과학관 312"));
		EndView.ListView(CollegeInformation.getProfessor("all", ""));
		
		//기존 교수 삭제하기
		//학과장이 아닌 기존 교수
		CollegeInformation.deleteProfessor("오요셉");
		//현재 학과장인 교수
		CollegeInformation.deleteProfessor("김민재");
		//동명이인 존재하는 교수
		CollegeInformation.deleteProfessor("김세희");
		//미존재 교수
		CollegeInformation.deleteProfessor("임진택");
	}

}
