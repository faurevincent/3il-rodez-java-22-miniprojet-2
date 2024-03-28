package fr.ecole3il.rodez2023.carte;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeChemin;
import fr.ecole3il.rodez2023.carte.elements.Carte;
import fr.ecole3il.rodez2023.carte.elements.Case;
import fr.ecole3il.rodez2023.carte.elements.Chemin;
import fr.ecole3il.rodez2023.carte.elements.Graphe;
import fr.ecole3il.rodez2023.carte.elements.Noeud;

public class AdaptateurAlgorithme {
	
	/**
	 * Renvoie le plus court chemin entre deux noeuds
	 * @param algorithme
	 * @param carte
	 * @param xDepart
	 * @param yDepart
	 * @param xArrivee
	 * @param yArrivee
	 * @return
	 */
	public static Chemin trouverChemin(AlgorithmeChemin<Case> algorithme, Carte carte, int xDepart, int yDepart, int xArrivee, int yArrivee) {
		
		Graphe<Case> g = creerGraphe(carte);
		
        Noeud<Case> noeudDepart = g.getNoeud(xDepart, yDepart);
        
        Noeud<Case> noeudArrivee = g.getNoeud(xArrivee, yArrivee);
        
        List<Noeud<Case>> list = algorithme.trouverChemin(g, noeudDepart, noeudArrivee);
		
		return list == null ? new Chemin(new ArrayList<Case>()) : new Chemin(list.stream().map(n -> n.getValeur()).collect(Collectors.toList()));
	}
	
	/**
	 * Création du graphe depuis la carte
	 * @param carte
	 * @return un graphe
	 */
	static Graphe <Case> creerGraphe(Carte carte){
		
		Graphe<Case> graphe = new Graphe<>();
        int largeur = carte.getLargeur();
        int hauteur = carte.getHauteur();
        
        // Création des nœuds pour chaque case de la carte
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
            	Case c = new Case(carte.getTuile(x, y), x, y);
                Noeud<Case> noeud = new Noeud(c);
                graphe.ajouterNoeud(noeud);
            }
        }
        
        // Ajout des arêtes entre les cases voisines
        for (int x = 0; x < largeur; x++) {
            for (int y = 0; y < hauteur; y++) {
                Case currentCase = new Case(carte.getTuile(x, y), x, y);
                ajouterAretesVoisines(graphe, currentCase, x, y, largeur, hauteur);
            }
        }
        
        return graphe;
	}

	/**
	 * Ajout des arretes pour une case courante
	 * @param graphe
	 * @param currentCase
	 * @param x
	 * @param y
	 * @param largeur
	 * @param hauteur
	 */
	static void ajouterAretesVoisines(Graphe<Case> graphe, Case currentCase, int x, int y, int largeur, int hauteur) {
		int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] direction : directions) {
            int voisinX = x + direction[0];
            int voisinY = y + direction[1];
            if (voisinX >= 0 && voisinX < largeur && voisinY >= 0 && voisinY < hauteur) {
                double cout = calculerCout(currentCase, graphe.getNoeud(voisinX, voisinY).getValeur());
                graphe.getNoeud(x, y).ajouterVoisin(graphe.getNoeud(voisinX, voisinY)); // Ajout du voisin au noeud
                graphe.ajouterArete(graphe.getNoeud(x, y), graphe.getNoeud(voisinX, voisinY), cout);
            }
        }
	}
	
	/**
	 * Calcul du cout
	 * @param from
	 * @param to
	 * @return
	 */
	static double calculerCout(Case from, Case to) {
		return from.getTuile().getPenalite() + to.getTuile().getPenalite();
	}
	
	/**
	 * Affichage en console du chemin
	 * @param chemin
	 */
	static void afficherChemin(List<Noeud<Case>> chemin) {
		for(Noeud<Case> n : chemin) {
			System.out.println(n.getValeur().toString());
		}
	}
}
