package br.com.sig.msadmin.core.usecase;

import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.core.usecase.CadastrarViaturaUseCase;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CadastrarViaturaUseCaseTest {

    @Mock
    private CadastrarViaturaUseCase useCase;
       

    private ViaturaEntity viatura = ViaturaEntity.builder()
                                                 .ano(2010)
                                                 .placa("API-7777")
                                                 .fabricante("Ford")
                                                 .quilometragem_atual(2000)
                                                 .quilometragem_inicial(1000)
                                                 .build();

    private ViaturaEntity cloneViatura = ViaturaEntity.builder()
                                                      .ano(2010)
                                                      .placa("API-7777")
                                                      .fabricante("Ford")
                                                      .quilometragem_atual(2000)
                                                      .quilometragem_inicial(1000)
                                                      .build();
    
    @Test
    public void CadastrarViaturaUseCase_success(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        cloneViatura.setDataCadastro(timestamp);

        Mockito.when(useCase.cadastrarViatura(Mockito.any(ViaturaEntity.class))).thenReturn(cloneViatura);

        Assert.assertNotEquals(viatura, cloneViatura);

    }

    @Test(expected = NullPointerException.class)
    public void CadastrarViaturaUseCase_exception(){
        
        ViaturaEntity vazio = ViaturaEntity.builder().build();

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        cloneViatura.setDataCadastro(timestamp);

        Mockito.doThrow(new NullPointerException("Entidade vazia")).when(useCase).cadastrarViatura(Mockito.any(ViaturaEntity.class));

        ViaturaEntity teste = useCase.cadastrarViatura(vazio);
    }
}