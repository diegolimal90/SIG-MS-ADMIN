package br.com.sig.msadmin.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sig.msadmin.dataprovider.entity.UnidadeTable;

@Repository
public interface UnidadeRepository extends JpaRepository<UnidadeTable, Long> {

}