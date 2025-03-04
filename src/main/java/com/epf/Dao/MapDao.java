package com.epf.Dao;
import com.epf.Model.Map;
import java.util.List;

public interface MapDao {
    int createMap(Map map);
    Map getMapById(int id_map);
    List<Map> getAllMap();
    Map updateMap(Map map);
    boolean deleteMap(Map map);
}
