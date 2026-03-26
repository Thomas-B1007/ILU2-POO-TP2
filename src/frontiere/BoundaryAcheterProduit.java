package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.isHbitant(nomAcheteur)) {
			System.out.println("Je suis désolé " + nomAcheteur + " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			String[] listeVendeurs = controlAcheterProduit.trouverVendeurs(produit);
			if (listeVendeurs == null || listeVendeurs.length == 0) {
				System.out.println("Désolé, personne ne vend ce produit au marché.");
			} else {
				String nomVendeur = choisirVendeur(listeVendeurs, produit);
				System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur);
				System.out.println("Bonjour " + nomAcheteur);
				int quantite = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
				int quantiteAchete = controlAcheterProduit.acheterProduit(nomVendeur, quantite);
				if (quantiteAchete == 0) {
					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement il n'y en a plus !");
				} else if (quantiteAchete < quantite) {
					System.out.println(nomAcheteur + " veut acheter " + quantite + " " + produit + ", malheureusement " +
							nomVendeur + " n'y en a plus que " + quantiteAchete + ". " +
							nomAcheteur + "achète tout le stock de " + nomVendeur + ".");
				} else {
					System.out.println(nomAcheteur + " achète " + quantite + " " + produit + " à " + nomVendeur + ".");
				}
			}
		}
	}
	
	
	private String choisirVendeur(String[] listeVendeurs, String produit) {
		StringBuilder question = new StringBuilder();
		question.append("Chez quel commerçant voulez-vous acheter des ");
		question.append(produit +" :\n");
		for (int i = 0; i < listeVendeurs.length; i++) {
			question.append((i+1));
			question.append("- ");
			question.append(listeVendeurs[i]);
			question.append("\n");
		}
		int choixUtilisateur = -1;
		do {
			choixUtilisateur = Clavier.entrerEntier(question.toString());
		} while (choixUtilisateur < 1 || choixUtilisateur > listeVendeurs.length);
		return listeVendeurs[choixUtilisateur-1];
	}
}

