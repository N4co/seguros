package br.com.seguros.seguros.repository;

import br.com.seguros.seguros.entity.Apolice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoliceRepository extends CrudRepository<Apolice, Long> {
}
