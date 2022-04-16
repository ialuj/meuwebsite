package br.com.builders.buildersclientsmngapi.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.builders.buildersclientsmngapi.models.AvenueRoad;
import br.com.builders.buildersclientsmngapi.models.BirthDate;
import br.com.builders.buildersclientsmngapi.models.Client;
import br.com.builders.buildersclientsmngapi.models.Cpf;
import br.com.builders.buildersclientsmngapi.models.Email;
import br.com.builders.buildersclientsmngapi.models.FullName;
import br.com.builders.buildersclientsmngapi.models.HouseNumber;
import br.com.builders.buildersclientsmngapi.models.Neighbourhood;
import br.com.builders.buildersclientsmngapi.models.PhoneNumber;
import br.com.builders.buildersclientsmngapi.models.Rg;
import br.com.builders.buildersclientsmngapi.models.State;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ClientQueryServiceImplTest {

	@Autowired
	private IClientQueryService clientQueryService;

	@Test
	public void listAllClients() {

		List<Client> clients = clientQueryService.listAllClients();

		assertFalse(clients.isEmpty());

	}

	@Test
	public void listClientsPage1() {

		int page = 0;

		int size = 5;

		Page<Client> pageClients = clientQueryService.listClientsByPageAndSize(page, size);

		List<Client> clients = pageClients.getContent();

		assertFalse(clients.isEmpty());
	}

	@Test
	public void listClientsPage2() {

		int page = 1;

		int size = 5;

		Page<Client> pageClients = clientQueryService.listClientsByPageAndSize(page, size);

		List<Client> clients = pageClients.getContent();

		assertFalse(clients.isEmpty());
	}

	@Test
	public void showPageNumbers() {

		int pageNumbers = clientQueryService.getPageNumbers(5);

		assertNotEquals(0, pageNumbers);

		assertEquals(3, pageNumbers);

	}

	@Test
	public void listClientsByFields() {
		
		FullName fullName = new FullName("Ana Maria dos Santos");
		
		BirthDate birthDate = new BirthDate(LocalDate.parse("1991-03-10"));
		
		Rg rg = new Rg("324125239");

		Cpf cpf = new Cpf("17632330909");
		
		PhoneNumber phoneNumber = new PhoneNumber("15 98118 3885");
		
		Email email = new Email("ana.santos@gmail.com");
		
		State state = new State("SP");
		
		Neighbourhood neighbourhood = new Neighbourhood("Bairro da Tijuca");
		
		AvenueRoad avenueOrRoad = new AvenueRoad("Av. Sao Joao");
		
		HouseNumber houseNumber = new HouseNumber("345");

		List<Client> clients = clientQueryService.findByClientFields(fullName, birthDate, rg, cpf, phoneNumber, email,
				state, neighbourhood, avenueOrRoad, houseNumber);
		
		assertFalse(clients.isEmpty());

	}

}
