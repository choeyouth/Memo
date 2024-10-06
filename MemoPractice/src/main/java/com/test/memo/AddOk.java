package com.test.memo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.memo.model.MemoDTO;
import com.test.memo.repository.MemoDAO;

@WebServlet("/addok.do")
public class AddOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String memo = req.getParameter("memo");
		String name = req.getParameter("name");
		String pw = req.getParameter("pw");
		
		System.out.println(memo);
		System.out.println(name);
		System.out.println(pw);
		
		MemoDTO dto = new MemoDTO();
		dto.setMemo(memo);
		dto.setName(name);
		dto.setPw(pw);
		
		MemoDAO dao = new MemoDAO();
		
		int result = dao.add(dto);
		
		if (result == 1) {
			resp.sendRedirect("/memopractice/list.do");
		} else {
			PrintWriter writer = resp.getWriter();
			writer.println("<html><body>");
			writer.println("<script>");
			writer.println("alert('faild');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body></html>");
			writer.close();
		}
		
//		req.setAttribute("result", result);
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/addok.jsp");
//		dispatcher.forward(req, resp);

	}
}
