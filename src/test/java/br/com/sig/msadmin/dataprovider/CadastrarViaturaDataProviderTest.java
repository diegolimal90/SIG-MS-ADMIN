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

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.dataprovider.entity.ViaturaTable;
import br.com.sig.msadmin.dataprovider.repository.ViaturaRepository;
import br.com.sig.msadmin.exception.DataBaseException;

@RunWith(MockitoJUnitRunner.class)
public class CadastrarViaturaDataProviderTest {
    @InjectMocks
    private ViaturaDataProvider dataProvider;

    @Mock
    private ViaturaRepository viaturaRepository;

    //TODO Incluir outra solução alterando as datas
    private Date date = new Date();

    private ViaturaEntity viatura = ViaturaEntity.builder()
                                                .id(1L)
                                                .ano(2010)
                                                .placa("API-7777")
                                                .fabricante("Ford")
                                                .quilometragem_atual(2000)
                                                .quilometragem_inicial(1000)
                                                .dataCadastro(date)
                                                .dataAlteracao(date)
                                                .dataDesativacao(date)
                                                .idCadastro(2L)
                                                .idAlteracao(3L)
                                                .idDesativacao(2L)
                                                .build();

    @Test
    public void cadastrarViatura_success(){
        

        ViaturaTable table = ViaturaTable.builder().build();

        Mockito.when(viaturaRepository.save(Mockito.any(ViaturaTable.class))).thenReturn(table);

        ViaturaEntity result = dataProvider.salvarViatura(viatura);

        Assert.assertThat(result, Matchers.any(ViaturaEntity.class));
    }

    @Test(expected = DataBaseException.class)
    public void cadastrarViatura_exception(){

        Mockito.doThrow(new DataBaseException("Falha na persistência")).when(viaturaRepository).save(Mockito.any(ViaturaTable.class));

        dataProvider.salvarViatura(viatura);
    }
}