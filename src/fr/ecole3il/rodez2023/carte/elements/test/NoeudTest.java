package fr.ecole3il.rodez2023.carte.elements.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ecole3il.rodez2023.carte.elements.Case;
import fr.ecole3il.rodez2023.carte.elements.Noeud;
import fr.ecole3il.rodez2023.carte.elements.Tuile;

class NoeudTest {
    private Noeud<Case> noeud;

    @BeforeEach
    void setUp() {
        noeud = new Noeud<>(new Case(Tuile.PLAINE, 0, 0));
    }

    @Test
    void testGetValeur() {
        assertEquals(Tuile.PLAINE, noeud.getValeur().getTuile());
    }

    @Test
    void testAjouterVoisin() {
        Noeud<Case> voisin = new Noeud<>(new Case(Tuile.FORET, 1, 0));
        noeud.ajouterVoisin(voisin);
        assertTrue(noeud.getVoisins().contains(voisin));
    }
}
