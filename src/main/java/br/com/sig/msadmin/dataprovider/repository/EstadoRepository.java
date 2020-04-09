package br.com.sig.msadmin.dataprovider.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sig.msadmin.dataprovider.entity.EstadoTable;

public interface EstadoRepository extends JpaRepository<EstadoTable, Long>{

}
