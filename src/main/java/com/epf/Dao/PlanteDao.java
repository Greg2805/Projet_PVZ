package com.epf.Dao;

import com.epf.Model.Plante;
import java.util.List;

public interface PlanteDao {
    int createPlante(Plante plante);
    Plante getPlanteById(int id);
    List<Plante> getAllPlantes();
    Plante updatePlante(Plante plante);
    boolean deletePlante(Plante plante);




}
