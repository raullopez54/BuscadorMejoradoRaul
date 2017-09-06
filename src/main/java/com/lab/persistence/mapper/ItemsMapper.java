package com.lab.persistence.mapper;

import com.lab.persistence.model.ItemsModel;
import com.lab.persistence.model.PesoModel;
import java.util.List;

//Para que salgan todos los elementos

public interface ItemsMapper
{
  public List<ItemsModel> allItemsTestMapper(ItemsModel obj) throws Exception;

//Para hacer la busqueda de elementos por cadena

  public List<ItemsModel> cadenaItemsTestMapper(ItemsModel obj) throws Exception;
  
  //Para hacer la busqueda de elementos por numero

  public List<ItemsModel> numeroItemsTestMapper(PesoModel obj) throws Exception;
}