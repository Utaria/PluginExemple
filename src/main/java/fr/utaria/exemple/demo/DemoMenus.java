package fr.utaria.exemple.demo;

import fr.utaria.exemple.demo.menu.MonMenu2;
import fr.utaria.exemple.demo.menu.MonMenuGlobal;
import fr.utaria.exemple.demo.menu.MonSuperMenu;

public class DemoMenus {

	public static void main(String[] args) {
		// Pour créer un menu, il faut d'abord OBLIGATOIREMENT créer sa propre classe, exemple :
		MonSuperMenu menu = new MonSuperMenu();

		// On peut l'ouvrir à un joueur en particulier:
		menu.open(/* Objet du joueur ici */ null);


		// Si jamais le menu dépend d'un joueur, ne pas hésiter à passer le joueur via le contructeur:
		MonMenu2 menu2 = new MonMenu2(/* Objet du joueur ici */ null);
		// WARN: N'oubliez pas de le passer aussi dans la méthode open !
		menu2.open(/* Objet du joueur ici */ null);


		// Fonctionnement des menus parents et enfants (père - fils)
		// --> Voir les classes MonMenuGlobal et MonSousMenu.
		MonMenuGlobal global = new MonMenuGlobal();
		global.open(/* Objet du joueur ici */ null);
	}

}
