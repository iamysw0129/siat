package college.view;

import java.util.ArrayList;

public class EndView {
	
	//�˻���� ����Ʈ ���
	public static void ListView (ArrayList list) {
		int length = 0;
		try {
			length = list.size();
			if (length > 0) {
				for (int i = 0; i < length; i++)
				System.out.println(list.get(i));
			} else {
				EndView.ShowError("�˻� ����� �����ϴ�.");
			}
		} catch (Exception e) {
			EndView.ShowError("�˻� ����� �����ϴ�.");
		}
	}
	
	//���� �߻� �� ���� �޽��� ���
	public static void ShowError(String msg) {
		System.out.println(msg);
	}
}
