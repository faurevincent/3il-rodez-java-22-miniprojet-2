package fr.ecole3il.rodez2023.carte.elements.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.ecole3il.rodez2023.carte.AdaptateurAlgorithme;
import fr.ecole3il.rodez2023.carte.chemin.algorithmes.AlgorithmeAEtoile;
import fr.ecole3il.rodez2023.carte.elements.Carte;
import fr.ecole3il.rodez2023.carte.elements.Case;
import fr.ecole3il.rodez2023.carte.elements.Chemin;
import fr.ecole3il.rodez2023.carte.elements.Tuile;

class AdaptateurAlgorithmeTest {

    private Carte carte;

    @BeforeEach
    void setUp() {
        // Création d'une matrice de tuiles fictive pour les tests
        Tuile[][] tuiles = {
            {Tuile.PLAINE, Tuile.PLAINE, Tuile.PLAINE},
            {Tuile.PLAINE, Tuile.PLAINE, Tuile.PLAINE},
            {Tuile.PLAINE, Tuile.PLAINE, Tuile.PLAINE}
        };
        carte = new Carte(tuiles); // Création de la carte avec les tuiles fictives
    }

    @Test
    void testTrouverChemin() {
        // Création d'un algorithme fictif (dans ce cas, l'algorithme A*)
        AlgorithmeAEtoile<Case> algorithme = new AlgorithmeAEtoile<>();

        // Appel de la méthode trouverChemin avec des coordonnées de départ et d'arrivée
        Chemin chemin = AdaptateurAlgorithme.trouverChemin(algorithme, carte, 0, 0, 2, 2);

        // Vérifications
        assertNotNull(chemin); // Le chemin ne doit pas être nul
        assertEquals(5, chemin.getCases().size()); // Le nombre de cases dans le chemin doit être 3 (départ, intermédiaire, arrivée)
        assertEquals(Tuile.PLAINE, chemin.getCases().get(0).getTuile()); // La première case doit être une plaine (départ)
        assertEquals(Tuile.PLAINE, chemin.getCases().get(1).getTuile()); // La deuxième case doit être une plaine (intermédiaire)
        assertEquals(Tuile.PLAINE, chemin.getCases().get(2).getTuile()); // La troisième case doit être une plaine (intermédiaire)
        assertEquals(Tuile.PLAINE, chemin.getCases().get(3).getTuile()); // La quatrième case doit être une plaine (intermédiaire)
        assertEquals(Tuile.PLAINE, chemin.getCases().get(4).getTuile()); // La cinquième case doit être une plaine (arrivée)
    }
}


