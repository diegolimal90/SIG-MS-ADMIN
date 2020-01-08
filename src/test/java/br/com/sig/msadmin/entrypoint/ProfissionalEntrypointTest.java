package br.com.sig.msadmin.entrypoint;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.core.usecase.CadastrarProfissionalUseCase;
import br.com.sig.msadmin.entrypoint.entity.ProfissionalHttpModel;

@RunWith(MockitoJUnitRunner.class)
public class ProfissionalEntrypointTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private ProfissionalEntrypoint profissionalEntrypoint;
	
	@Mock
	private CadastrarProfissionalUseCase cadastrarProfissionalUseCase;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(profissionalEntrypoint).build();
	}
	
	@Test
	public void cadastrarProfissional_success() throws JsonProcessingException, Exception {
		ProfissionalHttpModel httpModel = ProfissionalHttpModel.builder().build();
		
		ProfissionalEntity entity = ProfissionalEntity.builder().build();
		
		Mockito.when(cadastrarProfissionalUseCase.cadastrarProfissional(Mockito.any(ProfissionalEntity.class)))
			.thenReturn(entity);
		
		this.mockMvc.perform(
				MockMvcRequestBuilders
				.post("/profissional/")
				.contentType(MediaType.APPLICATION_JSON)
				.content( new ObjectMapper().writeValueAsString(httpModel) )
				).andExpect(status().isCreated());
	}
}
