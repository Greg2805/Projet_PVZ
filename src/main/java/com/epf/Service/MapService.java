package com.epf.Service;

import com.epf.Dao.MapDao;
import com.epf.Model.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService {

    private final MapDao mapDao;

    @Autowired
    public MapService(MapDao mapDao) {
        this.mapDao = mapDao;
    }

    public int createMap(Map map) {
        return mapDao.createMap(map);
    }

    public Map getMapById(int id) {
        return mapDao.getMapById(id);
    }

    public List<Map> getAllMaps() {
        return mapDao.getAllMap();
    }

    public Map updateMap(Map map) {
        return mapDao.updateMap(map);
    }

    public boolean deleteMap(Map map) {
        return mapDao.deleteMap(map);
    }
}