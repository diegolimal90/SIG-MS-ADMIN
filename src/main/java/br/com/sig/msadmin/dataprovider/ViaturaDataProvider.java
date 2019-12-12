package br.com.sig.msadmin.dataprovider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.sig.msadmin.core.entity.ViaturaEntity;
import br.com.sig.msadmin.core.gateway.ViaturaGateway;
import br.com.sig.msadmin.dataprovider.entity.ViaturaTable;
import br.com.sig.msadmin.dataprovider.mapper.ViaturaMapper;
import br.com.sig.msadmin.dataprovider.repository.ViaturaRepository;
import br.com.sig.msadmin.exception.DataBaseException;

@Component
public class ViaturaDataProvider implements ViaturaGateway{
    
    @Autowired
    private ViaturaRepository viaturaRepository;

    @Override
    public ViaturaEntity salvarViatura(ViaturaEntity entity){
        try{
            ViaturaTable table = ViaturaMapper.from(entity);
            
            table = viaturaRepository.save(table);
            entity = ViaturaMapper.to(table);

            return entity;
        }catch(Exception e){
            throw new DataBaseException("Falha na persistencia do cadastro de viatura");
        }
    }

    @Override
    public List<ViaturaEntity> pesquisarViatura(){
        List<ViaturaEntity> listEntity = new ArrayList<>();
        List<ViaturaTable> listTable = new ArrayList<>();

        try{
            listTable = viaturaRepository.findAll();

            for(ViaturaTable table : listTable){
                ViaturaEntity entity = ViaturaMapper.to(table);
                listEntity.add(entity);
            }

            return listEntity;
        }catch(Exception e){
            throw new DataBaseException("Falha na persistencia do cadastro de viatura");
        }
    }
}