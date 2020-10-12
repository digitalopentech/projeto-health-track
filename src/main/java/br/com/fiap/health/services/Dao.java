package br.com.fiap.health.services;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    
    List<T> getAll();

}