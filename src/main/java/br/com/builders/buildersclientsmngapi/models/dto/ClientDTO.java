package br.com.builders.buildersclientsmngapi.models.dto;

import java.time.LocalDate;

import org.springframework.util.StringUtils;

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

public class ClientDTO {

	private Long id;

	private String fullName;

	private LocalDate birthDate;

	private String rg;

	private String cpf;

	private String phoneNumber;

	private String email;

	private String state;

	private String neighbourhood;

	private String avenueRoad;

	private String houseNumber;

	private int age;

	public ClientDTO() {
		super();
	}

	public ClientDTO(String fullName, LocalDate birthDate, String rg, String cpf, String phoneNumber, String email,
			String state, String neighbourhood, String avenueOrRoad, String houseNumber) {
		super();
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.rg = rg;
		this.cpf = cpf;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.state = state;
		this.neighbourhood = neighbourhood;
		this.avenueRoad = avenueOrRoad;
		this.houseNumber = houseNumber;
	}

	public ClientDTO(Long id, String fullName, LocalDate birthDate, String rg, String cpf, String phoneNumber,
			String email, String state, String neighbourhood, String avenueOrRoad, String houseNumber) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.rg = rg;
		this.cpf = cpf;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.state = state;
		this.neighbourhood = neighbourhood;
		this.avenueRoad = avenueOrRoad;
		this.houseNumber = houseNumber;
	}

	public ClientDTO(Client client) {
		this.setId(this.getId() == null ? client.getId() : this.getId());
		this.setFullName(
				!StringUtils.hasLength(this.getFullName()) ? client.getFullName().getFullName() : this.getFullName());
		this.setBirthDate(this.getBirthDate() == null ? client.getBirthDate().getBirthDate() : this.getBirthDate());
		this.setRg(!StringUtils.hasLength(this.getRg()) ? client.getRg().getRg() : this.getRg());
		this.setCpf(!StringUtils.hasLength(this.getCpf()) ? client.getCpf().getCpf() : this.getCpf());
		this.setPhoneNumber(!StringUtils.hasLength(this.getPhoneNumber()) ? client.getPhoneNumber().getPhoneNumber()
				: this.getPhoneNumber());
		this.setEmail(!StringUtils.hasLength(this.getEmail()) ? client.getEmail().getEmail() : this.getEmail());
		this.setState(!StringUtils.hasLength(this.getState()) ? client.getState().getState() : this.getState());
		this.setNeighbourhood(
				!StringUtils.hasLength(this.getNeighbourhood()) ? client.getNeighbourhood().getNeighbourhood()
						: this.getNeighbourhood());
		this.setAvenueRoad(!StringUtils.hasLength(this.getAvenueRoad()) ? client.getAvenueRoad().getAvenueRoad()
				: this.getAvenueRoad());
		this.setHouseNumber(!StringUtils.hasLength(this.getHouseNumber()) ? client.getHouseNumber().getHouseNumber()
				: this.getHouseNumber());
		this.setAge(client.getAge());
	}

	public Client toClient() {
		return this.getId() == null
				? new Client(new FullName(this.getFullName()), new BirthDate(this.getBirthDate()), new Rg(this.getRg()),
						new Cpf(this.getCpf()), new PhoneNumber(this.getPhoneNumber()), new Email(this.getEmail()),
						new State(this.getState()), new Neighbourhood(this.getNeighbourhood()),
						new AvenueRoad(this.getAvenueRoad()), new HouseNumber(this.getHouseNumber()))
				: new Client(this.getId(), new FullName(this.getFullName()), new BirthDate(this.getBirthDate()),
						new Rg(this.getRg()), new Cpf(this.getCpf()), new PhoneNumber(this.getPhoneNumber()),
						new Email(this.getEmail()), new State(this.getState()),
						new Neighbourhood(this.getNeighbourhood()), new AvenueRoad(this.getAvenueRoad()),
						new HouseNumber(this.getHouseNumber()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(String neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public String getAvenueRoad() {
		return avenueRoad;
	}

	public void setAvenueRoad(String avenueRoad) {
		this.avenueRoad = avenueRoad;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setFieldsToUpdate(ClientDTO dto) {
		this.setBirthDate(dto.getBirthDate() != null ? dto.getBirthDate() : this.getBirthDate());
		this.setPhoneNumber(
				StringUtils.hasLength(dto.getPhoneNumber()) ? dto.getPhoneNumber() : this.getPhoneNumber());
		this.setEmail(StringUtils.hasLength(dto.getEmail()) ? dto.getEmail() : this.getEmail());
		this.setState(StringUtils.hasLength(dto.getState()) ? dto.getState() : this.getState());
		this.setNeighbourhood(
				StringUtils.hasLength(dto.getNeighbourhood()) ? dto.getNeighbourhood() : this.getNeighbourhood());
		this.setAvenueRoad(
				StringUtils.hasLength(dto.getAvenueRoad()) ? dto.getAvenueRoad() : this.getAvenueRoad());
		this.setHouseNumber(
				StringUtils.hasLength(dto.getHouseNumber()) ? dto.getHouseNumber() : this.getHouseNumber());
	}
}
