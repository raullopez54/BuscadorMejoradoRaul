package com.lab.persistence.service;

import com.lab.persistence.mapper.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lab.persistence.model.ItemsModel;
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

  //Para que salga la búsqueda
  @Override
  public List<ItemsModel> getItemsTestService(ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = iMapper.getItemsTestMapper(obj);

    return x;
  }

}
