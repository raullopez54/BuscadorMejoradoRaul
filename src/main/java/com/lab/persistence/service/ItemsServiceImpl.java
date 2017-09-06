package com.lab.persistence.service;

import com.lab.persistence.mapper.ItemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lab.persistence.model.ItemsModel;
import com.lab.persistence.model.PesoModel;
import java.util.List;
import java.util.regex.Pattern;

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
    
    List<ItemsModel> list = this.replaceSearch(obj, x);

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

///////////////////////////////METODO PRIVADO
 
private List<ItemsModel> replaceSearch(ItemsModel obj, List<ItemsModel> x)
 {

    for (ItemsModel item : x)
    {
      item.setNombre(this.pattern(obj.getNombre()).matcher(item.getNombre()).replaceAll(this.patternReplace(obj.getNombre())));
      item.setDescripcion(this.pattern(obj.getDescripcion()).matcher(item.getDescripcion()).replaceAll(this.patternReplace(obj.getDescripcion())));
    }

    return x;
 }

/**
   * METODO PARA GENERAR UN PATRON.
   *
   * @param str Cadena a insertar en el patron de busqueda.
   * @return Patron generado.
   */
  private Pattern pattern(String str)
  {
    return Pattern.compile("(?i)" + str);
  }

  /**
   * METODO PARA REALIZAR UN REMPLAZO DE UNA CADENA POR UN TAG HTML.
   *
   * @param str Cadena a insertar en el tag.
   * @return tag generado en html.
   */
  private String patternReplace(String str)
  {
    return "<strong class=\"found\">" + str + "</strong>";
  }

}