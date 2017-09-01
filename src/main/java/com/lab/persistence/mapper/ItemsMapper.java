package com.lab.persistence.mapper;

import com.lab.persistence.model.ItemsModel;
import java.util.List;

//Para que salgan todos los elementos

public interface ItemsMapper
{
  public List<ItemsModel> allItemsTestMapper(ItemsModel obj) throws Exception;

//Para hacer la busqueda de elementos

  public List<ItemsModel> getItemsTestMapper(ItemsModel obj) throws Exception;
}