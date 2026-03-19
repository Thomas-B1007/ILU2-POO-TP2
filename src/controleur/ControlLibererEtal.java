package controleur;

import villagegaulois.Etal;

public class ControlLibererEtal {
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	public ControlLibererEtal(
			ControlTrouverEtalVendeur controlTrouverEtalVendeur) {
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isVendeur(String nomVendeur) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal != null;
	}

	/**
	 * 
	 * @param nomVendeur
	 * @return donneesEtal est un tableau de chaine contenant
	 * 		[0] : un boolean indiquant si l'étal est occupé
	 * 		[1] : nom du vendeur
	 * 		[2] : produit vendu
	 * 		[3] : quantité de produit à vendre au début du marché
	 * 		[4] : quantité de produit vendu
	 */
	public String[] libererEtal(String nomVendeur) {
		String[] donneesEtal = new String[5];
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		Boolean occupe = etal.isEtalOccupe();
		donneesEtal[0] = occupe.toString();
		donneesEtal[1] = nomVendeur;
		String produit = etal.getProduit();
		donneesEtal[2] = produit;
		Integer nbProduit = etal.getQuantite();
		donneesEtal[3] = nbProduit.toString();
		//A FINIR
		return donneesEtal;
	}

}
