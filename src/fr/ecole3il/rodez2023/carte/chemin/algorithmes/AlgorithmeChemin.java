package fr.ecole3il.rodez2023.carte.chemin.algorithmes;

import java.util.List;

import fr.ecole3il.rodez2023.carte.elements.Graphe;
import fr.ecole3il.rodez2023.carte.elements.Noeud;

/**
 * Interface pour l'algorithme de plus court chemin
 * @param <E>
 */
public interface AlgorithmeChemin<E> {

	/**
	 * Trouber le chemin le plus court entre deux points
	 * @param graphe
	 * @param depart
	 * @param arrivee
	 * @return Une liste qui represente le chemin
	 */
	List<Noeud<E>> trouverChemin(Graphe<E> graphe, Noeud<E> depart, Noeud<E> arrivee);
}
