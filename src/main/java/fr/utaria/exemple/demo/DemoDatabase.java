package fr.utaria.exemple.demo;

import fr.utaria.utariadatabase.database.Database;
import fr.utaria.utariadatabase.database.DatabaseManager;
import fr.utaria.utariadatabase.query.DeleteQuery;
import fr.utaria.utariadatabase.query.SavingQuery;
import fr.utaria.utariadatabase.query.SelectQuery;
import fr.utaria.utariadatabase.result.DatabaseSet;
import fr.utaria.utariadatabase.result.UpdateResult;

public class DemoDatabase {

	public static void main(String[] args) {
		// On enregistre d'abord la base de données souhaitée
		// et on se connecte à la base de données.
		DatabaseManager.registerDatabase("MASUPERBASE");

		// Et après on peut l'utiliser avec :
		Database maSuperBase = DatabaseManager.getDB("MASUPERBASE");


		/* ----------------------------
		 * --- Requête de sélection ---
		 * ---------------------------- */
		SelectQuery selectQuery = maSuperBase.select("monchamp1", "monchamp2");

		// On indique la table de séléction ...
		selectQuery.from("matable");

		// On peut choisir les résultats ...
		selectQuery.where("monchamp5 = ?", "monchamp78 = ?");
		// Les "?" représentent les valeurs (voir au-dessous)

		// On peut appliquer des ordres ...
		selectQuery.order("monchamp2 DESC", "monchamp10 ASC");

		// On applique les attributs sécurisés (ils vont remplacer DANS L'ORDRE LES "?")
		selectQuery.attributes("valeur1", 50);

		// *** Et on lance la requête !
		selectQuery.find(); // Pour une requête qui doit retourner une seule ligne
		selectQuery.findAll(); // Pour une requête qui doit retourner plusieurs lignes

		// On peut aussi enchainer toutes les méthodes
		DatabaseSet resultat = maSuperBase.select("monchamp1", "monchamp2")
				.from("matable")
				.where("monchamp5 = ?", "monchamp78 = ?")
				.order("monchamp2 DESC")
				.attributes("valeur1", 50)
				.find();

		// On analyse les résultats avec :
		for (DatabaseSet set : selectQuery.findAll()) {
			System.out.println("champ1 = " + set.getString("monchamp1"));
			System.out.println("champ2 = " + set.getInteger("monchamp2"));
		}


		/* ------------------------------
		 * --- Requête de mise à jour ---
		 * ------------------------------ */
		// On créé la requête avec la table à modifier
		SavingQuery savingQuery = maSuperBase.update("MATABLE");

		// On défini les champs à modifier ...
		savingQuery.fields("monchamp1", "monchamp2", "monchamp3");

		// On passe les valeurs à appliquer aux champs (dans l'ordre)
		savingQuery.values("mavaleur1", 50, 85.6);

		// Pour transformer la requête en UPDATE ...
		savingQuery.where("monchamp5 = ?", "monchamp4 = ?");

		// Attributs du UPDATE dans l'ordre des "?"
		savingQuery.attributes("coucou", "affff");

		// Et on execute la requête !
		savingQuery.execute();

		// On peut chaîner les méthodes
		maSuperBase.update("MATABLE").fields("champ1", "champ2").values("test", 80).execute();

		// On peut aussi avoir le résultat de la requête avec :
		UpdateResult resultat2 = savingQuery.execute();
		System.out.println("Nombre de lignes modifiées = " + resultat2.getRowsAffected());


		/* ------------------------------
		 * --- Requête de suppression ---
		 * ------------------------------ */
		// On créé la requête avec les conditions de suppression
		DeleteQuery deleteQuery = maSuperBase.delete("monchamp1 = ?", "monchamp45 = ?");

		// On précise la table
		deleteQuery.from("MATABLE");

		// Et les attributs pour remplacer les "?"
		deleteQuery.attributes("valeur 491", 50);

		// On execute !
		deleteQuery.execute();

		// On peut chaîner les méthodes :
		maSuperBase.delete("monchamp1 = ?", "monchamp45 = ?").from("MATABLE").attributes("valeur 491", 50).execute();
	}

}
