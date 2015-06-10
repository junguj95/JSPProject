package board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;


public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException   {
		// TODO Auto-generated method stub
		String num = request.getParameter("num"); //글 번호 받아오기
		
		BoardDao dao = new BoardDao(); 
		
		dao.deleteBoard(Integer.parseInt(num)); //받아온 번호의 글을 삭제
		response.sendRedirect("list.board");//메소드 실행후 리스트로 돌아감
	}

}
