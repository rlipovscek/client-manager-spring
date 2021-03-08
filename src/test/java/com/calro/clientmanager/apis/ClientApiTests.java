package com.calro.clientmanager.apis;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.calro.clientmanager.ClientManagerApplication;
import com.calro.clientmanager.entities.ClientEntity;
import com.calro.clientmanager.enums.ClientType;
import com.calro.clientmanager.helpers.MockHelper;
import com.calro.clientmanager.services.ClientService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = { ClientManagerApplication.class })
public class ClientApiTests {

	private MockMvc mvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private ClientService clientService;


	@BeforeEach
	void initTest() {
		 mvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	void findByIdSuccess() throws Exception {	
		ClientEntity ent = MockHelper.getClient(ClientType.CPF);
		when(clientService.findById(anyInt())).thenReturn(ent);
		
		mvc.perform(get("/clients/{id}", 7)
		           .accept(MediaType.APPLICATION_JSON))
		           .andExpect(status().isOk())
		           .andExpect(jsonPath("$.name").value(ent.getName()));

	}
	
	
	@Test
	void findAll() throws Exception {	
		List<ClientEntity> list = MockHelper.getClientListCompanyAndPerson(3, 3);
		when(clientService.findAll()).thenReturn(list);
		
		mvc.perform(get("/clients")
		           .accept(MediaType.APPLICATION_JSON))
				   .andExpect(jsonPath("$.length()").value(list.size()))
		           .andExpect(status().isOk());
	}
	
	@Test
	void findAllCNPJ() throws Exception {	
		List<ClientEntity> list = MockHelper.getClientListCompany(3);
		when(clientService.findAllByType(ClientType.CNPJ.toString())).thenReturn(list);
		
		mvc.perform(get("/clients/documents?type={type}", ClientType.CNPJ.toString())
		           .accept(MediaType.APPLICATION_JSON))
				   .andExpect(jsonPath("$.length()").value(list.size()))
		           .andExpect(status().isOk());
	}
	
	@Test
	void notFindCNPJ() throws Exception {	
		when(clientService.findAllByType(ClientType.CNPJ.toString())).thenReturn(new ArrayList<ClientEntity>());
		
		mvc.perform(get("/clients/documents?type={type}", ClientType.CNPJ.toString())
		           .accept(MediaType.APPLICATION_JSON))
				   .andExpect(jsonPath("$.length()").value(0))
		           .andExpect(status().isOk());
	}
	
	@Test
	void findAllCPF() throws Exception {	
		List<ClientEntity> list = MockHelper.getClientListPerson(3);
		when(clientService.findAllByType(ClientType.CPF.toString())).thenReturn(list);
		
		mvc.perform(get("/clients/documents?type={type}", ClientType.CPF.toString())
		           .accept(MediaType.APPLICATION_JSON))
				   .andExpect(jsonPath("$.length()").value(list.size()))
		           .andExpect(status().isOk());
	}
	
	@Test
	void notFindCPF() throws Exception {	
		when(clientService.findAllByType(ClientType.CPF.toString())).thenReturn(new ArrayList<ClientEntity>());
		
		mvc.perform(get("/clients/documents?type={type}", ClientType.CPF.toString())
		           .accept(MediaType.APPLICATION_JSON))
				   .andExpect(jsonPath("$.length()").value(0))
		           .andExpect(status().isOk());
	}
	
	
}
