package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import fr.ecole3il.rodez2023.carte.elements.Graphe;
import fr.ecole3il.rodez2023.carte.elements.Noeud;

public class AlgorithmeAEtoile<E> implements AlgorithmeChemin<E> {

	@Override
	public List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee) {
		
		Map<Noeud<E>, Double> coutEstime = new HashMap<>();
        Map<Noeud<E>, Double> coutActuel = new HashMap<>();
        Map<Noeud<E>, Noeud<E>> predecesseurs = new HashMap<>();
        PriorityQueue<Noeud<E>> aExplorer = new PriorityQueue<>(Comparator.comparingDouble(coutEstime::get));
        Set<Noeud<E>> dejaExplore = new HashSet<>();

        // Initialisation des coûts estimés
        coutEstime.put(depart, estimationHeuristique(depart, arrivee));
        coutActuel.put(depart, 0.0);
        aExplorer.add(depart);
        
        
        while (!aExplorer.isEmpty()) {
            Noeud<E> noeudActuel = aExplorer.poll();
            if (noeudActuel.equals(arrivee)) {
                return reconstructionChemin(arrivee, predecesseurs);
            }
            dejaExplore.add(noeudActuel);
            for (Noeud<E> voisin : graphe.getVoisins(noeudActuel)) {
                if (!dejaExplore.contains(voisin)) {
                	double nouveauCout = coutActuel.get(noeudActuel) + graphe.getCoutArete(noeudActuel, voisin);
                    if (!coutActuel.containsKey(voisin) || nouveauCout < coutActuel.get(voisin)) {
                        coutActuel.put(voisin, nouveauCout);
                        coutEstime.put(voisin, nouveauCout + estimationHeuristique(voisin, arrivee));
                        predecesseurs.put(voisin, noeudActuel);
                        aExplorer.add(voisin);
                    }
                }
            }
        }
        return null; // Aucun chemin trouvé
	}
	
	/**
	 * 
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
	
	/**
	 * Estimation heuristique
	 * @param noeud
	 * @param arrivee
	 * @return un double
	 */
    private double estimationHeuristique(Noeud<E> noeud, Noeud<E> arrivee) {
        return 0.0;
    }

}
