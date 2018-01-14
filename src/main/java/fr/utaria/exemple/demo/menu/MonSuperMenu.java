package fr.utaria.exemple.demo.menu;

import fr.utaria.utariacore.menus.Menu;
import fr.utaria.utariacore.menus.MenuSize;
import fr.utaria.utariacore.menus.helper.DescriptionBuilder;
import fr.utaria.utariacore.menus.items.CloseItem;
import fr.utaria.utariacore.menus.items.SkullItem;
import fr.utaria.utariacore.menus.items.StaticMenuItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

// Je créé un menu qui DOIT hériter de la classe Menu
public class MonSuperMenu extends Menu {

	public MonSuperMenu() {
		// Je dois passer le titre et la taille du menu au constructeur parent
		super("Mon menu trop génial !", MenuSize.THREE_LINE);

		// Je peux lancer tout de suite une méthode pour préparer mon menu
		this.preparer();
	}

	// Dans cette méthode je vais insérer tous les items nécessaires
	private void preparer() {
		// Pour l'exemple, on ajoute dans le menu toutes les têtes des joueurs, alors:
		int indice = 0;
		for (Player player : Bukkit.getOnlinePlayers()) {
			// Si on la souhaite, on paramètre déjà la description de l'item.
			DescriptionBuilder db = new DescriptionBuilder();

			db.append("Ma ligne de description 1");
			db.append("Ma ligne de description 2");

			// On créé l'item qui va être une tête de joueur... en lui passant la description sous forme de tableau.
			SkullItem tete = new SkullItem(ChatColor.YELLOW + player.getDisplayName(), player.getName(), db.toArray());
			// WARN: on peut créer une tête sans description, car le 3ème paramètre est optionnel.

			// ... on peut effectuer une action lors du clic sur l'item :
			tete.onItemClick(evenement -> {
				Player celuiQuiAClique = evenement.getPlayer();

				celuiQuiAClique.sendMessage("Tu viens de cliquer sur la tête de " + player.getName() + " !");
			});

			// Et enfin on l'ajoute au menu !
			this.setItem(indice, tete);
			indice++;
		}

		// Item statique
		StaticMenuItem papier = new StaticMenuItem(ChatColor.DARK_PURPLE + "Mon super papier !", new ItemStack(Material.PAPER));
		// On peut aussi lui passer une description si besoin en 3ème paramètre !

		// On l'ajoute...
		this.setItem(25, papier);

		// Item pour fermer le menu à la fin du menu (place 26)
		this.setItem(26, new CloseItem());
	}

}
