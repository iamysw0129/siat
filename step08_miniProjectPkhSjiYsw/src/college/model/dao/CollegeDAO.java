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
	
	//������ �˻�
	public static ArrayList<CollegeDTO> getCollege(String opt, String coll_name) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		ArrayList<CollegeDTO> list = null;
		try {
			con = DBUtil.getConnection();
			if (opt == "all") {		//��ü ������ ���
				pstmt = con.prepareStatement("SELECT * FROM college ORDER BY coll_name");
				System.out.println("\n===== ��ü �а� ������ ����մϴ�. =====");
			} else if (opt == "by coll_name") {		//Ư�� �ܰ������� ������ ���
				pstmt = con.prepareStatement("SELECT * FROM college WHERE coll_name = ?");
				pstmt.setString(1, coll_name);
				System.out.println("\n===== " + coll_name + "�� �а� ������ ����մϴ�. =====");
			} else {		//�˻� �ɼǰ��� ������ ���
				System.out.println("\n===== " + coll_name + "�� �а� ������ ����մϴ�. =====");
				EndView.ShowError("�˻� �ɼ��� �ٽ� �Է��ϼ���.");
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
	
	//�а��� �̿��Ͽ� ������� ����
	public static void updateCollege(String coll_name, String qual) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		System.out.println("\n=====" + coll_name + "�� ���� ����� �����մϴ�.=====");
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("UPDATE college SET grad_qualification = ? WHERE dept_name = ?");
			pstmt.setString(1, qual);
			pstmt.setString(2, coll_name);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("�����Ǿ����ϴ�.");
			} else {
				EndView.ShowError("�ش� �а��� �������� �ʽ��ϴ�.");
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
	}
	
}
