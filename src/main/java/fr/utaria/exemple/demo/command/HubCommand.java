package fr.utaria.exemple.demo.command;

import fr.utaria.utariacore.commands.AbstractCommand;
import fr.utaria.utariacore.commands.parameter.Parameter;
import fr.utaria.utariacore.players.PlayerInfo;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HubCommand extends AbstractCommand {

	public HubCommand() {
		// 1er argument: nom initial de la commande
		// Autres arguments: alias (si besoin, sinon ne rien mettre)
		super("hub", "lobby");

		/* -----------------
		 * --- OPTIONNEL ---
		 * ----------------- */

		// Défini la permission nécessaire pour executer la commande
		this.setPermission("command.hub");

		// Ajoute un paramètre nécessaire à l'execution de la commande
		this.addParameter(Parameter.STRING.withPlayersCompletion());             // Chaîne avec aide (liste des joueurs)
		this.addParameter(Parameter.STRING.withTabCompletions("test", "aide2")); // Chaîne avec aide personnalisée
		this.addParameter(Parameter.STRING);                                     // Chaîne sans aide
		this.addParameter(Parameter.INT.optional());                             // Entier optionnel

		// Ajoute une sous-commande à celle-ci, elle sera affichée dans l'aide (touche TAB)
		this.addSubCommand(new SousCommande());
		this.addSubCommand(/* Autre sous-commande */ null);
	}

	@Override
	public void perform(CommandSender commandSender) {
		// Méthode lancée lorsqu'un joueur ou la console execute la commande, utile dans certains cas.
	}

	@Override
	public void performPlayer(Player player, PlayerInfo playerInfo) {
		// Méthode lancée lorsqu'un joueur execute la commande

		/* --------------------------------
		 * --- Récupération d'arguments ---
		 * -------------------------------- */

		// 1 paramètre défini dans le constructeur = 1 argument ici
		// Donc si on suit la liste des paramètres ci-dessus, on a :
		// (chaque argument lu ne peut pas être relu)
		String joueur = this.readArg();  // 0
		String test = this.readArg();    // 1
		String chaine = this.readArg();  // 2
		Integer nombre = this.readArg(); // 3. Optionnel = peut être égal à null ici

		// On peut aussi obtenir un argument à un endroit précis sans soucis :
		String ch2 = this.readArgAt(2);

		// Pour les paramètres optionnels, on peut aussi faire :
		Integer nb = this.readArgAtOrDefault(3, 10); // Si le paramètre n'est pas rempli, on aura 10.

		System.out.println("joueur = " + joueur);
		System.out.println("test   = " + test);
		System.out.println("chaine = " + chaine);
		System.out.println("nombre = " + nombre);
		System.out.println("ch2    = " + ch2);
		System.out.println("nb     = " + nb);
	}

	@Override
	public void performConsole(CommandSender commandSender) {
		// Methode lancée lorsque la console execute la commande, utile dans certains cas.
	}
}
