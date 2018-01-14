package fr.utaria.exemple.demo.hologram;

import fr.utaria.utariacore.hologram.placeholder.PlaceholderAccessor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

// Votre classe doit hériter du PlaceholderAccessor pour devenir un accesseur
// de données pour les hologrammes.
public class DonneesHologram implements PlaceholderAccessor {

	// La méthode getValue est appelée lorsque qu'une variable doit être remplacée
	@Override
	public String getValue(String variable) {
		// A vous de faire du cas par cas et de retourner la valeur souhaitée ;)
		switch (variable) {
			case "vie":
				return String.valueOf(Bukkit.getPlayer("Utarwyn").getHealth());
			case "unite":
				return "<3";

			case "var1":
				return ChatColor.DARK_AQUA + "ma valeur dynamique";
			case "var2":
				return "coucou, j'aime Utaria";
		}

		return "";
	}

}
