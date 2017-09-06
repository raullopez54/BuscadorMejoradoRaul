package com.lab.persistence.service;

import com.lab.persistence.model.ItemsModel;
import com.lab.persistence.model.PesoModel;
import java.util.List;


public interface ItemsService
{

  //Para que salgan todos los elementos
  public List<ItemsModel> allItemsTestService(ItemsModel obj) throws Exception;
    
  //Para hacer la búsqueda con cadena
  public List<ItemsModel> cadenaItemsTestService(ItemsModel obj) throws Exception;

  //Para hacer la búsqueda con numero
  public List<ItemsModel> numeroItemsTestService(PesoModel obj) throws Exception;
}
