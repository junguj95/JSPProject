package board.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.dao.BoardDao;
import board.dto.Board;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num = request.getParameter("num");
		
		BoardDao dao = new BoardDao();
		Board board = dao.selectOneBoardByNum(Integer.parseInt(num)); //하나만 리턴된 값 가져옴
		dao.updateHits(Integer.parseInt(num)); //이 해당하는 글만 조회수가 증가 
		
		request.setAttribute("board", board);
		
		/*dao.selectOneBoardByNum(Integer.parseInt(num)); //db에서 데이터 가져오고
*/		
		
		
		String url = "./board/view.jsp"; //해당하는 페이지 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response); //보여주는부분

	}

}
