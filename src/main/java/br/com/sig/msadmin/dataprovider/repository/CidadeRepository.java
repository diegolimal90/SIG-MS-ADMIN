package br.com.sig.msadmin.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sig.msadmin.dataprovider.entity.CidadeTable;

public interface CidadeRepository extends JpaRepository<CidadeTable, Long>{

}
