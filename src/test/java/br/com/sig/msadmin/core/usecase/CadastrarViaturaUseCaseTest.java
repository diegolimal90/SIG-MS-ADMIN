package br.com.sig.msadmin.core.usecase;

import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.core.usecase.CadastrarViaturaUseCase;
import br.com.sig.msadmin.dataprovider.ViaturaDataProvider;
import br.com.sig.msadmin.exception.DataBaseException;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CadastrarViaturaUseCaseTest {

    @InjectMocks
    private CadastrarViaturaUseCase useCase;

    @Mock
    private ViaturaDataProvider dataProvider;
    
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
        viatura.setDataCadastro(timestamp);

        Mockito.when(dataProvider.salvarViatura(Mockito.any(ViaturaEntity.class))).thenReturn(cloneViatura);

        ViaturaEntity response = useCase.cadastrarViatura(viatura);        
        Assert.assertEquals(viatura, response);

    }
    
    @Test(expected = DataBaseException.class)
    public void CadastrarViaturaUseCase_exception(){
        ViaturaEntity vazio = ViaturaEntity.builder().build();

        Mockito.doThrow(new DataBaseException("Falha na persistencia do cadastro da viatura.")).when(dataProvider).salvarViatura(Mockito.any(ViaturaEntity.class));

        ViaturaEntity erro = useCase.cadastrarViatura(vazio);
    }    
}