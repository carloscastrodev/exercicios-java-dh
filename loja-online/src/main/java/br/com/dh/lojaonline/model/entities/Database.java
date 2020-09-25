package br.com.dh.lojaonline.model.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {
	private static Map<String, List<Object>> database = new HashMap<>();
	private static List<Object> clientes = new ArrayList<>();
	private static List<Object> produtos = new ArrayList<>();

	public Database() {
		database.put("clientes", clientes);
		database.put("produtos", produtos);
	}

	public void save(String tabela, Object obj) {
		database.get(tabela).add(obj);
	}

	public List<Object> show(String tabela) {
		return database.get(tabela);
	}
}
