package br.com.sig.msadmin.entrypoint;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.core.usecase.CadastrarUnidadeUseCase;
import br.com.sig.msadmin.core.usecase.PesquisarUnidadeUseCase;
import br.com.sig.msadmin.entrypoint.entity.UnidadeHttpModel;

@RunWith(MockitoJUnitRunner.class)
public class UnidadeEntrypointTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private UnidadeEntrypoint entrypoint;
	
	@Mock
	private CadastrarUnidadeUseCase cadastrarUseCase;
	
	@Mock
	private PesquisarUnidadeUseCase pesquisarUseCase;
	
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.entrypoint).build();
	}
	
	@Test
	public void CadastrarUnidadeEntrypointStatusCode_201() throws JsonProcessingException, Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		UnidadeEntity unidade = UnidadeEntity.builder()
			.id(1L).tipo("base").nome("Teste unidade").cep("11700190").tipoLogradouro("Rua").logradouro("Espírito Santo")
			.numero(391).complemento("apto 122").regiao("Baixada Santista").bairro("Canto do Forte").cidade("Praia Grande").estado("SP")
			.referencia("Proximo a Fatec").dataCadastro(timestamp).idCadastro(22L).status(1).build();
		
		UnidadeHttpModel httpmodel = UnidadeHttpModel.builder()
			.id(1L).tipo("base").nome("Teste unidade").cep("11700190").tipoLogradouro("Rua").logradouro("Espírito Santo")
			.numero(391).complemento("apto 122").regiao("Baixada Santista").bairro("Canto do Forte").cidade("Praia Grande").estado("SP")
			.referencia("Proximo a Fatec").idCadastro(22L).build();
		
		Mockito.when(cadastrarUseCase.cadastrarUnidade(Mockito.any(UnidadeEntity.class))).thenReturn(unidade);
		
		this.mockMvc.perform(
				MockMvcRequestBuilders
				.post("/unidades/")
				.contentType(MediaType.APPLICATION_JSON)
				.content( new ObjectMapper().writeValueAsString(httpmodel) )
				).andExpect(status().isCreated());	
	}	
	
	@Test
	public void PesquisarUnidadeEntrypointStatusCode_200() throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		UnidadeEntity unidade = UnidadeEntity.builder()
			.id(1L).tipo("base").nome("Teste unidade").cep("11700190").tipoLogradouro("Rua").logradouro("Espírito Santo")
			.numero(391).complemento("apto 122").regiao("Baixada Santista").bairro("Canto do Forte").cidade("Praia Grande").estado("SP")
			.referencia("Proximo a Fatec").dataCadastro(timestamp).idCadastro(22L).status(1).build();
		
		List<UnidadeEntity> listEntity = new ArrayList<>();
		listEntity.add(unidade);
		
		Mockito.when(pesquisarUseCase.pesquisarUnidades()).thenReturn(listEntity);
		
		this.mockMvc.perform(
				MockMvcRequestBuilders
				.get("/unidades/")
				).andExpect(status().isOk());
	}
	
}