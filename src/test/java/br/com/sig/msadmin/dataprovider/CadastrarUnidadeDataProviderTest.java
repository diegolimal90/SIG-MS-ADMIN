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

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.dataprovider.entity.UnidadeTable;
import br.com.sig.msadmin.dataprovider.repository.UnidadeRepository;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarUnidadeDataProviderTest {

	@InjectMocks
	private UnidadeDataProvider dataprovider;
	@Mock
	private UnidadeRepository repository;

	@Test
	public void cadastrarUnidade_success(){
		UnidadeEntity unidade = UnidadeEntity.builder().build();
		
		UnidadeTable table = UnidadeTable.builder().build();

		Mockito.when(repository.save(Mockito.any(UnidadeTable.class))).thenReturn(table);

		UnidadeEntity result = dataprovider.salvarUnidade(unidade);

		Assert.assertThat(result, Matchers.any(UnidadeEntity.class));
	}

	@Test(expected = RuntimeException.class)
	public void cadastrarUnidade_exception() {
		UnidadeEntity unidade = UnidadeEntity.builder().build();

		Mockito.when(repository.save(Mockito.any(UnidadeTable.class))).thenThrow(new RuntimeException());

		Assertions.assertThrows(RuntimeException.class, ()-> dataprovider.salvarUnidade(unidade));
	}
}
