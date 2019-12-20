package br.com.sig.msadmin.entrypoint;

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
import br.com.sig.msadmin.entrypoint.entity.UnidadeHttpModel;

@RunWith(MockitoJUnitRunner.class)
public class UnidadeEntrypointTest {

	@InjectMocks
	private UnidadeEntrypoint entrypoint;
	
	@Mock
	private CadastrarUnidadeUseCase useCase;
	
	@Test
	public void CadastrarUnidadeEntrypoint_success() {
		UnidadeEntity unidade = UnidadeEntity.builder()
			.id(1L).tipo("base").nome("Teste unidade").cep("11700190").tipoLogradouro("Rua").logradouro("Espírito Santo")
			.numero(391).complemento("apto 122").regiao("Baixada Santista").bairro("Canto do Forte").cidade("Praia Grande").estado("SP")
			.referencia("Proximo a Fatec").dataCadastro(null).idCadastro(22L).status(1).build();
		
		UnidadeHttpModel httpmodel = UnidadeHttpModel.builder()
				.id(1L).tipo("base").nome("Teste unidade").cep("11700190").tipoLogradouro("Rua").logradouro("Espírito Santo")
				.numero(391).complemento("apto 122").regiao("Baixada Santista").bairro("Canto do Forte").cidade("Praia Grande").estado("SP")
				.referencia("Proximo a Fatec").dataCadastro(null).idCadastro(22L).build();
		
		Mockito.when(useCase.cadastrarUnidade(Mockito.any(UnidadeEntity.class))).thenReturn(unidade);
		
		ResponseEntity<UnidadeHttpModel> response=  entrypoint.cadastrarUnidade(httpmodel);
		
		Assert.assertEquals(HttpStatus.OK, response.getStatusCode());	
		
	}	
}