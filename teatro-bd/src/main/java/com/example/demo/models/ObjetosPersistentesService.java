package com.example.demo.models;

public class ObjetosPersistentesService {

	static private ObjetosPersistentesService service;

	private ObjetosPersistentesService() {

	}

	public static ObjetosPersistentesService getService() {
		if (service == null) {
			service = new ObjetosPersistentesService();
		}
		return service;
	}

}
