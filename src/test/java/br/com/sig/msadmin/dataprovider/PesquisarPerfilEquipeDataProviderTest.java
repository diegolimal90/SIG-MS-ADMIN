package br.com.sig.msadmin.dataprovider;

import java.util.ArrayList;
import java.util.List;

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
public class PesquisarPerfilEquipeDataProviderTest {
	
	@InjectMocks
	private PerfilEquipeDataProvider dataProvider;
	@Mock
	private PerfilEquipeRepository perfilEquipeRepository;

	@Test
	public void pesquisarPerfilEquipes_success(){
		List<PerfilEquipeTable> listPerfilEquipe = new ArrayList<>();

		Mockito.when(perfilEquipeRepository.findAll()).thenReturn(listPerfilEquipe);

		List<PerfilEquipeEntity> result = dataProvider.pesquisarPerfil();

		Assert.assertThat(result, Matchers.any(List.class));
	}

	//@Test(expected = RuntimeException.class)
	public void pesquisarPerfilEquipes_exception() {

		Mockito.when(perfilEquipeRepository.findAll()).thenThrow(new RuntimeException());

		Assertions.assertThrows(RuntimeException.class, ()-> dataProvider.pesquisarPerfil());
	}
}
