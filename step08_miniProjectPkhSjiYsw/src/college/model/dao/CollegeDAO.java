package college.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import college.model.dto.CollegeDTO;
import college.model.utill.DBUtil;
import college.view.EndView;

public class CollegeDAO {
	
	//데이터 검색
	public static ArrayList<CollegeDTO> getCollege(String opt, String coll_name) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		ArrayList<CollegeDTO> list = null;
		try {
			con = DBUtil.getConnection();
			if (opt == "all") {		//전체 데이터 출력
				pstmt = con.prepareStatement("SELECT * FROM college ORDER BY coll_name");
				System.out.println("\n===== 전체 학과 정보를 출력합니다. =====");
			} else if (opt == "by coll_name") {		//특정 단과대학의 데이터 출력
				pstmt = con.prepareStatement("SELECT * FROM college WHERE coll_name = ?");
				pstmt.setString(1, coll_name);
				System.out.println("\n===== " + coll_name + "의 학과 정보를 출력합니다. =====");
			} else {		//검색 옵션값이 오류일 경우
				System.out.println("\n===== " + coll_name + "의 학과 정보를 출력합니다. =====");
				EndView.ShowError("검색 옵션을 다시 입력하세요.");
				throw new Exception();
			}
			rst = pstmt.executeQuery();
			list = new ArrayList<CollegeDTO>();
			while (rst.next()) {
				list.add(new CollegeDTO(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5)) );
			}
		} finally {
			DBUtil.close(con, pstmt, rst);
		}
		
		return list;
	}
	
	//학과명 이용하여 졸업요건 수정
	public static void updateCollege(String coll_name, String qual) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		System.out.println("\n=====" + coll_name + "의 졸업 요건을 수정합니다.=====");
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("UPDATE college SET grad_qualification = ? WHERE dept_name = ?");
			pstmt.setString(1, qual);
			pstmt.setString(2, coll_name);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("수정되었습니다.");
			} else {
				EndView.ShowError("해당 학과가 존재하지 않습니다.");
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
}
