package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.dto.Board;
import board.util.DBManager;

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
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, default, default, ?)";
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,board.getName());
			pstmt.setString(2,board.getTitle());
			pstmt.setString(3,board.getContent());
			pstmt.setString(4,board.getAttachment());
			
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
	
	// 상세보기
	public Board selectOneBoardByNum(int num){ //보드객체가 글 하나
		String sql = "select * from board where num = ?"; //물음표 주면 바인딩pstmt.setInt(1, num);
		Board board = new Board();
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num); //바인딩
			
			ResultSet rs = pstmt.executeQuery(); 
			if(rs.next());{
				
				board.setNum(rs.getInt("num"));
				board.setName(rs.getString("Name"));
				board.setTitle(rs.getString("Title"));
				board.setContent(rs.getString("Content"));
				board.setAttachment(rs.getString("attachment"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return board; //리턴
	}
	
	//조회수 증가
	public void updateHits(int num){
		String sql = "update board set hits = hits + 1 where num = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();//int result = pstmt.executeUpdate(); //executeUpdate는 int
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public int updateBoard(Board board){
		String sql = "update board set name=?, title=?, content=?, attachment=? where num=?";
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getName());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getAttachment());
			pstmt.setInt(5, board.getNum());
			
			int result = pstmt.executeUpdate();
			
			if(result != 0)
				return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public int deleteBoard(int num){
		String sql = "delete from board where num=?";
		try {
			con = DBManager.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return num;
	}
}

