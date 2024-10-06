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

@WebServlet("/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String memo = req.getParameter("memo");
		String seq = req.getParameter("seq");
		String pw = req.getParameter("pw");
		
		MemoDAO dao = new MemoDAO();
		MemoDTO dto  = new MemoDTO();
		dto.setSeq(seq);
		dto.setPw(pw);
		
		int result = 0;
		
		if (dao.check(dto) == 1) {
			dto.setMemo(memo);
			
			if (dao.edit(dto) == 1) {
				result = 1;
			}
			
		} else {
			result = 2;
		}
		
		if (result == 1) {
			resp.sendRedirect("/memopractice/list.do");
		} else if (result == 2) {
			PrintWriter writer = resp.getWriter();
			writer.println("<html><body>");
			writer.println("<script>");
			writer.println("alert('incorrect password');");
			writer.println("history.back();");
			writer.println("</script>");
			writer.println("</body></html>");
			writer.close();
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
		

	}
}