package br.com.sig.msadmin.dataprovider;

import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sig.msadmin.core.entity.PerfilEquipeEntity;
import br.com.sig.msadmin.dataprovider.entity.PerfilEquipeTable;
import br.com.sig.msadmin.dataprovider.repository.PerfilEquipeRepository;
import br.com.sig.msadmin.exception.DataBaseException;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarPerfilEquipeDataProviderTest {
	
	@InjectMocks
	private PerfilEquipeDataProvider dataprovider;
	
	@Mock
	private PerfilEquipeRepository perfilEquipeRepository;
	
	private Date date = new Date();
	
	@Test
	public void cadastrarPerfilEquipe_success() {

		PerfilEquipeEntity perfilEquipe = PerfilEquipeEntity.builder()
			.id(1L)
			.nome("")
			.sigla("")
			.veiculoId(2L)
			.profissionaisId(3L)
			.descricaoEquipamentos("")
			.qtEquipamento(2)
			.dataCadastro(date)
			.idCadastro(1L)
			.build();
		
		PerfilEquipeTable table = PerfilEquipeTable.builder().build();
		
		Mockito.when(perfilEquipeRepository.save(Mockito.any(PerfilEquipeTable.class))).thenReturn(table);

		PerfilEquipeEntity result = dataprovider.salvarPerfil(perfilEquipe);

		Assert.assertThat(result, Matchers.any(PerfilEquipeEntity.class));
	}
	
	@Test(expected = DataBaseException.class)
	public void cadastrarPerfilEquipe_exception() {
		
		PerfilEquipeEntity perfilEquipe = PerfilEquipeEntity.builder()
				.id(1L)
				.nome("")
				.sigla("")
				.veiculoId(2L)
				.profissionaisId(3L)
				.descricaoEquipamentos("")
				.qtEquipamento(2)
				.dataCadastro(date)
				.idCadastro(1L)
				.build();

		Mockito.doThrow(new DataBaseException("Falha na persistência")).when(perfilEquipeRepository).save(Mockito.any(PerfilEquipeTable.class));

		dataprovider.salvarPerfil(perfilEquipe);
	}

}
