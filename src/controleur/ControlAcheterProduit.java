package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public String[] trouverVendeurs(String produit) {
		Gaulois[] listeGaulois = village.rechercherVendeursProduit(produit);
		if (listeGaulois != null) {
			String[] listeNoms = new String[listeGaulois.length];
			for (int i = 0; i < listeGaulois.length; i++) {
				listeNoms[i] = listeGaulois[i].getNom();
			}
			return listeNoms;
		} else {
			return null;
		}
	}
	
	public boolean isHbitant(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

	
	public int acheterProduit(String nomVendeur, int quantite) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		int quantiteAchete = etal.acheterProduit(quantite);
		return quantiteAchete;
	}
}
