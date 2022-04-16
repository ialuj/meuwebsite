package br.com.builders.buildersclientsmngapi.services;

import br.com.builders.buildersclientsmngapi.models.Client;
import br.com.builders.buildersclientsmngapi.models.dto.ClientDTO;

/***
 * 
 * @author Jose Julai Ritsure
 *
 *         Interface that exposes client's create and update service
 *
 */
public interface IClientService {

	public Client addClient(ClientDTO clientDTO);

	public Client updateClient(Long id, ClientDTO clientDTO);

}
