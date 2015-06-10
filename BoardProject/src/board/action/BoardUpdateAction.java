package board.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.dao.BoardDao;
import board.dto.Board;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		ServletContext context = request.getServletContext();
		
		String uploadPath = context.getRealPath("/upload");
		
		MultipartRequest multi = new MultipartRequest(
			request, 
			uploadPath, 
			10 * 1024 * 1024,
			"UTF-8", 
			new DefaultFileRenamePolicy() 
		);
		
		String num = multi.getParameter("num");
		String name = multi.getParameter("name");
		String subject = multi.getParameter("subject");
		String textArea = multi.getParameter("textArea");
		String fileName = multi.getFilesystemName("file"); 
		
		Board board = new Board();
		
		board.setNum(Integer.parseInt(num));
		board.setName(name);
		board.setTitle(subject);
		board.setContent(textArea);
		board.setAttachment(fileName);
		
		BoardDao dao = new BoardDao();
		
		int result = dao.updateBoard(board);
		if(result != 0){
			String url = "list.uijin";
			response.sendRedirect(url);
	}

}
}