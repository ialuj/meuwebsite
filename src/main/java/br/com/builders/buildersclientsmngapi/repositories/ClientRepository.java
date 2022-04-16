package br.com.builders.buildersclientsmngapi.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

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

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	@Query("SELECT c FROM Client c")
	public Page<Client> listClients(Pageable pageable);

	public List<Client> findByCpf(Cpf cpf);

	public List<Client> findByFullNameOrBirthDateOrRgOrCpfOrPhoneNumberOrEmailOrStateOrAvenueRoadOrNeighbourhoodOrHouseNumber(
			FullName fullName, BirthDate birthDate, Rg rg, Cpf cpf, PhoneNumber phoneNumber, Email email, State state,
			AvenueRoad avenueOrRoad, Neighbourhood neighbourhood, HouseNumber houseNumber);

}
