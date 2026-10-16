package controller;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
        VaultDAO vdao = new VaultDAO(sc, sc.getRealPath("/WEB-INF/vault.txt"));
        String clave = request.getParameter("password");
        HttpSession sesion = request.getSession(true);
        Cookie cookie = new Cookie("desdeGuardado", "True");
        RegistroPassword rpw;
        Integer cont;

        if (clave != null) {
            rpw = new RegistroPassword(clave);
            vdao.escribirEnFichero(rpw);
        }
        System.out.println();
        System.out.println("EDRFTGYUKML");
        cont = (Integer) sesion.getAttribute("contador");
        cookie.setMaxAge(30);

        if (cont == null) {
            cont = 1;
        } else {
            cont++;
        }

        sesion.setAttribute("contador", cont);
        /* sesion.setAttribute("nombre", InetAddress.getLocalHost().getHostName()); // Obtener el nombre del ordenador (hostname) */
        sesion.setAttribute("nombre", System.getProperty("user.name")); // Nombre del usuario de la sesión
        sesion.setAttribute("password", clave);
        response.addCookie(cookie);
        request.getRequestDispatcher("vaultHistorico.jsp").forward(request, response); // response.sendRedirect("vaultHistorico.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
