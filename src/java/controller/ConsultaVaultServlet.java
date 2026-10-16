package controller;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.RegistroPassword;
import modelo.VaultDAO;

/**
 *
 * @author afric
 */
@WebServlet(name = "consultaVault", urlPatterns = {"/consultaVault"})
public class ConsultaVaultServlet extends HttpServlet {
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ServletContext sc = this.getServletContext();
        VaultDAO vdao = new VaultDAO(sc);
        String ruta = sc.getRealPath("/WEB-INF/vaul.txt");
        VaultDAO vdao2 = new VaultDAO(sc, ruta);
        // ArrayList<RegistroPassword> regsLeidos = vdao.leerFichero();
        ArrayList<RegistroPassword> regsLeidos = vdao2.leerFichero();
        
        request.setAttribute("registrosLeidos", regsLeidos);
        request.getRequestDispatcher("/vaultHistorico.jsp").forward(request, response);
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
