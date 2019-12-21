package br.com.sig.msadmin.entrypoint;

import java.sql.Timestamp;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.sig.msadmin.core.entity.PerfilEquipeEntity;
import br.com.sig.msadmin.core.usecase.CadastrarPerfilEquipeUseCase;
import br.com.sig.msadmin.entrypoint.entity.PerfilEquipeHttpModel;

@RunWith(MockitoJUnitRunner.class)
public class PerfilEquipeEntrypointTest {
	
	@InjectMocks
	private PerfilEquipeEntrypoint entrypoint;
	
	@Mock
	private CadastrarPerfilEquipeUseCase useCase;
	
	private Date date = new Date();
	
	@Test
	public void CadastrarPerfilEquipeEntrypoint_success() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		PerfilEquipeEntity PerfilEquipe = PerfilEquipeEntity.builder()
				.id(1L)
				.nome("perfil Equipe")
				.sigla("PEQ")
				.veiculoId(2L)
				.profissionaisId(3L)
				.descricaoEquipamentos("Teste de equipamentos do perfil de equipe")
				.qtEquipamento(2)
				.dataCadastro(date)
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
				.dataCadastro(date)
				.idCadastro(1L)
				.build();
		
		Mockito.when(useCase.cadastrarPerfilEquipe(Mockito.any(PerfilEquipeEntity.class))).thenReturn(PerfilEquipe);
		
		ResponseEntity<PerfilEquipeHttpModel> response = entrypoint.cadastrarPerfilEquipe(httpmodel);
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());	
	}	

}
