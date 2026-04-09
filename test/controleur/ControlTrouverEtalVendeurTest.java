package controleur;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		assertNotNull(controlTrouverEtalVendeur, "constructeur ne renvoie pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		Gaulois asterix = new Gaulois("Asterix", 5);
		village.ajouterHabitant(asterix);
		village.installerVendeur(asterix, "sangliers", 3);
		Etal etal = village.rechercherEtal(asterix);
		assertEquals("Trouver étal vendeur existe", etal, controlTrouverEtalVendeur.trouverEtalVendeur("Asterix"));
		assertEquals("Trouver étal vendeur existe pas", null, controlTrouverEtalVendeur.trouverEtalVendeur("Existe pas"));
	}

}
