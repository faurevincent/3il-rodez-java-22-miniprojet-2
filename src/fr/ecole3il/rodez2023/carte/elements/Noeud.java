package fr.ecole3il.rodez2023.carte.elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un noeud
 * @param <E>
 */
public class Noeud<E> {
	
	/**
	 * Valeur du noeud
	 */
	private E valeur;
	
	/**
	 * Liste des voisins du noeud
	 */
	private List<Noeud<E>> voisins;

	/**
	 * Construit un noeud
	 * @param valeur valeur du noeud à créer
	 */
	public Noeud(E valeur){
		this.valeur = valeur;
		voisins = new ArrayList<>();
	}

	/**
	 * @return la valeur du noeud
	 */
	public E getValeur() {
		return valeur;
	}

	/**
	 * @return les voisins du noeud
	 */
	public List<Noeud<E>> getVoisins() {
		return voisins;
	}
	
	/**
	 * Ajoute un Noeud voisins au noeud courant
	 * @param voisin
	 */
	public void ajouterVoisin(Noeud<E> voisin) {
		voisins.add(voisin);
	}
}
