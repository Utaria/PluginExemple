package fr.utaria.exemple.demo.database;

import fr.utaria.utariadatabase.database.Database;
import fr.utaria.utariadatabase.database.DatabaseAccessor;

// On peut aussi lier toute une classe à une base de données
// en héritant celle-ci par un DatabaseAccessor.
public class MaSuperClasse extends DatabaseAccessor {

	public MaSuperClasse() {
		// On a juste à passer le nom de la table au constructeur parent.
		super("MASUPERBASE");

		// Pas besoin de faire un DatabaseManager.registerDatabase("MASUPERBASE");
	}

	public void maMethode() {
		// On peut ensuite récupérer la base partout dans la classe avec un getDB() :
		Database maSuperBase = this.getDB();
	}

}
