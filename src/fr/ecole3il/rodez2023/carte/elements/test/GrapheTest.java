package fr.ecole3il.rodez2023.carte.elements.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import fr.ecole3il.rodez2023.carte.elements.Graphe;

class GrapheTest {
	
	private Graphe graphe;
	
	@Nested
	class AjouterArreteTest{
	
		void ajouterArrete() {
			graphe.ajouterArete(null, null, 0.0);
		}
	}

}
