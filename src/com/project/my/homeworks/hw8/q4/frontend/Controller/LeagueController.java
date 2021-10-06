package com.project.my.homeworks.hw8.q4.frontend.Controller;

import com.project.my.homeworks.hw8.q4.backend.entities.City;
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
		try {
			leagueManager.initializeDatabase();
			initRandomLeague();
		} catch (ServiceExeption e) {
			e.printStackTrace();
			return;
		}
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
		Stadium emamkhomeini = new Stadium(arak, "emamkhomeini", 15);
		Stadium emamreza = new Stadium(mashad, "emamreza", 25);
		Stadium shahreQods = new Stadium(tehran, "shahreqods", 25);
		Stadium yadegaremam = new Stadium(tehran, "yadegaremam", 66);

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
		Team naft = new Team("naft", masjedSoleiman);
		Team havadar = new Team("havadar", tehran);
	}
}
