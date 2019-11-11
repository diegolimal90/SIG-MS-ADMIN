package br.com.sig.msadmin.dataprovider;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
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
	private CadastrarUnidadeDataProvider dataprovider;
	@Mock
	private UnidadeRepository repository;

	@Test
	public void cadastrarUnidade_success(){
		UnidadeEntity unidade = UnidadeEntity.builder()
				.id(1)
				.tipo(1)
				.nome("teste")
				.cep("")
				.tipoLogradouro("")
				.logradouro("")
				.numero(0)
				.complemento("")
				.regiao("")
				.bairro("")
				.cidade("")
				.estado("")
				.build();
		
		UnidadeTable table = UnidadeTable.builder().build();

		Mockito.when(repository.save(Mockito.any(UnidadeTable.class))).thenReturn(table);

		UnidadeEntity result = dataprovider.salvarUnidade(unidade);

		Assert.assertThat(result, Matchers.any(UnidadeEntity.class));
	}

	@Test(expected = RuntimeException.class)
	public void cadastrarUnidade_exception(){
		UnidadeEntity unidade = UnidadeEntity.builder()
				.id(15)
				.tipo(12)
				.nome("teste")
				.cep("")
				.tipoLogradouro("")
				.logradouro("")
				.numero(90)
				.complemento("")
				.regiao("")
				.bairro("")
				.cidade("")
				.estado("")
				.build();

		Mockito.when(repository.save(Mockito.any(UnidadeTable.class))).thenThrow(new RuntimeException());

		assertThrows(RuntimeException.class, ()-> dataprovider.salvarUnidade(unidade));
	}
}
