package board.action; //글쓴거 저장하는 액션

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





import board.dao.BoardDao;
import board.dto.Board;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Board board = new Board();
		
		board.setName(name);
		board.setTitle(title);
		board.setContent(content);
		
		BoardDao dao = new BoardDao();
		dao.insertBoard(board);
		
		int result = dao.insertBoard(board);
		
		if(result != 0){
			String url = "list.uijin";
			response.sendRedirect(url);
		}

		
		

	}

}
