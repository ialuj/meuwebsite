package br.com.builders.buildersclientsmngapi.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.builders.buildersclientsmngapi.models.Client;
import br.com.builders.buildersclientsmngapi.models.Cpf;
import br.com.builders.buildersclientsmngapi.models.Email;
import br.com.builders.buildersclientsmngapi.models.PhoneNumber;
import br.com.builders.buildersclientsmngapi.utils.BusinessException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ClientRepositoryTest {

	@Autowired
	private ClientRepository clientRepository;

	@Test
	public void shouldAddClient() {

		Client client = new Client("Berta Gabi Venus", LocalDate.parse("1993-04-15"), "117446117", "77117374403", "15 98118 3883", "berta.venus@gmail.com",
				"SP", "Vila Fermosa", "", "245");

		Client savedClient = clientRepository.save(client);

		assertNotNull(savedClient);
		assertNotNull(savedClient.getId());
		assertNotNull(savedClient.getCpf());
	}

	@Test
	public void shouldFailAddClientCPFInvalid() {

		try {
			Client client = new Client("Berta Gabi Venus", LocalDate.parse("1993-04-15"), "117446117", "7711737440300", "15 98118 3883", "berta.venus@gmail.com",
					"SP", "Vila Fermosa", "", "245");

			Client savedClient = clientRepository.save(client);

			assertNotNull(savedClient);
			assertNotNull(savedClient.getId());
		} catch (BusinessException businessException) {
			assertEquals("CPF é inválido - 7711737440300", businessException.getMessage());
		}
	}

	@Test
	public void shouldFailAddClientEmailInvalid() {

		try {
			Client client = new Client("Berta Gabi Venus", LocalDate.parse("1993-04-15"), "117446117", "77117374403", "15 98118 3883", "berta.venusgmail.com",
					"SP", "Vila Fermosa", "", "245");

			Client savedClient = clientRepository.save(client);

			assertNotNull(savedClient);
			assertNotNull(savedClient.getId());
		} catch (BusinessException businessException) {
			assertEquals("E-mail é inválido - berta.venusgmail.com", businessException.getMessage());
		}
	}

	@Test
	public void shouldFailAddClientPhoneNumberInvalid() {

		try {
			Client client = new Client("Berta Gabi Venus", LocalDate.parse("1993-04-15"), "456848186", "95894143110", "15 9811 3883", "berta.venus@gmail.com",
					"SP", "Vila Fermosa", "", "245");

			Client savedClient = clientRepository.save(client);

			assertNotNull(savedClient);
			assertNotNull(savedClient.getId());
		} catch (BusinessException businessException) {
			assertEquals("Celular é inválido - 15 98118 38843", businessException.getMessage());
		}
	}
	
	

	@Test
	public void shouldUpdateClient() {

		Optional<Client> optClient = clientRepository.findById(1L);

		Client client = optClient.get();

		client.setPhoneNumber(new PhoneNumber("15 98118 2884"));

		Client savedClient = clientRepository.save(client);

		assertNotNull(savedClient);
		assertNotNull(savedClient.getId());
		assertEquals("15 98118 2884", savedClient.getPhoneNumber().getPhoneNumber());
	}

	@Test
	public void shouldFailUpdateClientCPFInvalid() {

		try {
			Optional<Client> optClient = clientRepository.findById(1L);

			Client client = optClient.get();

			client.setCpf(new Cpf("717415021890"));

			Client savedClient = clientRepository.save(client);

			assertNotNull(savedClient);
			assertNotNull(savedClient.getId());
		} catch (BusinessException businessException) {
			assertEquals("CPF é inválido - 717415021890", businessException.getMessage());
		}
	}

	@Test
	public void shouldFailUpdateClientEmailInvalid() {

		try {
			Optional<Client> optClient = clientRepository.findById(1L);

			Client client = optClient.get();

			client.setEmail(new Email("ritsure.julai.josegmail.com"));

			Client savedClient = clientRepository.save(client);

			assertNotNull(savedClient);
			assertNotNull(savedClient.getId());
		} catch (BusinessException businessException) {
			assertEquals("E-mail é inválido - ritsure.julai.josegmail.com", businessException.getMessage());
		}
	}

	@Test
	public void shouldFailUpdateClientPhoneNumberInvalid() {

		try {
			Optional<Client> optClient = clientRepository.findById(1L);

			Client client = optClient.get();

			client.setPhoneNumber(new PhoneNumber("15 98118 28845"));

			Client savedClient = clientRepository.save(client);

			assertNotNull(savedClient);
			assertNotNull(savedClient.getId());
		} catch (BusinessException businessException) {
			assertEquals("Celular é inválido - 15 98118 28845", businessException.getMessage());
		}
	}

	@Test
	public void shouldListAllClients() {

		List<Client> clients = clientRepository.findAll();

		assertFalse(clients.isEmpty());
	}

	@Test
	public void shouldListAllClientsPage1() {

		int page = 0;

		int size = 5;

		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "fullName");

		Page<Client> pageClients = clientRepository.listClients(pageRequest);

		List<Client> clients = pageClients.getContent();

		assertFalse(clients.isEmpty());
	}

	@Test
	public void shouldListAllClientsPage2() {

		int page = 1;

		int size = 5;

		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "fullName");

		Page<Client> pageClients = clientRepository.listClients(pageRequest);

		List<Client> clients = pageClients.getContent();

		assertTrue(!clients.isEmpty());
	}

}
