package fr.utaria.exemple.demo.command;

import fr.utaria.utariacore.commands.AbstractCommand;
import fr.utaria.utariacore.commands.parameter.Parameter;
import fr.utaria.utariacore.players.PlayerInfo;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SousCommande extends AbstractCommand {

	SousCommande() {
		super("souscommande");

		// Ajout d'un paramètre de type "nombre flottant"
		this.addParameter(Parameter.FLOAT);
	}

	@Override
	public void perform(CommandSender commandSender) {

	}

	@Override
	public void performPlayer(Player player, PlayerInfo playerInfo) {

	}

	@Override
	public void performConsole(CommandSender commandSender) {

	}

}
