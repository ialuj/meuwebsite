package br.com.builders.buildersclientsmngapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

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
import br.com.builders.buildersclientsmngapi.repositories.ClientRepository;
import br.com.builders.buildersclientsmngapi.utils.BusinessException;

@Service
public class ClientQueryServiceImpl implements IClientQueryService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client findClientById(Long id) {

		Optional<Client> optClient = clientRepository.findById(id);

		if (!optClient.isPresent()) {
			throw new BusinessException("Client com ID: " + id + " não encontrado no sistema!");
		}

		return optClient.get();
	}

	@Override
	public List<Client> listAllClients() {
		return clientRepository.findAll();
	}

	@Override
	public Page<Client> listClientsByPageAndSize(int page, int size) {

		PageRequest pageRequest = PageRequest.of(page, size, Direction.ASC, "fullName");

		return clientRepository.findAll(pageRequest);
	}

	@Override
	public int getPageNumbers(int size) {
		List<Client> clients = clientRepository.findAll();

		if (clients.size() == 0) {
			return 0;
		}

		int pageNumbers = clients.size() / size;

		if (clients.size() % size == 0) {
			return pageNumbers;
		} else {
			return pageNumbers + 1;
		}
	}

	@Override
	public List<Client> findByClientFields(FullName fullName, BirthDate birthDate, Rg rg, Cpf cpf,
			PhoneNumber phoneNumber, Email email, State state, Neighbourhood neighbourhood, AvenueRoad avenueOrRoad,
			HouseNumber houseNumber) {
		return clientRepository
				.findByFullNameOrBirthDateOrRgOrCpfOrPhoneNumberOrEmailOrStateOrAvenueRoadOrNeighbourhoodOrHouseNumber(
						fullName, birthDate, rg, cpf, phoneNumber, email, state, avenueOrRoad, neighbourhood,
						houseNumber);
	}

}
