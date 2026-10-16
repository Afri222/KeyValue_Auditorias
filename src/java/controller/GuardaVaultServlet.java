package controller;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.RegistroPassword;
import modelo.VaultDAO;

/**
 *
 * @author afric
 */
@WebServlet(name = "guardaVault", urlPatterns = {"/guardaVault"})
public class GuardaVaultServlet extends HttpServlet {

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ServletContext sc = this.getServletContext();
        VaultDAO vdao = new VaultDAO(sc.getRealPath("/WEB-INF/vault.txt"));
        String clave = request.getParameter("password");
        RegistroPassword rpw = new RegistroPassword(clave);
        HttpSession sesion = request.getSession(true);
        Integer cont;
        
        cont = (Integer) sesion.getAttribute("contador");
        vdao.escribirEnFichero(rpw);
        
        if (cont == null) {
            cont = 1;
        } else {
            cont++;
        }
        
        sesion.setAttribute("contador", cont);
        sesion.setAttribute("nombre", System.getProperty("user.name")); // Nombre del usuario de la sesión
        /* sesion.setAttribute("nombre", InetAddress.getLocalHost().getHostName()); // Obtener el nombre del ordenador (hostname) */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    
}
