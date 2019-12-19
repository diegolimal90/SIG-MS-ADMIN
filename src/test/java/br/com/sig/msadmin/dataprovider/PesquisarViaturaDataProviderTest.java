package br.com.sig.msadmin.dataprovider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
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
public class PesquisarViaturaDataProviderTest {
    @InjectMocks
    private ViaturaDataProvider dataProvider;
    
    @Mock
    private ViaturaRepository repository;

    private Date date = new Date();

    @Test
    public void pesquisarViatura_success(){
        ViaturaTable viatura = ViaturaTable.builder()
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

        List<ViaturaTable> listViatura = new ArrayList<>();
        listViatura.add(viatura);

        Mockito.when(repository.findAll()).thenReturn(listViatura);

        List<ViaturaEntity> result = dataProvider.pesquisarViatura();

        Assert.assertThat(result, Matchers.any(List.class));
    }

    @Test(expected = DataBaseException.class)
    public void pesquisarViatura_exception(){
        ViaturaTable viatura = ViaturaTable.builder()
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

        List<ViaturaTable> listViatura = new ArrayList<>();
        listViatura.add(viatura);


        Mockito.doThrow(new DataBaseException("Falha na persistência")).when(repository).findAll();

        dataProvider.pesquisarViatura();
    }
}