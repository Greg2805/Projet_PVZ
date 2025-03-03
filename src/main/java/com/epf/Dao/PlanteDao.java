package com.epf.Dao;

import com.epf.Model.Plante;


import java.util.List;

public interface PlanteDao {
    int createPlante(Plante plante);
    Plante getPlanteById(int id);
    List<Plante> getAllPlante();
    Plante uptdatePlante(Plante plante);
    Plante deletePlante(Plante plante);
    List<Plante> getPlanteByMap(int id);
}
