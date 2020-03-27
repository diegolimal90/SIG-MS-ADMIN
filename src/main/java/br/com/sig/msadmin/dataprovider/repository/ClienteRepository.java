package br.com.sig.msadmin.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sig.msadmin.dataprovider.entity.ClienteTable;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteTable, Long>{
    
}