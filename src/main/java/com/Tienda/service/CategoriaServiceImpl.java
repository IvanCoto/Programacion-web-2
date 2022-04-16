package com.Tienda.service;

import com.Tienda.dao.CategoriaDao;
import com.Tienda.dao.CreditoDao;
import com.Tienda.domain.Categoria;
import com.Tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private CategoriaDao clienteDao;
    
    @Autowired
    private CreditoDao creditoDao;

    @Override
    @Transactional (readOnly = true) // Para manejar transacciones de lectura
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>) clienteDao.findAll();
        if (activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional // Para manejar transacciones de escritura y lectura
    public void save(Categoria cliente) {           
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Categoria cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional (readOnly = true) 
    public Categoria getCategoria(Categoria cliente) {
        return clienteDao.findById(cliente.getIdCategoria()).orElse(null);
    }
    
}
