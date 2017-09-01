package com.lab.persistence.service;

import com.lab.persistence.model.ItemsModel;
import java.util.List;


public interface ItemsService
{

  //Para que salgan todos los elementos
  public List<ItemsModel> allItemsTestService(ItemsModel obj) throws Exception;
    
  //Para hacer la búsqueda
  public List<ItemsModel> getItemsTestService(ItemsModel obj) throws Exception;

}
