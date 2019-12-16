package br.com.sig.msadmin.dataprovider;

import java.util.Date;

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
public class CadastrarUnidadeDataProviderTest {

	@InjectMocks
	private UnidadeDataProvider dataprovider;
	@Mock
	private UnidadeRepository repository;
   
	private Date date = new Date();
	   
	@Test
	public void cadastrarUnidade_success(){
		UnidadeEntity unidade = UnidadeEntity.builder()
			.id(1L).tipo("base").nome("Teste unidade").cep("11700190").tipoLogradouro("Rua").logradouro("Espírito Santo")
			.numero(391).complemento("apto 122").regiao("Baixada Santista").bairro("Canto do Forte").cidade("Praia Grande").estado("SP")
			.referencia("Proximo a Fatec").dataCadastro(date).idCadastro(22L).build();
		
		UnidadeTable table = UnidadeTable.builder().build();

		Mockito.when(repository.save(Mockito.any(UnidadeTable.class))).thenReturn(table);

		UnidadeEntity result = dataprovider.salvarUnidade(unidade);

		Assert.assertThat(result, Matchers.any(UnidadeEntity.class));
	}

	@Test(expected = DataBaseException.class)
	public void cadastrarUnidade_exception() {
		UnidadeEntity unidade = UnidadeEntity.builder()
			.id(1L).tipo("base").nome("Teste unidade").cep("11700190").tipoLogradouro("Rua").logradouro("Espírito Santo")
			.numero(391).complemento("apto 122").regiao("Baixada Santista").bairro("Canto do Forte").cidade("Praia Grande").estado("SP")
			.referencia("Proximo a Fatec").dataCadastro(date).idCadastro(22L).build();

		Mockito.doThrow(new DataBaseException("Falha na persistência")).when(repository).save(Mockito.any(UnidadeTable.class));

		dataprovider.salvarUnidade(unidade);
	}
}
