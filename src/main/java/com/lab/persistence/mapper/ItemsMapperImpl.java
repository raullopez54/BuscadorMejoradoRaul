package com.lab.persistence.mapper;

import com.lab.persistence.mapper.bbdd.BBDD;
import com.lab.persistence.model.ItemsModel;
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

//Para que salga la búsqueda
  @Override
  public List<ItemsModel> getItemsTestMapper(ItemsModel obj) throws Exception
  {
    return this.addItemsModel(" SELECT * " +
                              " FROM items " +
                              " WHERE (nombre LIKE '%" + obj.getNombre() + "%')");
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