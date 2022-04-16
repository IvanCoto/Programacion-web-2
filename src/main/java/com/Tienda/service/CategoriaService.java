package com.Tienda.service;

import com.Tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    public List<Categoria> getCategorias(boolean activos);
    
    public void save(Categoria cliente);
    
    public void delete(Categoria cliente);
    
    public Categoria getCategoria(Categoria cliente);
    
}
