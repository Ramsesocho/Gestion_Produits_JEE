package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IProduitDao;
import dao.ProduitDaoImpl;
import entities.Produit;

@WebServlet(name="cs",urlPatterns= {"*.do"})
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private IProduitDao metier;
	
	@Override
	public void init() throws ServletException {
		metier=new ProduitDaoImpl(); //instancier la couche metier
	}
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String path=request.getServletPath();//retourne l'action du formulaire
		if(path.equals("/index.do")) {
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		}
		else if(path.equals("/chercher.do")) {
			String motCle=request.getParameter("motCle");
			ProduitModel model=new ProduitModel();
			model.setMotCle(motCle);
			List<Produit> produits=metier.produitsParMC("%"+motCle+"%");
			model.setProduits(produits);
			request.setAttribute("model", model);
			request.getRequestDispatcher("produits.jsp").forward(request, response);
		}
		else if(path.equals("/Saisie.do")) {
			request.setAttribute("produit", new Produit());
			request.getRequestDispatcher("ajouterProduit.jsp").forward(request, response);
		}
		
		else if(path.equals("/SaveProduit.do") && (request.getMethod().equals("POST"))) {
			String des=request.getParameter("designation");
			double prix=Double.parseDouble(request.getParameter("prix"));
			int quantite=Integer.parseInt(request.getParameter("quantite"));
			Produit p=metier.save(new Produit(des,prix,quantite));
			
			request.setAttribute("produit", p);
			
			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
			
		}
		
		else if (path.equals("/Supprimer.do")) {
			Long id=Long.parseLong(request.getParameter("id"));
			metier.deleteProduit(id);
		//	request.getRequestDispatcher("produits.jsp").forward(request, response);
			response.sendRedirect("chercher.do?motCle=");
		}
		else if (path.equals("/Edit.do")) {
			Long id=Long.parseLong(request.getParameter("id"));
			Produit p=metier.getProduit(id);
			request.setAttribute("produit", p);
			response.sendRedirect("chercher.do?motCle=");
			request.getRequestDispatcher("EditProduit.jsp").forward(request, response);
		}
		else if(path.equals("/UpdateProduit.do") && (request.getMethod().equals("POST"))) {
			Long id=Long.parseLong(request.getParameter("id"));
			String des=request.getParameter("designation");
			double prix=Double.parseDouble(request.getParameter("prix"));
			int quantite=Integer.parseInt(request.getParameter("quantite"));
			Produit p=new Produit(des,prix,quantite);
			p.setId(id);
			metier.update(p);		
			request.setAttribute("produit", p);
			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
			
		}
		
		else {
			response.sendError(Response.SC_NOT_FOUND);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
