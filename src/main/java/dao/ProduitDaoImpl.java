package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Produit;

public class ProduitDaoImpl implements IProduitDao {

	@Override
	public Produit save(Produit p) {
		Connection connection=SingletonConnection.getConnection();
		
		try {
			
			PreparedStatement ps=connection.prepareStatement("INSERT INTO PRODUITS(DESIGNATION,PRIX,QUANTITE) VALUES(?,?,?)");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.executeUpdate();
			PreparedStatement ps2=connection.prepareStatement("SELECT MAX(ID) as MAX_ID FROM PRODUITS");
			ResultSet rs=ps2.executeQuery();
			if(rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Produit> produitsParMC(String mc) {
		List<Produit> produits=new ArrayList<Produit>();
		Connection connection=SingletonConnection.getConnection();
		
		try {
			
			PreparedStatement ps3=connection.prepareStatement("SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ?");
			ps3.setString(1,mc);
			ResultSet rs=ps3.executeQuery();
			while(rs.next()) {
				Produit p=new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("Prix"));
				p.setQuantite(rs.getInt("QUANTITE"));
				produits.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produits;
	}

	@Override
	public Produit getProduit(Long id) {
		Produit p=null;
		Connection connection=SingletonConnection.getConnection();
		
		try {
			
			PreparedStatement ps3=connection.prepareStatement("SELECT * FROM PRODUITS WHERE ID=?");
			ps3.setLong(1,id);
			ResultSet rs=ps3.executeQuery();
			if(rs.next()) {
				 p=new Produit();
				p.setId(rs.getLong("ID"));
				p.setDesignation(rs.getString("DESIGNATION"));
				p.setPrix(rs.getDouble("Prix"));
				p.setQuantite(rs.getInt("QUANTITE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public Produit update(Produit p) {
		Connection connection=SingletonConnection.getConnection();
		
		try {
			
			PreparedStatement ps=connection.prepareStatement("UPDATE PRODUITS SET DESIGNATION=?,PRIX=?,QUANTITE=? WHERE ID=?");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQuantite());
			ps.setLong(4, p.getId());
			ps.executeUpdate();
			ps.close();
			//connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void deleteProduit(Long id) {
		// TODO Auto-generated method stub
		Connection connection=SingletonConnection.getConnection();
		
		try {
			
			PreparedStatement ps=connection.prepareStatement("DELETE FROM PRODUITS WHERE ID=?");
			ps.setLong(1,id);
			ps.executeUpdate();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
