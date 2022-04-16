package com.Tienda.service;

import com.Tienda.dao.ArticuloDao;
import com.Tienda.dao.CreditoDao;
import com.Tienda.domain.Articulo;
import com.Tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {
    
    @Autowired
    private ArticuloDao clienteDao;
    
    @Autowired
    private CreditoDao creditoDao;

    @Override
    @Transactional (readOnly = true) // Para manejar transacciones de lectura
    public List<Articulo> getArticulos(boolean activos) {
        var lista = (List<Articulo>) clienteDao.findAll();
        if (activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional // Para manejar transacciones de escritura y lectura
    public void save(Articulo cliente) {           
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Articulo cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional (readOnly = true) 
    public Articulo getArticulo(Articulo cliente) {
        return clienteDao.findById(cliente.getIdarticulo()).orElse(null);
    }
    
}
