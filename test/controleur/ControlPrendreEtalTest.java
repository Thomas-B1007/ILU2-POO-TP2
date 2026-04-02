package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 2);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		Gaulois asterix = new Gaulois("Asterix", 10);
		Gaulois bonemine = new Gaulois("Bonemine", 7);
		Druide panoramix = new Druide("Panoramix", 5, 5, 8);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(bonemine);
		village.ajouterHabitant(panoramix);
	}

	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertNotNull(controlPrendreEtal, "constructeur ne renvoie pas null");
	}

	@Test
	void testResteEtals() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.resteEtals());
		controlPrendreEtal.prendreEtal("Asterix", "sangliers", 3);
		assertTrue(controlPrendreEtal.resteEtals());
		controlPrendreEtal.prendreEtal("Panoramix", "potions", 7);
		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertEquals(0, controlPrendreEtal.prendreEtal("Asterix", "sangliers", 3));
		assertEquals(1, controlPrendreEtal.prendreEtal("Panoramix", "potions", 7));
		assertEquals(-1, controlPrendreEtal.prendreEtal("Bonemince", "fleurs", 10));
	}

	@Test
	void testVerifierIdentite() {
		ControlPrendreEtal controlPrendreEtal = new ControlPrendreEtal(controlVerifierIdentite, village);
		assertTrue(controlPrendreEtal.verifierIdentite("Asterix"));
		assertTrue(controlPrendreEtal.verifierIdentite("Panoramix"));
		assertFalse(controlPrendreEtal.verifierIdentite("Existe pas"));
	}

}
