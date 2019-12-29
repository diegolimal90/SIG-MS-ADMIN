package br.com.sig.msadmin.entrypoint;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.sig.msadmin.core.entity.UnidadeEntity;
import br.com.sig.msadmin.core.usecase.CadastrarUnidadeUseCase;
import br.com.sig.msadmin.core.usecase.PesquisarUnidadeUseCase;
import br.com.sig.msadmin.entrypoint.entity.UnidadeHttpModel;

@RunWith(MockitoJUnitRunner.class)
public class UnidadeEntrypointTest {

	@InjectMocks
	private UnidadeEntrypoint entrypoint;
	
	@Mock
	private CadastrarUnidadeUseCase cadastrarUseCase;
	
	@Mock
	private PesquisarUnidadeUseCase pesquisarUseCase;
	
	@Test
	public void CadastrarUnidadeEntrypoint_success() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		UnidadeEntity unidade = UnidadeEntity.builder()
			.id(1L).tipo("base").nome("Teste unidade").cep("11700190").tipoLogradouro("Rua").logradouro("Espírito Santo")
			.numero(391).complemento("apto 122").regiao("Baixada Santista").bairro("Canto do Forte").cidade("Praia Grande").estado("SP")
			.referencia("Proximo a Fatec").dataCadastro(timestamp).idCadastro(22L).status(1).build();
		
		UnidadeHttpModel httpmodel = UnidadeHttpModel.builder()
			.id(1L).tipo("base").nome("Teste unidade").cep("11700190").tipoLogradouro("Rua").logradouro("Espírito Santo")
			.numero(391).complemento("apto 122").regiao("Baixada Santista").bairro("Canto do Forte").cidade("Praia Grande").estado("SP")
			.referencia("Proximo a Fatec").idCadastro(22L).build();
		
		Mockito.when(cadastrarUseCase.cadastrarUnidade(Mockito.any(UnidadeEntity.class))).thenReturn(unidade);
		
		ResponseEntity<UnidadeHttpModel> response = entrypoint.cadastrarUnidade(httpmodel);
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
	}	
	
	@Test
	public void PesquisarUnidadeEntrypoint_success() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		UnidadeEntity unidade = UnidadeEntity.builder()
			.id(1L).tipo("base").nome("Teste unidade").cep("11700190").tipoLogradouro("Rua").logradouro("Espírito Santo")
			.numero(391).complemento("apto 122").regiao("Baixada Santista").bairro("Canto do Forte").cidade("Praia Grande").estado("SP")
			.referencia("Proximo a Fatec").dataCadastro(timestamp).idCadastro(22L).status(1).build();
		
		List<UnidadeEntity> listEntity = new ArrayList<>();
		listEntity.add(unidade);
		
		Mockito.when(pesquisarUseCase.pesquisarUnidades()).thenReturn(listEntity);
		
		ResponseEntity<List<UnidadeHttpModel>> listResponse = entrypoint.pesquisarUnidades();
		
		Assert.assertEquals(HttpStatus.OK, listResponse.getStatusCode());
	}
	
}