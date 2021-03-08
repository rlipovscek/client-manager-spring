package com.calro.clientmanager.helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.calro.clientmanager.entities.ClientEntity;
import com.calro.clientmanager.enums.ClientType;
import com.github.javafaker.Faker;

public class MockHelper {

	private static final Faker faker = new Faker(new Locale("pt-BR"));
	
	private static int ID = 100;

	private static List<ClientEntity> getClientList(int size, ClientType type) {

		List<ClientEntity> list = new ArrayList<>();

		for (int i = 1; i <= size; i++) {
			list.add(getClient(type));
		}

		return list;
	}

	public static List<ClientEntity> getClientListPerson(int size) {
		return getClientList(size, ClientType.CPF);
	}

	public static List<ClientEntity> getClientListCompany(int size) {
		return getClientList(size, ClientType.CNPJ);
	}

	public static List<ClientEntity> getClientListCompanyAndPerson(int personSize, int companySize) {
		List<ClientEntity> list = new ArrayList<>();

		list.addAll(getClientListCompany(companySize));
		list.addAll(getClientListPerson(personSize));

		return list;

	}

	private static String getDocument(ClientType type) {

		String document = "###########";

		if (ClientType.CNPJ.equals(type)) {
			document = document.concat("###");
		}
		return faker.numerify(document);
	}

	private static String getName(ClientType type) {

		if (ClientType.CPF.equals(type)) {
			return faker.name().fullName();
		}
		return faker.company().name();

	}

	public static ClientEntity getClient(ClientType type) {
		ClientEntity client = ClientEntity.builder().document(getDocument(type)).name(getName(type)).type(type)
				.id(++ID).build();

		return client;
	}

}
