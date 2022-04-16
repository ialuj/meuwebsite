package br.com.builders.buildersclientsmngapi.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
import br.com.builders.buildersclientsmngapi.models.dto.ClientDTO;
import br.com.builders.buildersclientsmngapi.services.IClientQueryService;
import br.com.builders.buildersclientsmngapi.services.IClientService;
import br.com.builders.buildersclientsmngapi.utils.BusinessException;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = { "*" })
public class ClientControllers {

	@Autowired
	private IClientService clientService;

	@Autowired
	private IClientQueryService clientQueryService;

	@PostMapping
	public ResponseEntity<ClientDTO> registerClient(@RequestBody ClientDTO clientDTO) {
		try {

			Client savedClient = clientService.addClient(clientDTO);

			ClientDTO dto = new ClientDTO(savedClient);

			ResponseEntity<ClientDTO> response = ResponseEntity.ok(dto);

			return response;

		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PatchMapping
	public ResponseEntity<ClientDTO> updateClient(@RequestParam("id") Long id, @RequestBody ClientDTO clientDTO) {
		try {

			Client savedClient = clientService.updateClient(id, clientDTO);

			ClientDTO dto = new ClientDTO(savedClient);

			ResponseEntity<ClientDTO> response = ResponseEntity.ok(dto);

			return response;

		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping
	public ResponseEntity<List<ClientDTO>> listClients(@RequestParam("page") int page, @RequestParam("size") int size) {

		int pageNumbers = clientQueryService.getPageNumbers(size);

		if (pageNumbers == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		try {
			Page<Client> pageClients = clientQueryService.listClientsByPageAndSize(page, size);

			List<ClientDTO> dtos = pageClients.getContent().stream().map(ClientDTO::new).collect(Collectors.toList());

			ResponseEntity<List<ClientDTO>> response = ResponseEntity.ok(dtos);

			return response;
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/byAnyField")
	public ResponseEntity<List<ClientDTO>> listClientsByRegisterFields(@RequestBody ClientDTO dto) {

		try {

			FullName fullName = StringUtils.hasLength(dto.getFullName()) ? new FullName(dto.getFullName()) : null;
			BirthDate birthDate = dto.getBirthDate() != null ? new BirthDate(dto.getBirthDate()) : null;
			Rg rg = StringUtils.hasLength(dto.getRg()) ? new Rg(dto.getRg()) : null;
			Cpf cpf = StringUtils.hasLength(dto.getCpf()) ? new Cpf(dto.getCpf()) : null;
			PhoneNumber phoneNumber = StringUtils.hasLength(dto.getPhoneNumber())
					? new PhoneNumber(dto.getPhoneNumber())
					: null;
			Email email = StringUtils.hasLength(dto.getEmail()) ? new Email(dto.getEmail()) : null;
			State state = StringUtils.hasLength(dto.getState()) ? new State(dto.getState()) : null;
			Neighbourhood neighbourhood = StringUtils.hasLength(dto.getNeighbourhood())
					? new Neighbourhood(dto.getNeighbourhood())
					: null;
			AvenueRoad avenueOrRoad = StringUtils.hasLength(dto.getAvenueRoad())
					? new AvenueRoad(dto.getAvenueRoad())
					: null;
			HouseNumber houseNumber = StringUtils.hasLength(dto.getHouseNumber())
					? new HouseNumber(dto.getHouseNumber())
					: null;

			List<Client> clients = clientQueryService.findByClientFields(fullName, birthDate, rg, cpf, phoneNumber,
					email, state, neighbourhood, avenueOrRoad, houseNumber);

			List<ClientDTO> dtos = clients.stream().map(ClientDTO::new).collect(Collectors.toList());

			ResponseEntity<List<ClientDTO>> response = ResponseEntity.ok(dtos);

			return response;
		} catch (BusinessException e) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

}
