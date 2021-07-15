package co.micol.board.app;

import java.util.Scanner; //mvc패턴ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ

import co.micol.board.service.BoardService;
import co.micol.board.serviceImpl.BoardServiceImpl;
import co.micol.board.vo.BoardVO;

public class Menu {
	private Scanner s = new Scanner(System.in);
	private BoardService dao = new BoardServiceImpl();

	private void menuTitle() {
		// 전체리스트가져와야함

		System.out.println("======================");
		System.out.println("======  게 시 판  ======");
		System.out.println("======  1.글조회  ======");
		System.out.println("======  2.글쓰기  ======");
		System.out.println("======  3.글삭제  ======");
		System.out.println("======  4.종  료  ======");
		System.out.println("======================");

	}

	private void mainMenu() {
		int boardNo;
		Boolean a = false;

		do {
			menuTitle();
			switch (boardNo = s.nextInt()) {
			case 1:
				search();
				break;
			case 2:
				insert();
				break;
			case 3:
				delete();
				break;
			case 4:
				a = true;
				System.out.println("프로그램 종료");
				break;
			}
		} while (!a);
		{

		}
	}

	private void delete() {
		BoardVO vo = new BoardVO();
		System.out.println("삭제할 번호입력:");
		vo.setBoardId(s.next());
		s.nextLine();
		int n = dao.boardDelete(vo);
		if (n != 0) {
			System.out.println("정상삭제");
		} else {
			System.out.println("삭제실패");
		}
	}

	private void insert() {
		BoardVO vo = new BoardVO();
		System.out.print("번호입력: ");
		vo.setBoardId(s.next());
		s.nextLine();
		System.out.print("작성자입력: ");
		vo.setWriter(s.next());
		s.nextLine();
		System.out.print("제목입력: ");
		vo.setTitle(s.next());
		s.nextLine();
		System.out.println("내용입력: ");
		vo.setSubject(s.next());
		s.nextLine();

		int n = dao.boardInsert(vo);
		if (n != 0) {
			System.out.println("정상입력");
		} else {
			System.out.println("입력실패");
		}

	}

	private void search() {
		BoardVO vo = new Board();
		System.out.print("검색할 번호입력: ");
		vo.setBoardId(s.next()); s.nextLine();
		vo = dao.boardSelect(vo);
		vo.toString();
	}
}
