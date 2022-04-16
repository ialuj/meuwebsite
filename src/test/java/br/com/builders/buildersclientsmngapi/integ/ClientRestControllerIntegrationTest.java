package br.com.builders.buildersclientsmngapi.integ;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class ClientRestControllerIntegrationTest {

	@Autowired
	private MockMvc mock;

	@Test
	public void testWelcomeMessage() throws Exception {
		this.mock.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Hello! Welcome to API"))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void registerClient() throws Exception {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("{\"fullName\":\"Icaro Guerreiro\",\"birthDate\":\"1761-03-10\",\"rg\":\"207067314\",");
		stringBuilder.append(
				"\"cpf\":\"09868783836\",\"phoneNumber\":\"15 98118 3885\",\"email\":\"icaro.guerra@gmail.com\",\"state\":\"SP\",");
		stringBuilder.append(
				"\"neighbourhood\":\"Bairro da Tijuca\",\"avenueRoad\":\"Av. Sao Joao\",\"houseNumber\":\"345\"}");

		this.mock
				.perform(MockMvcRequestBuilders.post("/clients").contentType("application/json;charset=UTF-8")
						.content(stringBuilder.toString()))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	}
	
	@Test
	public void updateClient() throws Exception {
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"{\"id\":6,\"fullName\":\"Gabriel Jesus\",\"birthDate\":\"1999-03-10\",\"rg\":\"436847371\",\"cpf\":\"49711512491\",");
		stringBuilder.append(
				"\"phoneNumber\":\"15 98118 3885\",\"email\":\"gabriel.jesus2022@gmail.com\",\"state\":\"RJ\",\"neighbourhood\":\"Flamengo\",");
		stringBuilder.append("\"avenueRoad\":\"Avenida do Rio Grande\",\"houseNumber\":\"345\",\"age\":23}");

		this.mock
		.perform(MockMvcRequestBuilders.patch("/clients").param("id", "6").contentType("application/json;charset=UTF-8")
				.content("{\"email\":\"gabriel.jesus2022@gmail.com\", \"avenueRoad\":\"Avenida do Rio Grande\"}"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string(stringBuilder.toString()))
		.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void listClients() throws Exception {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"[{\"id\":1,\"fullName\":\"Ana Maria dos Santos\",\"birthDate\":\"1991-03-10\",\"rg\":\"324125239\",");
		stringBuilder.append(
				"\"cpf\":\"17632330909\",\"phoneNumber\":\"15 98118 3885\",\"email\":\"ana.santos@gmail.com\",\"state\":\"SP\",");
		stringBuilder.append(
				"\"neighbourhood\":\"Bairro da Tijuca\",\"avenueRoad\":\"Av. Sao Joao\",\"houseNumber\":\"345\",\"age\":31},");
		stringBuilder.append(
				"{\"id\":2,\"fullName\":\"Ana Paulo Gabriela\",\"birthDate\":\"1995-04-25\",\"rg\":\"125565616\",\"cpf\":\"39858767463\",");
		stringBuilder.append(
				"\"phoneNumber\":\"15 98118 3885\",\"email\":\"ana.gabrila@gmail.com\",\"state\":\"RJ\",\"neighbourhood\":\"Caju\",");
		stringBuilder.append("\"avenueRoad\":\"Av. Sao Joao\",\"houseNumber\":\"345\",\"age\":27},");
		stringBuilder.append(
				"{\"id\":6,\"fullName\":\"Gabriel Jesus\",\"birthDate\":\"1999-03-10\",\"rg\":\"436847371\",\"cpf\":\"49711512491\",");
		stringBuilder.append(
				"\"phoneNumber\":\"15 98118 3885\",\"email\":\"gabriel.jesus2022@gmail.com\",\"state\":\"RJ\",\"neighbourhood\":\"Flamengo\",");
		stringBuilder.append("\"avenueRoad\":\"Avenida do Rio Grande\",\"houseNumber\":\"345\",\"age\":23},");
		stringBuilder.append(
				"{\"id\":11,\"fullName\":\"Icaro Guerreiro\",\"birthDate\":\"1761-03-09\",\"rg\":\"207067314\",\"cpf\":\"09868783836\",");
		stringBuilder.append(
				"\"phoneNumber\":\"15 98118 3885\",\"email\":\"icaro.guerra@gmail.com\",\"state\":\"SP\",\"neighbourhood\":\"Bairro da Tijuca\",");
		stringBuilder.append("\"avenueRoad\":\"Av. Sao Joao\",\"houseNumber\":\"345\",\"age\":261},");
		stringBuilder.append(
				"{\"id\":5,\"fullName\":\"InÃ¡cio Damasceno\",\"birthDate\":\"1992-03-10\",\"rg\":\"248524276\",\"cpf\":\"84793544029\",");
		stringBuilder.append(
				"\"phoneNumber\":\"15 98118 3885\",\"email\":\"inacio.damasceno@gmail.com\",\"state\":\"SP\",\"neighbourhood\":\"Casa Verde\",");
		stringBuilder.append("\"avenueRoad\":\"Av. Sao Joao\",\"houseNumber\":\"345\",\"age\":30}]");

		this.mock.perform(MockMvcRequestBuilders.get("/clients").param("page", "0").param("size", "5"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(stringBuilder.toString()))
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void listClientsByRegisterFields() throws Exception {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(
				"[{\"id\":1,\"fullName\":\"Ana Maria dos Santos\",\"birthDate\":\"1991-03-10\",\"rg\":\"324125239\",");
		stringBuilder.append(
				"\"cpf\":\"17632330909\",\"phoneNumber\":\"15 98118 3885\",\"email\":\"ana.santos@gmail.com\",\"state\":\"SP\",");
		stringBuilder.append(
				"\"neighbourhood\":\"Bairro da Tijuca\",\"avenueRoad\":\"Av. Sao Joao\",\"houseNumber\":\"345\",\"age\":31}]");
		
		this.mock
				.perform(MockMvcRequestBuilders.get("/clients/byAnyField").contentType("application/json;charset=UTF-8")
						.content("{\"rg\":\"324125239\"}"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(stringBuilder.toString()))
				.andDo(MockMvcResultHandlers.print());
	}

}
