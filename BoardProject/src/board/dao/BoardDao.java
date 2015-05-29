package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.dto.Board;

public class BoardDao {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	
	public BoardDao(){
		
		// 1. JDBC 드라이버 로드 0.0.0.패키지이름/클래스이름
	    try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jspuserc","jsp1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{ //예외가 발생하든 말든 그냥 실행			
		
		}
	}
	
	//글쓰기
	
	
	public int insertBoard(Board board){
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, default, default, 'file')";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,board.getName());
			pstmt.setString(2,board.getTitle());
			pstmt.setString(3,board.getContent());
			
			int result = pstmt.executeUpdate(); //리턴타입 int
			
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return 0;
	}
	
	//리스트
	public List<Board> selectAllBoards(){
		String sql = "select * from board order by num desc";
		
		List<Board> list = new ArrayList<Board>();
		System.out.println("fadsfdsafdsafdsafadsfasd");
		try {
			pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery(); //rs는 dao에서 끝내서 list에 담아감
			
			while(rs.next()){
				Board board = new Board();
				
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setName(rs.getString("name"));
				board.setWdate(rs.getDate("wdate"));
				board.setHits(rs.getInt("hits"));
				
				list.add(board);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("adsfdafads" + list);
		return list;
	}
	
	public Board seletOnBoardByNum(int num){
		return null;
	}
	public void updateHits(int num){
		
	}
	public int updateBoard(Board board){
		return 0;
	}
	public int deleteBoard(int num){
		return 0;
	}
}

