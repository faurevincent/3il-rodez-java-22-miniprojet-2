package fr.ecole3il.rodez2023.carte.elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Graphe<E> {
	
	private List<Noeud<E>> noeuds;
	
	Map<Noeud<E>, Map<Noeud<E>,Double>> matriceAdjacence;
	
	public Graphe() {
		noeuds = new ArrayList<Noeud<E>>();
		matriceAdjacence = new HashMap<Noeud<E>, Map<Noeud<E>,Double>>();
	}

	public void ajouterNoeud(Noeud<E> noeud) {
		if(!estExistant(noeud)) {
			noeuds.add(noeud);
		}
	}
	
	public void ajouterArete(Noeud<E> depart, Noeud<E> arrivee, double cout) {
		if(!estExistant(depart)) {
			ajouterNoeud(depart);
		}
		if(!estExistant(arrivee)) {
			ajouterNoeud(depart);
		}
		
		if(matriceAdjacence.get(depart) == null) {
			matriceAdjacence.put(depart, new TreeMap<Noeud<E>, Double>());
		}
		
		matriceAdjacence.get(depart).put(arrivee, cout);
	}
	
	public double getCoutArete(Noeud<E> depart, Noeud<E> arrivee) {
		return matriceAdjacence.get(depart).get(arrivee);
	}
	
	public List<Noeud<E>> getNoeuds(){
		return noeuds;
	}
	
	public Noeud<E> getNoeud(int x, int y){
		for(Noeud<E> n : noeuds) {
			if(n.getValeur().getClass() == Case.class) {
				Case c = (Case) n.getValeur();
				if(c.getX() == x && c.getY() == y) {
					return n;
				}
			}
		}
		return null;
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
