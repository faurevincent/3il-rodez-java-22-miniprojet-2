package fr.ecole3il.rodez2023.carte.elements.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeChemin;
import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeDijkstra;
import fr.ecole3il.rodez2023.carte.elements.Case;
import fr.ecole3il.rodez2023.carte.elements.Graphe;
import fr.ecole3il.rodez2023.carte.elements.Noeud;
import fr.ecole3il.rodez2023.carte.elements.Tuile;

class AlgorithmeDijkstraTest {
	
	/**
	 * Chemin fictif
	 */
	private static List<Noeud<Case>> cheminFictif;
	
	/**
	 * Algorithme pour trouver chemin le plus court
	 */
	private static AlgorithmeChemin<Case> algorithme;
	
	/**
	 * Graphe
	 */
	private static Graphe<Case> g;
	
	/**
	 * Noeud Arriver du test
	 */
	private static Noeud<Case> nA;
	
	/**
	 * Noeud Départ du test
	 */
	private static Noeud<Case> nD;
	
	private static List<Noeud<Case>> resultExpected;
	
	/**
	 * Création des objet nécessaire au test
	 */
	@BeforeAll
	static void setUpBeforeClass() {
		
		// Création du graphe
        g = new Graphe<>();

        // Création des cases
        Case caseA = new Case(Tuile.PLAINE, 0, 0);
        Case caseB = new Case(Tuile.FORET, 1, 0);
        Case caseC = new Case(Tuile.MONTAGNES, 2, 0);
        Case caseD = new Case(Tuile.DESERT, 2, 1);
        Case caseE = new Case(Tuile.PLAINE, 1, 1);

        // Ajout des cases au graphe
        g.ajouterNoeud(new Noeud<>(caseA));
        g.ajouterNoeud(new Noeud<>(caseB));
        g.ajouterNoeud(new Noeud<>(caseC));
        g.ajouterNoeud(new Noeud<>(caseD));
        g.ajouterNoeud(new Noeud<>(caseE));

        // Ajout des arêtes avec les coûts
        g.ajouterArete(g.getNoeud(0, 0), g.getNoeud(1, 0), 1); // CaseA -> CaseB
        g.ajouterArete(g.getNoeud(1, 0), g.getNoeud(2, 0), 3); // CaseB -> CaseC
        g.ajouterArete(g.getNoeud(1, 1), g.getNoeud(2, 1), 2); // CaseE -> CaseD
        g.ajouterArete(g.getNoeud(0, 0), g.getNoeud(1, 1), 4); // CaseA -> CaseE
        g.ajouterArete(g.getNoeud(2, 0), g.getNoeud(2, 1), 1); // CaseC -> CaseD

		
		cheminFictif = new ArrayList<>();
		cheminFictif.add(g.getNoeud(0, 0));  // Ajout du nœud de départ
		cheminFictif.add(g.getNoeud(1, 0));  // Ajout d'un nœud intermédiaire
		cheminFictif.add(g.getNoeud(2, 1));  // Ajout du nœud d'arrivée
		
		nD = g.getNoeud(0, 0); // CaseA
        nA = g.getNoeud(2, 1); // CaseD

		algorithme = new AlgorithmeDijkstra<Case>();
	}

	/**
	 * Test avec un Chemin fictif et un graphe fictif simple
	 */
	@Test
	void trouverChemin() {
		assertEquals(resultExpected, algorithme.trouverChemin(g, nD, nA));
	}

}
