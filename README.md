---
titre: Java
sous-titre: Miniprojet 2 - Repérage et direction sur une carte en 2D
auteur: Vincent \textsc{Faure}
date: 3iL 1A 2023
---

**Date de rendu du projet : 28/03/2024**

# Mini projet 2

### Les réalisations

J'ai pu tout réaliser.

### Réponses aux questions

**Question :** Quelle structure de données pourrait être utilisée pour stocker les relations entre les nœuds du graphe et les informations associées à ces relations, comme les coûts des arêtes ?

Une matrice d'adjacence que l'on représenterait en Java par une `Map<Noeud<E>, Map<Noeud<E>, Double>>` avec le premier `Noeud<E>` qui représente le nœud courant et dans la deuxième `Map`, on retrouve le nœud voisin relié par une arête et le coût.

**Question :** Pourquoi pensez-vous que les classes `Noeud` et `Graphe` ont été définies avec des paramètres génériques ?

Les classes Noeud et Graphe ont été définies avec des paramètres génériques pour offrir une plus grande flexibilité et une réutilisation du code dans différents contextes.

**Question :** Pourquoi pensez-vous que la création d'une interface est une bonne pratique dans ce contexte ?

Ici, on applique le principe de ségrégation d'interface, donc on reste SOLID...
De plus, si l'on souhaite implémenter différentes versions de l'algorithme, alors c'est possible.
Ce qui nous mènera par la suite, pour l'utilisation, à déclarer l'attribut de telle manière que l'on puisse lui affecter n'importe quelle implémentation ; ici, c'est l'inversion des dépendances qui rentre en compte.

### Retour personnel

J'ai eu quelques difficultés à comprendre comment calculer le cout d'une arête et comment faire l'estimation sinon dans l'ensemble tout c'est bien passer.




