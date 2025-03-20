package com.example.adp;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ModuleRepository extends CrudRepository<Module, Long> {
    List<Module> findByPassmark(Long passmark);
}
