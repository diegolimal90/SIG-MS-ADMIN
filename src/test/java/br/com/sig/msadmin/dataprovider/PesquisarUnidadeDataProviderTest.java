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

	private Date date = new Date();
	
	@Test
	public void pesquisarUnidades_success(){
		UnidadeTable unidade = UnidadeTable.builder()
			.id(1L).tipo("base").nome("Teste unidade").cep("11700190").tipoLogradouro("Rua").logradouro("Espírito Santo")
			.numero(391).complemento("apto 122").regiao("Baixada Santista").bairro("Canto do Forte").cidade("Praia Grande").estado("SP")
			.referencia("Proximo a Fatec").dataCadastro(date).idCadastro(22L).build();
		
		List<UnidadeTable> listUnidade = new ArrayList<>();
		listUnidade.add(unidade);
		
		Mockito.when(repository.findAll()).thenReturn(listUnidade);

		List<UnidadeEntity> result = dataprovider.pesquisarUnidades();

		Assert.assertThat(result, Matchers.any(List.class));
	}

	@Test(expected = DataBaseException.class)
	public void pesquisarUnidades_exception() {
		UnidadeTable unidade = UnidadeTable.builder()
			.id(1L).tipo("base").nome("Teste unidade").cep("11700190").tipoLogradouro("Rua").logradouro("Espírito Santo")
			.numero(391).complemento("apto 122").regiao("Baixada Santista").bairro("Canto do Forte").cidade("Praia Grande").estado("SP")
			.referencia("Proximo a Fatec").dataCadastro(date).idCadastro(22L).build();
		
		List<UnidadeTable> listUnidade = new ArrayList<>();
		listUnidade.add(unidade);

		Mockito.doThrow(new DataBaseException("Falha na persistência")).when(repository).findAll();

		dataprovider.pesquisarUnidades();
	}
}