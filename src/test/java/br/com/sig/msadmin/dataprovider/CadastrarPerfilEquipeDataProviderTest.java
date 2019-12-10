package br.com.sig.msadmin.dataprovider;

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

@RunWith(MockitoJUnitRunner.class)
public class CadastrarPerfilEquipeDataProviderTest {
	
	@InjectMocks
	private PerfilEquipeDataProvider dataprovider;
	
	@Mock
	private PerfilEquipeRepository perfilEquipeRepository;
	
	@Test
	public void cadastrarPerfilEquipe_success() {
		PerfilEquipeEntity perfilEquipe = PerfilEquipeEntity.builder().build();
		
		PerfilEquipeTable table = PerfilEquipeTable.builder().build();

		Mockito.when(perfilEquipeRepository.save(Mockito.any(PerfilEquipeTable.class))).thenReturn(table);

		PerfilEquipeEntity result = dataprovider.salvarPerfil(perfilEquipe);

		Assert.assertThat(result, Matchers.any(PerfilEquipeEntity.class));
	}
	
	//@Test(expected = RuntimeException.class)
	public void cadastrarPerfilEquipe_exception() {
		PerfilEquipeEntity perfilEquipe = PerfilEquipeEntity.builder().build();

		Mockito.when(perfilEquipeRepository.save(Mockito.any(PerfilEquipeTable.class))).thenThrow(new RuntimeException());

		Assertions.assertThrows(RuntimeException.class, ()-> dataprovider.salvarPerfil(perfilEquipe));
	}

}
