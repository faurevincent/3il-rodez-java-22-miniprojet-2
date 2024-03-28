package fr.ecole3il.rodez2023.carte.elements.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ecole3il.rodez2023.carte.elements.Case;
import fr.ecole3il.rodez2023.carte.elements.Graphe;
import fr.ecole3il.rodez2023.carte.elements.Noeud;
import fr.ecole3il.rodez2023.carte.elements.Tuile;

class GrapheTest {
    private Graphe<Case> graphe;

    @BeforeEach
    void setUp() {
        graphe = new Graphe<>();
    }

    @Test
    void testAjouterNoeud() {
        Noeud<Case> nouveauNoeud = new Noeud<>(new Case(Tuile.PLAINE, 0, 0));
        graphe.ajouterNoeud(nouveauNoeud);
        assertTrue(graphe.getNoeuds().contains(nouveauNoeud));
    }

    @Test
    void testAjouterArete() {
        Noeud<Case> depart = new Noeud<>(new Case(Tuile.PLAINE, 0, 0));
        Noeud<Case> arrivee = new Noeud<>(new Case(Tuile.FORET, 1, 0));
        graphe.ajouterArete(depart, arrivee, 2);
        assertEquals(2, graphe.getCoutArete(depart, arrivee));
    }
}


