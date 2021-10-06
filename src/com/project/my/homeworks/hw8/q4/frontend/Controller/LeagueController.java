package com.project.my.homeworks.hw8.q4.frontend.Controller;

import java.util.Random;

import com.project.my.homeworks.hw8.q4.backend.entities.City;
import com.project.my.homeworks.hw8.q4.backend.entities.Coach;
import com.project.my.homeworks.hw8.q4.backend.entities.Stadium;
import com.project.my.homeworks.hw8.q4.backend.entities.Team;
import com.project.my.homeworks.hw8.q4.backend.exceptions.ServiceExeption;
import com.project.my.homeworks.hw8.q4.backend.services.LeagueManager;

public class LeagueController {
	private LeagueManager leagueManager;

	public LeagueController() {
		leagueManager = new LeagueManager();
	}

	public void run() {
		System.out.println("starting...");
		try {
			leagueManager.initializeDatabase();
			initRandomLeague();
		} catch (ServiceExeption e) {
			e.printStackTrace();
			return;
		}
		System.out.println("finished...");
	}

	private void initRandomLeague() throws ServiceExeption {
		City tehran = new City("tehran");
		leagueManager.addCity(tehran);
		City esfahan = new City("esfahan");
		leagueManager.addCity(esfahan);
		City shiraz = new City("shiraz");
		leagueManager.addCity(shiraz);
		City mashad = new City("mashad");
		leagueManager.addCity(mashad);
		City tabriz = new City("tabriz");
		leagueManager.addCity(tabriz);
		City khuzestan = new City("khuzestan");
		leagueManager.addCity(khuzestan);
		City qaemshahr = new City("qaemshahr");
		leagueManager.addCity(qaemshahr);
		City arak = new City("arak");
		leagueManager.addCity(arak);
		City sirjan = new City("sirjan");
		leagueManager.addCity(sirjan);
		City masjedSoleiman = new City("masjed soleiman");
		leagueManager.addCity(masjedSoleiman);
		City abadan = new City("abadan");
		leagueManager.addCity(abadan);
		City rafsanjan = new City("rafsanjan");
		leagueManager.addCity(rafsanjan);

		Stadium azadi = new Stadium(tehran, "azadi", 100);
		leagueManager.addStadium(azadi);
		Stadium emamkhomeini = new Stadium(arak, "emamkhomeini", 15);
		leagueManager.addStadium(emamkhomeini);
		Stadium emamreza = new Stadium(mashad, "emamreza", 25);
		leagueManager.addStadium(emamreza);
		Stadium shahreQods = new Stadium(tehran, "shahreqods", 25);
		leagueManager.addStadium(shahreQods);
		Stadium yadegaremam = new Stadium(tabriz, "yadegaremam", 66);
		leagueManager.addStadium(yadegaremam);
		Stadium fooladshahr = new Stadium(esfahan, "fooladshahr", 15);
		leagueManager.addStadium(fooladshahr);
		Stadium naghshejahan = new Stadium(esfahan, "naghshe jahan", 75);
		leagueManager.addStadium(naghshejahan);
		Stadium takhti = new Stadium(abadan, "takhti", 20);
		leagueManager.addStadium(takhti);
		Stadium pars = new Stadium(shiraz, "pars", 50);
		leagueManager.addStadium(pars);
		Stadium fooladArena = new Stadium(khuzestan, "foolad arena", 40);
		leagueManager.addStadium(fooladArena);
		Stadium soleimani = new Stadium(sirjan, "soleimani", 8);
		leagueManager.addStadium(soleimani);
		Stadium sanatMes = new Stadium(rafsanjan, "sanate mes", 10);
		leagueManager.addStadium(sanatMes);
		Stadium shahna = new Stadium(qaemshahr, "shahna", 15);
		leagueManager.addStadium(shahna);
		Stadium behnam = new Stadium(masjedSoleiman, "behnam mohamadi", 8);
		leagueManager.addStadium(behnam);
		Stadium ghadir = new Stadium(tehran, "ghadir", 10);
		leagueManager.addStadium(ghadir);

		Coach[] coaches = new Coach[16];
		int[] coachIds = getRandomIntArray(coaches.length, 100, 100);
		for (int i = 1; i <= coaches.length; i++) {
			coaches[i - 1] = new Coach(coachIds[i - 1], "coach" + i);
			leagueManager.addCoach(coaches[i - 1]);
		}

		Team aluminium = new Team("aluminium", arak);
		Team esteghlal = new Team("esteghlal", tehran);
		Team padide = new Team("padide", mashad);
		Team perspolis = new Team("perspolis", tehran);
		Team peykan = new Team("peykan", tehran);
		Team teraktor = new Team("teraktor", tabriz);
		Team zobahan = new Team("zobahan", esfahan);
		Team sepahan = new Team("sepahan", esfahan);
		Team sanatNaft = new Team("sanate naft", abadan);
		Team fajrSepasi = new Team("fajre sepasi", shiraz);
		Team foolad = new Team("foolad", khuzestan);
		Team golgohar = new Team("gol gohar", sirjan);
		Team mes = new Team("mes", rafsanjan);
		Team nasaji = new Team("nasaji", qaemshahr);
		Team naftMasjed = new Team("naft masjed", masjedSoleiman);
		Team havadar = new Team("havadar", tehran);
	}

	private int[] getRandomIntArray(int length, int base, int max) {
		int[] randomArray = new int[length];
		Random random = new Random();
		int counter = 0;
		outer: while (counter < length) {
			int r = base + random.nextInt(max);
			for (int i = 0; i < counter; i++)
				if (randomArray[i] == r)
					continue outer;
			randomArray[counter++] = r;
		}
		return randomArray;
	}
}
