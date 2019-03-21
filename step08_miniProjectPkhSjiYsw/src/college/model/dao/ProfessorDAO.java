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

	//������ �˻�
	public static ArrayList<ProfessorDTO> getProfessor(String opt, String prof_name) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		ArrayList<ProfessorDTO> list = null;
		try {
			con = DBUtil.getConnection();
			if (opt == "all") {		//��ü ������ ���
				pstmt = con.prepareStatement("SELECT * FROM professor01 ORDER BY dept_name");
				System.out.println("\n===== ��ü ���� ������ ����մϴ�. =====");
			} else if (opt == "by prof_name") {		//Ư�� ������ ������ ���
				pstmt = con.prepareStatement("SELECT * FROM professor01 WHERE prof_name = ? ");
				pstmt.setString(1, prof_name);
				System.out.println("\n===== " + prof_name + " ������ ������ ����մϴ�. =====");
			} else {		//�˻� �ɼǰ��� ������ ���
				System.out.println("\n===== " + prof_name + " ������ ������ ����մϴ�. =====");
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

	//���ο� ���� �߰�
	public static void addProfessor(ProfessorDTO prof) throws SQLException {
		System.out.println("\n===== ���ο� ������ �߰��մϴ�. =====");
		System.out.println("�߰��� ���� �̸�: " + prof.getProf_name() + ", �Ҽ��а�: " + prof.getDept_name() + ", ����: " + prof.getPosition());
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			con = DBUtil.getConnection();
			
			//�ش� �а��� ���� �а����� �ִ��� Ȯ���ϱ�
			pstmt = con.prepareStatement("SELECT * FROM dean WHERE dept_name = ?");
			pstmt.setString(1, prof.getDept_name());
			rst = pstmt.executeQuery();
			if (( prof.getPosition() == "�а���" ) && ( rst.next() )) {
				EndView.ShowError("�ش� �а��� �а����� �̹� �����մϴ�.");
				throw new SQLException();
			}
			
			pstmt = con.prepareStatement("INSERT INTO professor01 VALUES(?, ?, ?, ?, ?)");
			pstmt.setString(1, prof.getProf_name());
			pstmt.setString(2, prof.getDept_name());
			pstmt.setString(3, prof.getPosition());
			pstmt.setString(4, prof.getMajor());
			pstmt.setString(5, prof.getProf_loc());
			pstmt.executeUpdate();
			System.out.println("�߰��Ǿ����ϴ�.");
		} finally {
			DBUtil.close(con, pstmt);
		}
		
	}
	
	//���� ���� ����
	public static void deleteProfessor(String prof_name) throws SQLException {
		System.out.println("\n===== ������ �����մϴ�. =====");
		System.out.println("������ ���� �̸�: " + prof_name);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try {
			con = DBUtil.getConnection();
			
			//�Է��� ������ �а������� Ȯ���ϱ�
			pstmt = con.prepareStatement("SELECT * FROM dean WHERE prof_name = ?");
			pstmt.setString(1, prof_name);
			rst = pstmt.executeQuery();
			if (rst.next()) {
				EndView.ShowError("���� �а����� ������ ������ �� �����ϴ�.");
				throw new SQLException();
			}
			
			//�Է��� ������ ������������ Ȯ���ϱ�
			pstmt = con.prepareStatement("SELECT * FROM professor01 WHERE prof_name = ?");
			pstmt.setString(1, prof_name);
			rst = pstmt.executeQuery();
			int count = 0;
			while (rst.next()) {
				count++;
			}
			if (count > 1) {
				EndView.ShowError("���������� �����Ͽ� ���� ������������ ������ �� �����ϴ�.");
				throw new SQLException();
			} else if (count == 0) {
				EndView.ShowError("�ش� ������ �������� �ʽ��ϴ�.");
				throw new SQLException();
			}
			
			//���� �����ϱ�
			pstmt = con.prepareStatement("DELETE FROM professor01 WHERE prof_name = ?");
			pstmt.setString(1, prof_name);
			if (pstmt.executeUpdate() == 1) {
				System.out.println("�����Ǿ����ϴ�.");
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		
	}
	
}
