package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
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
	void testControlVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		assertNotNull(controlVerifierIdentite, "constructeur ne renvoie pas null");
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		Gaulois asterix = new Gaulois("Asterix", 5);
		village.ajouterHabitant(asterix);
		assertTrue(controlVerifierIdentite.verifierIdentite("Asterix"),"Villageois vérifié");
		village.installerVendeur(asterix, "sanglier", 3);
		assertTrue(controlVerifierIdentite.verifierIdentite("Asterix"),"Vendeur vérifié");
		assertFalse(controlVerifierIdentite.verifierIdentite("Existe pas"),"Vérification existe pas");
	}

}
