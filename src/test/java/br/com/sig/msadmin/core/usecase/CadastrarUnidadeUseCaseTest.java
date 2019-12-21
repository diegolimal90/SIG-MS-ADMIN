package br.com.sig.msadmin.core.usecase;

import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sig.msadmin.core.entity.UnidadeEntity;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CadastrarUnidadeUseCaseTest {

    @Mock
    private CadastrarUnidadeUseCase useCase;
       

    UnidadeEntity unidade = UnidadeEntity.builder()
			.id(1L).tipo("base").nome("Teste unidade").cep("11700190").tipoLogradouro("Rua").logradouro("Espírito Santo")
			.numero(391).complemento("apto 122").regiao("Baixada Santista").bairro("Canto do Forte").cidade("Praia Grande").estado("SP")
			.referencia("Proximo a Fatec").idCadastro(22L).build();

    UnidadeEntity unidadeModelo = UnidadeEntity.builder()
			.id(1L).tipo("base").nome("Teste unidade").cep("11700190").tipoLogradouro("Rua").logradouro("Espírito Santo")
			.numero(391).complemento("apto 122").regiao("Baixada Santista").bairro("Canto do Forte").cidade("Praia Grande").estado("SP")
			.referencia("Proximo a Fatec").idCadastro(22L).build();
    
    @Test
    public void CadastrarUnidadeUseCase_success(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        unidadeModelo.setDataCadastro(timestamp);
        unidadeModelo.setStatus(1);

        Mockito.when(useCase.cadastrarUnidade(Mockito.any(UnidadeEntity.class))).thenReturn(unidadeModelo);
        
        UnidadeEntity response = useCase.cadastrarUnidade(unidade);

        Assert.assertNotEquals(unidade, response);

    }

    @Test(expected = NullPointerException.class)
    public void CadastrarUnidadeUseCase_exception(){
        UnidadeEntity vazio = UnidadeEntity.builder().build();

        Mockito.doThrow(new NullPointerException("Entidade vazia")).when(useCase).cadastrarUnidade(Mockito.any(UnidadeEntity.class));

        UnidadeEntity teste = useCase.cadastrarUnidade(vazio);
    }
}