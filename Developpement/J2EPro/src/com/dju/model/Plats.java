package com.dju.model;

import java.util.*;

public class Plats extends Produits
{
    public Plats()
    {
    }

    private int id_plat;

    private String type_cuisine;

    private int nb_plat;

    private boolean chaud;

    private String type_plat;

	public int getId_plat() {
		return id_plat;
	}

	public void setId_plat(int id_plat) {
		this.id_plat = id_plat;
	}

	public String getType_cuisine() {
		return type_cuisine;
	}

	public void setType_cuisine(String type_cuisine) {
		this.type_cuisine = type_cuisine;
	}

	public int getNb_plat() {
		return nb_plat;
	}

	public void setNb_plat(int nb_plat) {
		this.nb_plat = nb_plat;
	}

	public boolean isChaud() {
		return chaud;
	}

	public void setChaud(boolean chaud) {
		this.chaud = chaud;
	}

	public String getType_plat() {
		return type_plat;
	}

	public void setType_plat(String type_plat) {
		this.type_plat = type_plat;
	}
}