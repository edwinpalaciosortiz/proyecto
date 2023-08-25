package com.clase.proyecto.domain.repository;

import com.clase.proyecto.api.dto.ObraDto;
import com.clase.proyecto.domain.models.Obra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ObraRepository  extends CrudRepository<Obra, String>{

}