package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

import fr.ecole3il.rodez2023.carte.elements.Case;
import fr.ecole3il.rodez2023.carte.elements.Graphe;
import fr.ecole3il.rodez2023.carte.elements.Noeud;

public class AlgorithmeDijkstra<E> implements AlgorithmeChemin<E> {

	@Override
	public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee) {
		
		Map<Noeud<E>, Double> couts = new HashMap<>();
		Map<Noeud<E>, Noeud<E>> predecesseurs = new HashMap<>();
		
		// File de prioritée
		PriorityQueue<Noeud<E>> filePriorite = new PriorityQueue<>(Comparator.comparingDouble(couts::get));
				
		for (Noeud n : graphe.getNoeuds()) {
			couts.put(n, Double.MAX_VALUE);
			predecesseurs.put(n, null);
		}
		
		couts.put(depart, 0.0); // Noeud de départ cout = 0
        filePriorite.add(depart);
        
        while(!filePriorite.isEmpty()) {
        	
        	Noeud<E> noeudActuel = filePriorite.poll();
        	Case c = (Case) noeudActuel.getValeur();
        	if(arrivee.equals(noeudActuel)) {
        		return reconstructionChemin(arrivee, predecesseurs);
        	}
        	
        	for(Noeud voisin : noeudActuel.getVoisins()) {
        		double nouveauCout = couts.get(noeudActuel) + graphe.getCoutArete(noeudActuel, voisin);
                if (nouveauCout < couts.get(voisin)) {
                    couts.put(voisin, nouveauCout);
                    predecesseurs.put(voisin, noeudActuel);
                    filePriorite.add(voisin);
                }
        	}
        }
        
        return null; // Pas de chemin
	}
	
	/**
	 * Reconstruction du chemin
	 * @param arrivee
	 * @param predecesseurs
	 * @return
	 */
	private List<Noeud<E>> reconstructionChemin(Noeud<E> arrivee, Map<Noeud<E>, Noeud<E>> predecesseurs){
		List<Noeud<E>> chemin = new ArrayList<>();
        Noeud<E> noeud = arrivee;
        while (noeud != null) {
            chemin.add(noeud);
            noeud = predecesseurs.get(noeud);
        }
        Collections.reverse(chemin);
        return chemin;
	}

}
