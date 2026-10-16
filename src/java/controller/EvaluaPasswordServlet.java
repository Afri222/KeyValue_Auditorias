package controller;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.EvaluadorPassword;

/**
 *
 * @author afric
 */
@WebServlet(name = "evaluaPassword", urlPatterns = {"/evaluaPassword"}) // Investigar xq el nombre no afecta al código
public class EvaluaPasswordServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String password = request.getParameter("password");
        Cookie cookie = new Cookie("ultimaAuditoria", LocalDateTime.now().toString());
        
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
        boolean[] vc = EvaluadorPassword.validarContraseña(password);
        String d = EvaluadorPassword.diagnostico(EvaluadorPassword.validarContraseña(password));
        
        request.setAttribute("validarContraseña", vc);
        request.setAttribute("diagnostico", d);
        request.getRequestDispatcher("resultadoAnalisis.jsp").forward(request, response);
    }
    
    protected void processPasswordPetition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Cookie cookie = new Cookie("ultimaAuditoria", LocalDateTime.now().toString());
        
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
        request.setAttribute("passwordSug", EvaluadorPassword.ofrecerContraseña());
        request.getRequestDispatcher("resultadoAnalisis.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("btnPedirPw".equalsIgnoreCase(request.getParameter("btnPedirPw")))
            processPasswordPetition(request, response);
        else
            processRequest(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("btnPedirPw".equalsIgnoreCase(request.getParameter("btnPedirPw")))
            processPasswordPetition(request, response);
        else
            processRequest(request, response);
    }
    
}
