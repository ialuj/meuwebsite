package br.com.builders.buildersclientsmngapi.services;

import java.util.List;

import org.springframework.data.domain.Page;

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

/***
 * 
 * @author Jose Julai Ritsure
 *
 *         Interface that exposes client's query service
 *
 */
public interface IClientQueryService {

	public Client findClientById(Long id);

	public List<Client> listAllClients();

	public Page<Client> listClientsByPageAndSize(int page, int size);

	public int getPageNumbers(int size);

	public List<Client> findByClientFields(FullName fullName, BirthDate birthDate, Rg rg, Cpf cpf,
			PhoneNumber phoneNumber, Email email, State state, Neighbourhood neighbourhood, AvenueRoad avenueOrRoad,
			HouseNumber houseNumber);

}
