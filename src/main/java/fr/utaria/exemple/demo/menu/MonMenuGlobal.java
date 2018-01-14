package fr.utaria.exemple.demo.menu;

import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.menus.MenuSize;
import fr.utaria.utariacore.menus.items.SubMenuItem;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MonMenuGlobal extends Menu {

	public MonMenuGlobal() {
		super("Mon menu global", MenuSize.ONE_LINE);

		this.preparer();
	}

	private void preparer() {
		// Item pour aller dans un autre menu ...
		MonSousMenu monFils = new MonSousMenu(this);
		SubMenuItem emeraude = new SubMenuItem("Ma super émeraude", new ItemStack(Material.EMERALD), monFils);

		this.setItem(0, emeraude);
	}

}
