package br.com.sig.msadmin.dataprovider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
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
public class PesquisarPerfilEquipeDataProviderTest {
	
	@InjectMocks
	private PerfilEquipeDataProvider dataProvider;
	@Mock
	private PerfilEquipeRepository perfilEquipeRepository;
	
	private Date date = new Date();

	@Test
	public void pesquisarPerfilEquipes_success(){
		
		PerfilEquipeTable perfilEquipe = PerfilEquipeTable.builder()
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
		
		List<PerfilEquipeTable> listPerfilEquipe = new ArrayList<>();
		listPerfilEquipe.add(perfilEquipe);

		Mockito.when(perfilEquipeRepository.findAll()).thenReturn(listPerfilEquipe);

		List<PerfilEquipeEntity> result = dataProvider.pesquisarPerfilEquipe();

		Assert.assertThat(result, Matchers.any(List.class));
	}

	@Test(expected = DataBaseException.class)
	public void pesquisarPerfilEquipes_exception() {
		
		PerfilEquipeTable perfilEquipe = PerfilEquipeTable.builder()
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
		
		List<PerfilEquipeTable> listPerfilEquipe = new ArrayList<>();
		listPerfilEquipe.add(perfilEquipe);
		
		Mockito.doThrow(new DataBaseException("Falha na persistência")).when(perfilEquipeRepository).findAll();
		
		dataProvider.pesquisarPerfilEquipe();
	}
}
