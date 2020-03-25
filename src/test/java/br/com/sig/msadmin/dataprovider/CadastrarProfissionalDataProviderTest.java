package br.com.sig.msadmin.dataprovider;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sig.msadmin.core.entity.ProfissionalEntity;
import br.com.sig.msadmin.dataprovider.entity.BairroTable;
import br.com.sig.msadmin.dataprovider.entity.CidadeTable;
import br.com.sig.msadmin.dataprovider.entity.EnderecoTable;
import br.com.sig.msadmin.dataprovider.entity.EstadoTable;
import br.com.sig.msadmin.dataprovider.entity.ProfissionalTable;
import br.com.sig.msadmin.dataprovider.entity.TipoLogradouroTable;
import br.com.sig.msadmin.dataprovider.repository.ProfissionalRepository;
import br.com.sig.msadmin.exception.DataBaseException;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarProfissionalDataProviderTest {

	@InjectMocks
	private ProfissionalDataProvider profissionalDataProvider;
	
	@Mock
	private ProfissionalRepository profissionalRepository;
	
	@Test
	public void cadastrarProfissional_success() {
		
		ProfissionalEntity entity = ProfissionalEntity.builder()
				.id(1L)
				.nmProfissional("Fulano de Teste")
				.build();
		
		ProfissionalTable tableSaved = ProfissionalTable.builder()
				.id(1L)
				.nmProfissional("Fulano de Teste")
				.endereco(EnderecoTable.builder()
						.bairro(BairroTable.builder()
								.cidade(CidadeTable.builder()
										.estado(EstadoTable.builder()
												.build())
										.build())
								.build())
						.tpLogradouro(TipoLogradouroTable.builder()
								.build())
						.build())
				.build();
		
		Mockito.when(profissionalRepository.save(Mockito.any(ProfissionalTable.class))).thenReturn(tableSaved);
		
		ProfissionalEntity response = profissionalDataProvider.cadastrarProfissional(entity);
		
		Assert.assertThat(response.getId(), Matchers.equalTo(1L));
		
	}
	
	@Test(expected=DataBaseException.class)
	public void cadastrarProfissional_exception() {
		
		ProfissionalEntity entity = ProfissionalEntity.builder().build();
		
		Mockito.when(profissionalRepository.save(Mockito.any(ProfissionalTable.class))).thenThrow(new DataBaseException("teste"));
		
		profissionalDataProvider.cadastrarProfissional(entity);
		
	}
}
