package fr.utaria.exemple.demo;

import fr.utaria.utariacore.zones.ZoneManager;
import fr.utaria.utariacore.zones.flags.Flags;
import fr.utaria.utariacore.zones.zone.ChunkZone;
import fr.utaria.utariacore.zones.zone.CuboidZone;
import fr.utaria.utariacore.zones.zone.WorldZone;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class DemoZones {

	public static void main(String[] args) {
		/* -------------------------------
		 * --- Création & Suppresssion ---
		 * ------------------------------- */

		// Création d'une zone dans un chunk en particulier.
		// On retrouve le monde du chunk, et ses coordonées X et Z.
		ChunkZone zone = ZoneManager.createChunkZone("MONDE", 0, 0);

		// Création d'une zone entre deux positions (pavé droit)
		// On retrouve les deux objets des positions.
		Location pos1 = new Location(Bukkit.getWorld("MONDE"), -50, 80, -50);
		Location pos2 = new Location(Bukkit.getWorld("MONDE"), 50, 100, 50);
		CuboidZone zone2 = ZoneManager.createCuboidZone(pos1, pos2);

		// Création d'une zone dans un monde entier
		// On retrouve le nom du monde.
		WorldZone zone3 = ZoneManager.createWorldZone("MONDE");

		// Suppression d'une zone du cache
		if (!ZoneManager.removeZone(zone2))
			System.out.println("La zone n'a pas pu être supprimée !");

		ZoneManager.removeZone(zone3);


		/* ----------------------------
		 * --- Gestion des drapeaux ---
		 * ---------------------------- */

		// Appliquer des drapeaux d'INTERDICTION.
		zone2.disallows(
				Flags.PVP, Flags.BLOCK_BREAK, Flags.BLOCK_PLACE
		);

		// Appliquer des drapeaux de PERMISSION.
		// (par défaut quasiment tous les drapeaux sont autorisés !)
		zone.allows(
				Flags.TNT
		);

		// Applique une priorité sur une zone.
		// Les drapeaux de celle-ci seront donc prioritaires sur les
		// zones moins prioritaires (priorité par défaut = 0).
		zone.setPriority(10);

		// Supprime un drapeau d'une zone.
		zone2.removeFlag(Flags.BLOCK_BREAK);

		/* ----------------------------------
		 * --- Gestion des supers-membres ---
		 * ---------------------------------- */

		// A venir ...


		/* ------------------------
		 * --- Méthodes annexes ---
		 * ------------------------ */

		// Permet de tester si un joueur/une position est à l'intérieur
		// de la zone souhaitée.
		boolean estALinterieur = zone2.isInside(/* Objet du joueur ici */Bukkit.getPlayer("Utarwyn"));

		Location loc = new Location(Bukkit.getWorld("WORLD"), -25, 85, 25);
		boolean ok = zone2.isInside(loc);

	}

}
