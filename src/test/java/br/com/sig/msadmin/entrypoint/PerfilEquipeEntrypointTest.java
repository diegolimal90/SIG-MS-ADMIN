package br.com.sig.msadmin.entrypoint;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import br.com.sig.msadmin.core.entity.PerfilEquipeEntity;
import br.com.sig.msadmin.core.usecase.CadastrarPerfilEquipeUseCase;
import br.com.sig.msadmin.core.usecase.PesquisarPerfilEquipeUseCase;
import br.com.sig.msadmin.entrypoint.entity.PerfilEquipeHttpModel;

@RunWith(MockitoJUnitRunner.class)
public class PerfilEquipeEntrypointTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private PerfilEquipeEntrypoint entrypoint;
	
	@Mock
	private CadastrarPerfilEquipeUseCase cadastrarPerfilEquipeUseCase;
	
	@Mock
	private PesquisarPerfilEquipeUseCase perfilEquipeUseCase;
		
	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.entrypoint).build();
	}
	
	@Test
	public void CadastrarPerfilEquipeEntrypointStatusCode_201() throws JsonProcessingException, Exception {
	
		PerfilEquipeEntity PerfilEquipe = PerfilEquipeEntity.builder()
				.id(1L)
				.nome("perfil Equipe")
				.sigla("PEQ")
				.veiculoId(2L)
				.profissionaisId(3L)
				.descricaoEquipamentos("Teste de equipamentos do perfil de equipe")
				.qtEquipamento(2)
				.idCadastro(1L)
				.build();
		
		PerfilEquipeHttpModel httpmodel = PerfilEquipeHttpModel.builder()
				.id(1L)
				.nome("perfil Equipe")
				.sigla("PEQ")
				.veiculoId(2L)
				.profissionaisId(3L)
				.descricaoEquipamentos("Teste de equipamentos do perfil de equipe")
				.qtEquipamento(2)
				.idCadastro(1L)
				.build();
		
		Mockito.when(cadastrarPerfilEquipeUseCase.cadastrarPerfilEquipe(Mockito.any(PerfilEquipeEntity.class))).thenReturn(PerfilEquipe);
		
		this.mockMvc.perform(
				MockMvcRequestBuilders
				.post("/perfilequipes/")
				.contentType(MediaType.APPLICATION_JSON)
				.content( new ObjectMapper().writeValueAsString(httpmodel) )
				).andExpect(status().isCreated());	
	}
	
	@Test
	public void PesquisarPerfilEquipeEntrypointStatusCode_200() throws Exception {
	
		List<PerfilEquipeEntity> listPerfilEquipe = new ArrayList<>();
				
		PerfilEquipeEntity perfilEquipe = PerfilEquipeEntity.builder()
				.id(1L)
				.nome("perfil Equipe")
				.sigla("PEQ")
				.veiculoId(2L)
				.profissionaisId(3L)
				.descricaoEquipamentos("Teste de equipamentos do perfil de equipe")
				.qtEquipamento(2)
				.idCadastro(1L)
				.build();
		
		listPerfilEquipe.add(perfilEquipe);
		
		Mockito.when(perfilEquipeUseCase.pesquisarPerfilEquipe()).thenReturn(listPerfilEquipe);
		
		this.mockMvc.perform(
				MockMvcRequestBuilders
				.get("/perfilequipes/")
				).andExpect(status().isOk());	
	}
}
