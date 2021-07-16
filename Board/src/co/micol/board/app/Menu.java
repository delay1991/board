package co.micol.board.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.micol.board.service.BoardService;
import co.micol.board.serviceImpl.BoardServiceImpl;
import co.micol.board.vo.BoardVO;

public class Menu {
	private Scanner s = new Scanner(System.in);
	private BoardService dao = new BoardServiceImpl();
	
	private void menuTitle() {
		System.out.println("========================================================================");
		System.out.println("번호| 이름   |  제목                | 내용              | 날짜        | 조회수");
		System.out.println("========================================================================");
		List<BoardVO> boards = new ArrayList<BoardVO>();
		boards = dao.boardSelectList();
		for(BoardVO board : boards) {
			board.toString();
		}
		System.out.println("========================================================================");
		System.out.println("            1. 글조회  | 2. 글쓰기  | 3. 글삭제  | 4. 종료  ");
		System.out.println("========================================================================");
		System.out.println("원하는 작업번호 선택하세요>>  " );

	}

	private void mainMenu() {
		int boardNo;
		Boolean a = false;

		do {
			menuTitle();
			switch (boardNo = s.nextInt()) {
			case 1:
				boardSelect();
				break;
			case 2:
				boardInsert();
				break;
			case 3:
				boardDelete();
				break;
			case 4:
				a = true;
				System.out.println("프로그램이 종료 되었습니다.");
				break;
			}
		} while (!a);
		{

		}
	}

	private void boardDelete() {//삭제
		BoardVO vo = new BoardVO();
		System.out.println("삭제할 번호입력:");
		vo.setBoardid(s.next());
		s.nextLine();
		int n = dao.boardDelete(vo);
		if (n != 0) {
			System.out.println("1건이 삭제되었습니다.");
		} else {
			System.out.println("삭제실패");
		}
	}

	private void boardInsert() {//삽입
		BoardVO vo = new BoardVO();
		System.out.print("번호입력: ");
		vo.setBoardid(s.nextLine()); s.nextLine();
		System.out.print("작성자입력: ");
		vo.setWriter(s.nextLine());s.nextLine();
		System.out.print("제목입력: ");
		vo.setTitle(s.nextLine());s.nextLine();
		System.out.print("내용입력: ");
		vo.setSubject(s.nextLine());
		int n= dao.boardInsert(vo);
		if (n != 0) {
			System.out.println("1건이 입력되었습니다.");
		} else {
			System.out.println("입력실패");
		}

	}

	private void boardSelect() {//조회
		BoardVO vo = new BoardVO();
		System.out.print("검색할 번호입력: ");
		vo.setBoardid(s.next());
		s.nextLine();
		vo = dao.boardSelect(vo);
		vo.toString1();
		}


	public void run() {
		mainMenu();
		s.close();

	}
}
