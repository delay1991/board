package co.micol.board.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.board.dao.DAO;
import co.micol.board.service.BoardService;
import co.micol.board.vo.BoardVO;

public class BoardServiceImpl extends DAO implements BoardService {
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<BoardVO> boardSelectList() {
		List<BoardVO> board = new ArrayList<BoardVO>();
		BoardVO vo;
		String sql = "select * from board";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVO();
				vo.setBoardid(rs.getNString("boardid"));
				vo.setWriter(rs.getNString("writer"));
				vo.setTitle(rs.getNString("title"));
				vo.setSubject(rs.getNString("subject"));
				vo.setDate(rs.getDate("enterdate"));
				vo.setHit(rs.getInt("hit"));
				board.add(vo);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public BoardVO boardSelect(BoardVO vo) {
		String sql = "select * from board where boardid =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardid());
			rs = psmt.executeQuery();

			if (rs.next()) {
				vo.setSubject(rs.getString("subject"));
				hitUpdate(vo.getBoardid());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int boardInsert(BoardVO vo) {
		int n = 0;
		String sql = "insert into board(boardid,writer,title,subject) VALUES(?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setNString(1, vo.getBoardid());
			psmt.setNString(2, vo.getWriter());
			psmt.setNString(3, vo.getTitle());
			psmt.setNString(4, vo.getSubject());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		int n = 0;
		String sql = "delete from board where boardid =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getBoardid());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	private void hitUpdate(String boardId) {
		String sql = "update board set hit = hit +1 where boardid =?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, boardId);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}