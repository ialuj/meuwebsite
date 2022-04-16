package br.com.builders.buildersclientsmngapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.builders.buildersclientsmngapi.models.Client;
import br.com.builders.buildersclientsmngapi.models.Cpf;
import br.com.builders.buildersclientsmngapi.models.Email;
import br.com.builders.buildersclientsmngapi.models.PhoneNumber;
import br.com.builders.buildersclientsmngapi.models.dto.ClientDTO;
import br.com.builders.buildersclientsmngapi.utils.BusinessException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ClientServiceImplTest {

	@Autowired
	private IClientService clientService;

	@Autowired
	private IClientQueryService clientQueryService;

	@Test
	public void registerClient() {
		
		ClientDTO client = new ClientDTO("Fabio Goveia", LocalDate.parse("1993-04-15"), "216582726", "96521245678",
				"15 98118 3883", "fabio.goveia@gmail.com", "SP", "Vila Fermosa", "", "245");

		Client savedClient = clientService.addClient(client);

		assertNotNull(savedClient);
		assertNotNull(savedClient.getId());
		assertNotNull(savedClient.getCpf());
	}

	@Test
	public void shouldFailAddClientCPFInvalid() {

		try {
			ClientDTO client = new ClientDTO("Fabio Goveia", LocalDate.parse("1993-04-15"), "228258182", "965212456780",
					"15 98118 3883", "fabio.goveia@gmail.com", "SP", "Vila Fermosa", "", "245");

			Client savedClient = clientService.addClient(client);

			assertNotNull(savedClient);
			assertNotNull(savedClient.getId());
		} catch (BusinessException businessException) {
			assertEquals("CPF é inválido - 965212456780", businessException.getMessage());
		}
	}

	@Test
	public void shouldFailAddClientEmailInvalid() {

		try {
			ClientDTO client = new ClientDTO("Fabio Goveia", LocalDate.parse("1993-04-15"), "368041232", "87214726882",
					"15 98118 3883", "fabio.goveiagmail.com", "SP", "Vila Fermosa", "", "245");

			Client savedClient = clientService.addClient(client);

			assertNotNull(savedClient);
			assertNotNull(savedClient.getId());
		} catch (BusinessException businessException) {
			assertEquals("E-mail é inválido - fabio.goveiagmail.com", businessException.getMessage());
		}
	}

	@Test
	public void shouldFailAddClientPhoneNumberInvalid() {

		try {
			ClientDTO client = new ClientDTO("Berta Gabi Venus", LocalDate.parse("1993-04-15"), "132750569", "32860331468",
					"15 981100 3883", "fabio.goveia@gmail.com", "SP", "Vila Fermosa", "", "245");

			Client savedClient = clientService.addClient(client);

			assertNotNull(savedClient);
			assertNotNull(savedClient.getId());
		} catch (BusinessException businessException) {
			assertEquals("Celular é inválido - 15 981100 3883", businessException.getMessage());
		}
	}

	@Test
	public void shouldUpdateClient() {

		Client client = clientQueryService.findClientById(1L);

		client.setPhoneNumber(new PhoneNumber("15 98118 2884"));
		
		ClientDTO dto = new ClientDTO(client);

		Client savedClient = clientService.updateClient(1L, dto);

		assertNotNull(savedClient);
		assertNotNull(savedClient.getId());
		assertEquals("15 98118 2884", savedClient.getPhoneNumber().getPhoneNumber());
	}

	@Test
	public void shouldFailUpdateClientCPFInvalid() {

		try {
			Client client = clientQueryService.findClientById(1L);

			client.setCpf(new Cpf("717415021890"));
			
			ClientDTO dto = new ClientDTO(client);

			Client savedClient = clientService.updateClient(1L, dto);

			assertNotNull(savedClient);
			assertNotNull(savedClient.getId());
		} catch (BusinessException businessException) {
			assertEquals("CPF é inválido - 717415021890", businessException.getMessage());
		}
	}

	@Test
	public void shouldFailUpdateClientEmailInvalid() {

		try {
			Client client = clientQueryService.findClientById(1L);

			client.setEmail(new Email("ritsure.julai.josegmail.com"));
			
			ClientDTO dto = new ClientDTO(client);

			Client savedClient = clientService.updateClient(1L, dto);

			assertNotNull(savedClient);
			assertNotNull(savedClient.getId());
		} catch (BusinessException businessException) {
			assertEquals("E-mail é inválido - ritsure.julai.josegmail.com", businessException.getMessage());
		}
	}

	@Test
	public void shouldFailUpdateClientPhoneNumberInvalid() {

		try {
			Client client = clientQueryService.findClientById(1L);

			client.setPhoneNumber(new PhoneNumber("15 98118 28845"));
			
			ClientDTO dto = new ClientDTO(client);

			Client savedClient = clientService.updateClient(1L, dto);

			assertNotNull(savedClient);
			assertNotNull(savedClient.getId());
		} catch (BusinessException businessException) {
			assertEquals("Celular é inválido - 15 98118 28845", businessException.getMessage());
		}
	}

}
