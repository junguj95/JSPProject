package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.action.Action;
import board.action.BoardDeleteAction;
import board.action.BoardListAction;
import board.action.BoardUpdateAction;
import board.action.BoardUpdateFormAction;
import board.action.BoardViewAction;
import board.action.BoardWriteAction;
import board.action.BoardWriteFormAction;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("*.uijin")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("A_YO! GG");
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("A_YO! GG");
		
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String command = uri.substring(contextPath.length());//substring글씨잘라옴
		
		/*System.out.println(contextPath);
		System.out.println(uri);
		System.out.println("command: " + command);*/
		
		//글쓰기폼
		if(command.equals("/writeForm.uijin")){
			Action action = new BoardWriteFormAction();
			action.execute(request, response);
			
		}
		//글쓰기
		else if(command.equals("/write.uijin")){
			System.out.println("/wirte.uijin");
			Action action = new BoardWriteAction();
			action.execute(request, response);
			
		}
		//리스트
		else if(command.equals("/list.uijin")){
			Action action = new BoardListAction();
			action.execute(request, response);
			
			
		}
		
		//상세보기
		else if(command.equals("/view.uijin")){
			Action action = new BoardViewAction();
			action.execute(request, response);
			}
		
		
		
		//삭제하기
		else if(command.equals("/delete.uijin")){
			Action action = new BoardDeleteAction();
			action.execute(request, response);
					}
		
		
		//수정하기
		else if(command.equals("/update.uijin")){
			Action action = new BoardUpdateAction();
			action.execute(request, response);
					}
		
	
		
		//수정 폼
		else if(command.equals("/updateForm.uijin")){
			Action action = new BoardUpdateFormAction();
			action.execute(request, response);
				
		}
	}
}


