package br.com.sig.msadmin.dataprovider;

import javax.naming.ServiceUnavailableException;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.dataprovider.entity.ProfissionalTable;
import br.com.sig.msadmin.dataprovider.repository.ProfissionalRepository;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarProfissionalDataProviderTest {

	@InjectMocks
	private CadastrarProfissionalDataProvider dataprovider;
	@Mock
	private ProfissionalRepository repository;

	@Test
	public void cadastrarProfissional_success() throws ServiceUnavailableException {
		ProfissionalEntity profissional = ProfissionalEntity.builder().build();
		ProfissionalTable table = ProfissionalTable.builder().build();

		Mockito.when(repository.save(Mockito.any(ProfissionalTable.class))).thenReturn(table);

		ProfissionalEntity result = dataprovider.cadastrarProfissional(profissional);

		Assert.assertThat(result, Matchers.any(ProfissionalEntity.class));
	}

	@Test(expected = ServiceUnavailableException.class)
	public void cadastrarProfissional_exception() throws ServiceUnavailableException {
		ProfissionalEntity profissional = ProfissionalEntity.builder().id(1L).build();

		Mockito.when(repository.save(Mockito.any(ProfissionalTable.class))).thenThrow(new Exception("teste"));

		dataprovider.cadastrarProfissional(profissional);
	}
}
