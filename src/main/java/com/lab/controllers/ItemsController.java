package com.lab.controllers;


import com.lab.persistence.model.ItemsModel;
import com.lab.persistence.model.PesoModel;
import com.lab.persistence.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;


@Controller
public class ItemsController
{

  @Autowired
  ItemsService iService;

    //PARA OBTENER TODOS LOS ELEMENTOS
  
  @ResponseBody
  @RequestMapping(value = "/allItems",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
  
  public List<ItemsModel> allItems(@RequestBody ItemsModel obj) throws Exception
  {
    List<ItemsModel> x = iService.allItemsTestService(obj);

    return x;
  }
  
  //PARA OBTENER LOS RESULTADOS DE LA BÚSQUEDA SI ES UNA CADENA
  
  @ResponseBody
  @RequestMapping(value = "/cadena",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
  
  public List<ItemsModel> cadena(@RequestBody ItemsModel obj) throws Exception
  {
    System.out.println("LLEGA AQUI O QUE - CADENA");
    List<ItemsModel> x = iService.cadenaItemsTestService(obj);

    return x;
  }
  
  //PARA OBTENER LOS RESULTADOS DE LA BÚSQUEDA SI ES UN NUMERO
  
  @ResponseBody
  @RequestMapping(value = "/numero",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
  
  public List<ItemsModel> numero(@RequestBody PesoModel obj) throws Exception
  {
    System.out.println("LLEGA AQUI O QUE - NUMERO");
    List<ItemsModel> x = iService.numeroItemsTestService(obj);

    return x;
  }

}
