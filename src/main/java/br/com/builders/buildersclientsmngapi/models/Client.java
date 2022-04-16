package br.com.builders.buildersclientsmngapi.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
public class Client extends AbstractAggregateRoot<Client> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded
	@Column(name = "full_name")
	@NotNull(message = "Full name can not be empty")
	private FullName fullName;

	@Embedded
	@Column(name = "birth_date")
	@NotNull(message = "Birth date can not be empty")
	private BirthDate birthDate;

	@Embedded
	@Column(name = "rg")
	@NotNull(message = "RG can not be empty")
	private Rg rg;

	@Embedded
	@Column(name = "cpf")
	@NotNull(message = "CPF can not be empty")
	private Cpf cpf;

	@Embedded
	@Column(name = "phone_number")
	private PhoneNumber phoneNumber;

	@Embedded
	@Column(name = "email")
	private Email email;

	@Column(name = "state")
	@NotNull(message = "State can not be empty")
	private State state;

	@Column(name = "neighbourhood")
	@NotNull(message = "Neighbourhood can not be empty")
	private Neighbourhood neighbourhood;

	@Column(name = "avenue_road")
	@NotNull(message = "Avenue or road can not be empty")
	private AvenueRoad avenueRoad;

	@Column(name = "house_number")
	@NotNull(message = "House number can not be empty")
	private HouseNumber houseNumber;

	public Client() {
		super();
	}

	public Client(@NotEmpty(message = "Client Full Name can not be empty") String fullName,
			@NotNull(message = "Client Birth Date can not be null") LocalDate birthDate,
			@NotEmpty(message = "RG can not be empty") String rg,
			@NotEmpty(message = "CPF can not be empty") String cpf, String phoneNumber, String email, String state,
			String neighbourhood, String avenueRoad, String houseNumber) {
		this(new FullName(fullName), new BirthDate(birthDate), new Rg(rg), new Cpf(cpf), new PhoneNumber(phoneNumber),
				new Email(email), new State(state), new Neighbourhood(neighbourhood), new AvenueRoad(avenueRoad),
				new HouseNumber(houseNumber));
	}

	public Client(@NotNull(message = "Full name can not be empty") FullName fullName,
			@NotNull(message = "Birth date can not be empty") BirthDate birthDate,
			@NotNull(message = "RG can not be empty") Rg rg, @NotNull(message = "CPF can not be empty") Cpf cpf,
			PhoneNumber phoneNumber, Email email, @NotNull(message = "State can not be empty") State state,
			@NotNull(message = "Neighbourhood can not be empty") Neighbourhood neighbourhood,
			@NotNull(message = "Avenue or road can not be empty") AvenueRoad avenueRoad,
			@NotNull(message = "House number can not be empty") HouseNumber houseNumber) {
		super();
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.rg = rg;
		this.cpf = cpf;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.state = state;
		this.neighbourhood = neighbourhood;
		this.avenueRoad = avenueRoad;
		this.houseNumber = houseNumber;
	}

	public Client(Long id, @NotNull(message = "Full name can not be empty") FullName fullName,
			@NotNull(message = "Birth date can not be empty") BirthDate birthDate,
			@NotNull(message = "RG can not be empty") Rg rg, @NotNull(message = "CPF can not be empty") Cpf cpf,
			PhoneNumber phoneNumber, Email email, @NotNull(message = "State can not be empty") State state,
			@NotNull(message = "Neighbourhood can not be empty") Neighbourhood neighbourhood,
			@NotNull(message = "Avenue or road can not be empty") AvenueRoad avenueRoad,
			@NotNull(message = "House number can not be empty") HouseNumber houseNumber) {
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
		this.avenueRoad = avenueRoad;
		this.houseNumber = houseNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FullName getFullName() {
		return fullName;
	}

	public void setFullName(FullName fullName) {
		this.fullName = fullName;
	}

	public BirthDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(BirthDate birthDate) {
		this.birthDate = birthDate;
	}

	public Rg getRg() {
		return rg;
	}

	public void setRg(Rg rg) {
		this.rg = rg;
	}

	public Cpf getCpf() {
		return cpf;
	}

	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Neighbourhood getNeighbourhood() {
		return neighbourhood;
	}

	public void setNeighbourhood(Neighbourhood neighbourhood) {
		this.neighbourhood = neighbourhood;
	}

	public AvenueRoad getAvenueRoad() {
		return avenueRoad;
	}

	public void setAvenueRoad(AvenueRoad avenueRoad) {
		this.avenueRoad = avenueRoad;
	}

	public HouseNumber getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(HouseNumber houseNumber) {
		this.houseNumber = houseNumber;
	}

	public int getAge() {
		return LocalDate.now().getYear() - this.getBirthDate().getBirthDate().getYear();
	}

}
