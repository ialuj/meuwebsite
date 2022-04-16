package br.com.builders.buildersclientsmngapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.builders.buildersclientsmngapi.models.Client;
import br.com.builders.buildersclientsmngapi.models.dto.ClientDTO;
import br.com.builders.buildersclientsmngapi.repositories.ClientRepository;
import br.com.builders.buildersclientsmngapi.utils.BusinessException;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client addClient(ClientDTO clientDTO) {
		
		Client client = clientDTO.toClient();

		if (client.getFullName() == null || client.getCpf() == null || client.getBirthDate() == null
				|| client.getRg() == null || !StringUtils.hasLength(client.getFullName().getFullName())
				|| client.getBirthDate().getBirthDate() == null || !StringUtils.hasLength(client.getCpf().getCpf())
				|| !StringUtils.hasLength(client.getRg().getRg()))
			throw new BusinessException("É obrigatório indicar o nome completo, data de nascimento, CPF e RG!");

		List<Client> clients = clientRepository.findByCpf(client.getCpf());

		if (!clients.isEmpty()) {
			throw new BusinessException("Já existe um Cliente cadastrado com o CPF: " + client.getCpf());
		}

		return clientRepository.save(client);
	}

	@Override
	public Client updateClient(Long id, ClientDTO clientDTO) {

		Optional<Client> optClient = clientRepository.findById(id);

		if (!optClient.isPresent()) {
			throw new BusinessException("Client com ID: " + id + " não encontrado no sistema!");
		}
		
		ClientDTO dto = new ClientDTO(optClient.get());
		
		dto.setFieldsToUpdate(clientDTO);

		return clientRepository.save(dto.toClient());
	}

}
