package com.lab.persistence.service;

import com.lab.persistence.mapper.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lab.persistence.model.ItemsModel;
import com.lab.persistence.model.PesoModel;
import java.util.List;


@Service
public class ItemsServiceImpl implements ItemsService
{

  @Autowired
  ItemsMapper iMapper;

  //Para que salgan todos los elementos
  @Override
  public List<ItemsModel> allItemsTestService(ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = iMapper.allItemsTestMapper(obj);

    return x;
  }

  //Para que salga la búsqueda con cadenaq
  @Override
  public List<ItemsModel> cadenaItemsTestService(ItemsModel obj) throws Exception
  {
    System.out.println("LLEGA AQUI O QUE - CADENA SERVICE");
    List<ItemsModel> x = iMapper.cadenaItemsTestMapper(obj);

    return x;
  }
  
   //Para que salga la búsqueda con numero
  @Override
  public List<ItemsModel> numeroItemsTestService(PesoModel obj) throws Exception
  {
    System.out.println("LLEGA AQUI O QUE - NUMERO SERVICE");
    List<ItemsModel> x = iMapper.numeroItemsTestMapper(obj);

    return x;
  }

}
