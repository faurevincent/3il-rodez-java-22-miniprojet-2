package fr.ecole3il.rodez2023.carte.elements;

import java.util.ArrayList;
import java.util.List;

public class Graphe<E> {
	
	private List<Noeud<E>> noeuds;
	
	public void ajouterNoeud(Noeud<E> noeud) {
		if(!estExistant(noeud)) {
			noeuds.add(noeud);
		}
	}
	
	public void ajouterArete(Noeud<E> depart, Noeud<E> arrivee, double cout) {
		// TODO
	}
	
	public double getCoutArete(Noeud<E> depart, Noeud<E> arrivee) {
		//TODO
		return 0.0;
	}
	
	public List<Noeud<E>> getNoeuds(){
		return noeuds;
	}
	
	public List<Noeud<E>> getVoisins(Noeud<E> noeud){
		if(estExistant(noeud)) {
			return noeud.getVoisins();
		}
		return new ArrayList<>();
	}
	
	private boolean estExistant(Noeud<E> noeud) {
		return noeuds.contains(noeud);
	}

}
