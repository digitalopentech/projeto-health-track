package br.com.fiap.helth.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    
    List<T> getAll();

}