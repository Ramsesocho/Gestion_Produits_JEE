package dao;

import java.util.List;

import entities.Produit;

public interface IProduitDao {

	public Produit save(Produit p); //Ajouter un produit avec la methode save
	public List <Produit>produitsParMC(String mc); // chercher un produit avec un mot clé mc
	public Produit getProduit(Long id); //consulter un produit
	public Produit update(Produit p); // mise a jour d'un produit
	public void deleteProduit(Long id);//Supprimer un produit
}
