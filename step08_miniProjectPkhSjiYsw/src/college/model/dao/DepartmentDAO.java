package college.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import college.model.dto.DepartmentDTO;
import college.model.utill.DBUtil;

public class DepartmentDAO {
	
	//��ü������ �˻�
	public static ArrayList<DepartmentDTO> getAllDepartment() throws Exception {
		System.out.println("\n===== ��ü �а��� �г⺰ ���� �ο� ������ ����մϴ�. =====");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		ArrayList<DepartmentDTO> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM department01");
			rst = pstmt.executeQuery();
			list = new ArrayList<DepartmentDTO>();
			while (rst.next()) {
				list.add(new DepartmentDTO(rst.getString(1), rst.getInt(2), rst.getInt(3), rst.getInt(4), rst.getInt(5), rst.getInt(6)));
			}
			
		} finally {
			DBUtil.close(con, pstmt, rst);
		}
		return list;
	}
	
}
