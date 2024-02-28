package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import fr.ecole3il.rodez2023.carte.elements.Graphe;
import fr.ecole3il.rodez2023.carte.elements.Noeud;

public class AlgorithmeDijkstra<E> implements AlgorithmeChemin<E> {

	@Override
	public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee) {
		
		Map<Noeud<E>, Double> coutByNoeud = new TreeMap<>();
				
		for (Noeud n : graphe.getNoeuds()) {
			coutByNoeud.put(n, Double.MAX_VALUE);
		}
		
		coutByNoeud.put(depart, 0.0);
		
		// TODO Auto-generated method stub
		return null;
	}

}
