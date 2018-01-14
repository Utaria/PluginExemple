package fr.utaria.exemple.demo.menu;

import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.menus.MenuSize;
import fr.utaria.utariacore.menus.items.SkullItem;
import org.bukkit.entity.Player;

public class MonMenu2 extends Menu {

	private Player joueur;

	public MonMenu2(Player joueur) {
		super("Mon menu 2", MenuSize.TWO_LINE);

		this.joueur = joueur;
		this.preparer();
	}

	private void preparer() {
		// J'ai accès au joueur à qui je vais ouvrir le menu ici.
		SkullItem tete = new SkullItem(this.joueur.getName(), this.joueur.getName());
		this.setItem(0, tete);
	}

}
