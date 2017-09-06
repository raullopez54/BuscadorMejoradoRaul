package com.lab.persistence.mapper;

import com.lab.persistence.mapper.bbdd.BBDD;
import com.lab.persistence.model.ItemsModel;
import com.lab.persistence.model.PesoModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ItemsMapperImpl implements ItemsMapper
{

  @Autowired
  BBDD db;

//Para que salgan todos los elementos
  @Override
  public List<ItemsModel> allItemsTestMapper(ItemsModel obj) throws Exception
  {
    return this.addItemsModel("SELECT * FROM items");
  }

//Para que salga la búsqueda por cadena
  @Override
  public List<ItemsModel> cadenaItemsTestMapper(ItemsModel obj) throws Exception
  {
      
    System.out.println("LLEGA AQUI O QUE - CADENA MAPPER");

    return this.addItemsModel(" SELECT * " +
                              " FROM items " +
                              " WHERE (nombre LIKE '%" + obj.getNombre() + "%')");
   
  }
  
  //Para que salga la búsqueda por numero
  @Override
  public List<ItemsModel> numeroItemsTestMapper(PesoModel obj) throws Exception
  {
    System.out.println("LLEGA AQUI O QUE - NUMERO MAPPER");
    String sql = " SELECT * FROM items WHERE id IN (SELECT iditem FROM pesoitems WHERE peso IN (" + obj.getPeso()+ ")";
    System.out.println(sql);
    
      
    return this.addItemsModel(" SELECT * " +
                              " FROM items " +
                             " WHERE id IN " +
                             "(SELECT iditem FROM pesoitems WHERE peso IN (" + obj.getPeso()+ "))");
                             
    
    
     
         
  }
  


  /**
   * GENERA UNA LISTA DE OBJETOS TIPO ITEMSMODEL.
   *
   * @param String Sql a ejecutar.
   *
   * @return Lista de objetos tipo ItemsModel.
   */
  private List<ItemsModel> addItemsModel(String sql) throws Exception
  {
    List<ItemsModel> listItems = new ArrayList<>();

    db.conecta();

    ResultSet rs = db.consulta(sql);
    while (rs.next())
    {
      ItemsModel item = new ItemsModel();

      item.setId(rs.getInt("id"));
      item.setNombre(rs.getString("nombre"));
      item.setDescripcion(rs.getString("descripcion"));
      item.setUrl(rs.getString("url"));

      listItems.add(item);
    }

    db.desconecta();

    return listItems;
  }


}