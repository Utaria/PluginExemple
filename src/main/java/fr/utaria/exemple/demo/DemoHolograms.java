package fr.utaria.exemple.demo;

import fr.utaria.exemple.demo.hologram.DonneesHologram;
import fr.utaria.utariacore.hologram.Hologram;
import fr.utaria.utariacore.hologram.HologramManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DemoHolograms {

	public static void main(String[] args) {
		/* -------------------------------
		 * --- Création & Suppresssion ---
		 * ------------------------------- */

		// On créé d'abord notre objet d'hologramme en lui passant la position de celui-ci.
		Location source = new Location(Bukkit.getWorld("MONDE"), 150, 80, 150);
		Hologram hologram = HologramManager.createHologram(source);
		// L'hologramme est automatiquement créé, il ne reste plus qu'à le configuer avec toutes les méthodes ;-)

		// Pour le supprimer, rien de plus simple:
		HologramManager.removeHologram(hologram);
		// Ne pas utiliser hologram.delete() pour le supprimer, il ne sera alors pas supprimé du cache.

		/* -----------------------
		 * --- Ajout de lignes ---
		 * ----------------------- */

		// On peut ajouter des lignes avec ...
		hologram.appendTextLine(ChatColor.YELLOW + "Ma ligne de texte simple !"); // Texte simple statique

		hologram.appendDataLine("Vie d'Utarwyn : %vie% %unite%"); // Peut contenir des variables sous la forme %nom%

		hologram.appendItemLine(new ItemStack(Material.ANVIL)); // Ajoute un item à l'hologramme !

		// On peut aussi utiliser les méthodes d'insertion si on veut choisir la position
		hologram.insertDataLine(0, "Ma ligne avec variables %var1% %var2%");

		hologram.insertTextLine(1, "Ligne de texte" + ChatColor.RED + " simple!");

		hologram.insertItemLine(2, new ItemStack(Material.APPLE));


		/* ----------------------------------------------------------
		 * --- Gestion des variables dans des lignes avec données ---
		 * ---------------------------------------------------------- */

		// Ajout d'un accesseur à variable - Voir classe DonneesHologram !
		hologram.addPlaceholderAccessor(new DonneesHologram());


		/* -------------------------------
		 * --- Liaison avec une entité ---
		 * ------------------------------- */

		// On peut faire en sorte que l'hologramme suive automatiquement une entité avec :
		hologram.attachTo(/* Objet de l'entité ici */ null);

		// Pour supprimer l'hologramme quand l'entité attachée meurt :
		hologram.setDeletedWhenEntityDead(true);


		/* -----------------------
		 * --- Autres méthodes ---
		 * ----------------------- */

		// Suppression de toutes les lignes
		hologram.clearLines();

		// Pour téléporter l'hologramme
		hologram.teleport(/* Position où téléporter l'hologramme */ null);

		// Pour récupérer le nombre de lignes
		int lignes = hologram.size();
		System.out.println("Lignes = " + lignes);
	}

}
