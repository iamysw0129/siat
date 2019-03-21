package college.view;

import java.util.ArrayList;

public class EndView {
	
	//검색결과 리스트 출력
	public static void ListView (ArrayList list) {
		int length = 0;
		try {
			length = list.size();
			if (length > 0) {
				for (int i = 0; i < length; i++)
				System.out.println(list.get(i));
			} else {
				EndView.ShowError("검색 결과가 없습니다.");
			}
		} catch (Exception e) {
			EndView.ShowError("검색 결과가 없습니다.");
		}
	}
	
	//예외 발생 시 에러 메시지 출력
	public static void ShowError(String msg) {
		System.out.println(msg);
	}
}
