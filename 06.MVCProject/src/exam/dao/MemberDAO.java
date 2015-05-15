package exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exam.dto.Member;

public class MemberDAO {
    private Connection con = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
	
	//생성자
	public MemberDAO(){
		System.out.println("생성자"); //new할때 자동으로 호출
		
		// 1. JDBC 드라이버 로드 0.0.0.패키지이름/클래스이름
	    try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    // 2. 데이터 베이스와 연결
	    
	    try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jspuserc","jsp1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	//회원가입
	public void insertMember(Member member) {
		System.out.println("회원가입 !!");
		String sql = "insert into member values(?, ?, ?, ?, ?, ?, default)";
		
		String id = member.getId();
		String pwd= member.getPwd();
		String name= member.getName();
		String gender = member.getGender();
		int age = member.getAge();
		String addr = member.getAddr();
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, gender);
			pstmt.setInt(5, age);
			pstmt.setString(6, addr);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//로그인
	//1)DTO 미사용
	public int loginMember(String id, String pwd){
		String sql = "select * from member where id=? and password=?";
		int result =0;
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			pstmt.executeQuery();
			rs = pstmt.executeQuery();
			
			if(rs.next()) //로그인성공
				result = 1; //임의로 준 값
				
			else
				result = 0;//로그인실패
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
		
	}
	//2)DTO 사용
	public void loninMember(Member member){
		
	}
	
	//회원리스트
		public List<Member> listMember(){
			String sql = "select * from member order by id";//오름차순 순서 메기기
			List<Member> list = new ArrayList<Member>(); //자식(list)으로 만들고 부모에 담기(ArrayList) 
			
			
			try {
				pstmt = con.prepareStatement(sql);
				
				
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					Member m = new Member();
					
					m.setId(rs.getString("id"));
					m.setName(rs.getString("name"));
					m.setAge(rs.getInt("age"));
					
					list.add(m);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
			return list;
		}
	
	//회원상세보기
		public void detailMember(){
			
		}
	
	//회원삭제
	public void deleteMember() {
		System.out.println("회원삭제 !");
		
	}
	
	
	

}
