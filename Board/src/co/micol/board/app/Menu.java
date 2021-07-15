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
		System.out.println("=======  전체 목록  ======");
		List<BoardVO> boards = new ArrayList<BoardVO>();
		boards = dao.boardSelectList();
		for(BoardVO board : boards) {
			board.toString();
		}
		System.out.println("======================");
		System.out.println("======  게 시 판  ======");
		System.out.println("======  1.글조회  ======");
		System.out.println("======  2.글쓰기  ======");
		System.out.println("======  3.글삭제  ======");
		System.out.println("======  4.종  료  ======");
		System.out.println("======================");
		System.out.println("원하는 작업번호 선택>>  " );

	}

	private void mainMenu() {
		int boardNo;
		Boolean a = false;

		do {
			menuTitle();
			switch (boardNo = s.nextInt()) {
			case 1:
				inquire();
				break;
			case 2:
				insert();
				break;
			case 3:
				delete();
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

	private void delete() {
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

	private void insert() {
		BoardVO vo = new BoardVO();
		System.out.print("번호입력: ");
		vo.setBoardid(s.next()); s.nextLine();
		System.out.print("작성자입력: ");
		vo.setWriter(s.next());s.nextLine();
		System.out.print("제목입력: ");
		vo.setTitle(s.next());s.nextLine();
		System.out.print("내용입력: ");
		vo.setSubject(s.next());
		int n= dao.boardInsert(vo);
		if (n != 0) {
			System.out.println("1건이 입력되었습니다.");
		} else {
			System.out.println("입력실패");
		}

	}

	private void inquire() {
		BoardVO vo = new BoardVO();
		System.out.print("검색할 번호입력: ");
		vo.setBoardid(s.next());
		s.nextLine();
		vo = dao.boardSelect(vo);
		vo.toString1();
		s.nextLine();
		
	}


	public void run() {
		mainMenu();
		s.close();

	}
}
