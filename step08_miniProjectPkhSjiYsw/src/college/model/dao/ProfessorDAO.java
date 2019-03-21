package college.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import college.model.dto.ProfessorDTO;
import college.model.utill.DBUtil;
import college.view.EndView;

public class ProfessorDAO {

	//데이터 검색
	public static ArrayList<ProfessorDTO> getProfessor(String opt, String prof_name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		ArrayList<ProfessorDTO> list = null;
		try {
			con = DBUtil.getConnection();
			if (opt == "all") {		//전체 데이터 출력
				pstmt = con.prepareStatement("SELECT * FROM professor01 ORDER BY dept_name");
				System.out.println("\n===== 전체 교수 정보를 출력합니다. =====");
			} else if (opt == "by prof_name") {		//특정 교수의 데이터 출력
				pstmt = con.prepareStatement("SELECT * FROM professor01 WHERE prof_name = ? ");
				pstmt.setString(1, prof_name);
				System.out.println("\n===== " + prof_name + " 교수의 정보를 출력합니다. =====");
			} else {		//검색 옵션값이 오류일 경우
				System.out.println("\n===== " + prof_name + " 교수의 정보를 출력합니다. =====");
				throw new SQLException();
			}
			rst = pstmt.executeQuery();
			list = new ArrayList<ProfessorDTO>();
			while (rst.next()) {
				list.add(new ProfessorDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)) );
			}
		} finally {
			DBUtil.close(con, pstmt, rst);
		}
		return list;
	}

	//새로운 교수 추가
	public static void addProfessor(ProfessorDTO prof) throws SQLException {
		System.out.println("\n===== 새로운 교수를 추가합니다. =====");
		System.out.println("추가할 교수 이름: " + prof.getProf_name() + ", 소속학과: " + prof.getDept_name() + ", 직위: " + prof.getPosition());
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			con = DBUtil.getConnection();
			
			//해당 학과에 기존 학과장이 있는지 확인하기
			pstmt = con.prepareStatement("SELECT * FROM dean WHERE dept_name = ?");
			pstmt.setString(1, prof.getDept_name());
			rst = pstmt.executeQuery();
			if (( prof.getPosition() == "학과장" ) && ( rst.next() )) {
				EndView.ShowError("해당 학과의 학과장이 이미 존재합니다.");
				throw new SQLException();
			}
			
			pstmt = con.prepareStatement("INSERT INTO professor01 VALUES(?, ?, ?, ?, ?)");
			pstmt.setString(1, prof.getProf_name());
			pstmt.setString(2, prof.getDept_name());
			pstmt.setString(3, prof.getPosition());
			pstmt.setString(4, prof.getMajor());
			pstmt.setString(5, prof.getProf_loc());
			pstmt.executeUpdate();
			System.out.println("추가되었습니다.");
		} finally {
			DBUtil.close(con, pstmt);
		}
		
	}
	
	//기존 교수 삭제
	public static void deleteProfessor(String prof_name) throws SQLException {
		System.out.println("\n===== 교수를 삭제합니다. =====");
		System.out.println("삭제할 교수 이름: " + prof_name);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			con = DBUtil.getConnection();
			
			//입력한 교수가 학과장인지 확인하기
			pstmt = con.prepareStatement("SELECT * FROM dean WHERE prof_name = ?");
			pstmt.setString(1, prof_name);
			rst = pstmt.executeQuery();
			if (rst.next()) {
				EndView.ShowError("현재 학과장인 교수는 삭제할 수 없습니다.");
				throw new SQLException();
			}
			
			//입력한 교수가 동명이인인지 확인하기
			pstmt = con.prepareStatement("SELECT * FROM professor01 WHERE prof_name = ?");
			pstmt.setString(1, prof_name);
			rst = pstmt.executeQuery();
			int count = 0;
			while (rst.next()) {
				count++;
			}
			if (count > 1) {
				EndView.ShowError("동명이인이 존재하여 현재 페이지에서는 삭제할 수 없습니다.");
				throw new SQLException();
			} else if (count == 0) {
				EndView.ShowError("해당 교수는 존재하지 않습니다.");
				throw new SQLException();
			}
			
			//교수 삭제하기
			pstmt = con.prepareStatement("DELETE FROM professor01 WHERE prof_name = ?");
			pstmt.setString(1, prof_name);
			if (pstmt.executeUpdate() == 1) {
				System.out.println("삭제되었습니다.");
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		
	}
	
}
