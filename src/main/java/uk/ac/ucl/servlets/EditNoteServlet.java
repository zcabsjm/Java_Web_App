package uk.ac.ucl.servlets;

import uk.ac.ucl.model.Model;
import uk.ac.ucl.model.ModelFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// The servlet invoked to perform a search.
// The url http://localhost:8080/runsearch.html is mapped to calling doPost on the servlet object.
// The servlet object is created automatically, you just provide the class.
@WebServlet("/editnote.html")
public class EditNoteServlet extends HttpServlet
{
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    // Use the model to do the search and put the results into the request object sent to the
    // Java Server Page used to display the results.
    Model model = ModelFactory.getModel();
    int index = Integer.valueOf(request.getParameter("index"));
    String searchResult = model.getNote(index);
    String content = model.getContent(index);
    request.setAttribute("note", searchResult);
    request.setAttribute("index", index);
    request.setAttribute("content", content);

    // Invoke the JSP page.
    ServletContext context = getServletContext();
    RequestDispatcher dispatch = context.getRequestDispatcher("/editnotepage.jsp");
    dispatch.forward(request, response);
  }
}
