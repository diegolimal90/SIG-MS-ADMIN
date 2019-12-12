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

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.dataprovider.entity.UnidadeTable;
import br.com.sig.msadmin.dataprovider.repository.UnidadeRepository;
import br.com.sig.msadmin.exception.DataBaseException;

@RunWith(MockitoJUnitRunner.class)
public class PesquisarUnidadeDataProviderTest {

	@InjectMocks
	private UnidadeDataProvider dataprovider;
	@Mock
	private UnidadeRepository repository;

	@Test
	public void pesquisarUnidades_success(){
		List<UnidadeTable> listUnidade = new ArrayList<>();

		Mockito.when(repository.findAll()).thenReturn(listUnidade);

		List<UnidadeEntity> result = dataprovider.pesquisarUnidades();

		Assert.assertThat(result, Matchers.any(List.class));
	}

	@Test(expected = DataBaseException.class)
	public void pesquisarUnidades_exception() {

		Mockito.when(repository.findAll()).thenThrow(new DataBaseException("Falha na persistência"));

		Assertions.assertThrows(DataBaseException.class, ()-> dataprovider.pesquisarUnidades());
	}
}
