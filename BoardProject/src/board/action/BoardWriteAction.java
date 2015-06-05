package board.action; //글쓴거 저장하는 액션

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.dao.BoardDao;
import board.dto.Board;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		/*String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");*/
		
		ServletContext context = req.getServletContext();
		String uploadPath = context.getRealPath("upload");
		//System.out.println(uploadPath);
		
		MultipartRequest multi = new MultipartRequest(req, uploadPath, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
		String name = multi.getParameter("name");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String fileName = multi.getFilesystemName("file");
		
		/*System.out.println(fileName);*/
		
		Board board = new Board();
		
		board.setName(name);
		board.setTitle(title);
		board.setContent(content);
		board.setAttachment(fileName);
		
		BoardDao dao = new BoardDao();
		//dao.insertBoard(board); //리턴값 안받고 글써서 리스트에 나오기
		
		int result = dao.insertBoard(board); //리턴값 받은것
		
		if(result != 0){
			String url = "list.uijin";
			response.sendRedirect(url);
		}

		
		

	}

}
