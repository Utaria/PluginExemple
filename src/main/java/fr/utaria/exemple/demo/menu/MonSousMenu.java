package fr.utaria.exemple.demo.menu;

import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.menus.MenuSize;
import fr.utaria.utariacore.menus.items.BackItem;

public class MonSousMenu extends Menu {

	public MonSousMenu(Menu monPapa) {
		super("Sous menu, j'ai un papa !", MenuSize.ONE_LINE, monPapa);

		this.preparer();
	}

	private void preparer() {
		// Item pour revenir à mon menu papa :
		BackItem retour = new BackItem();
		this.setItem(8, retour);
	}

}
