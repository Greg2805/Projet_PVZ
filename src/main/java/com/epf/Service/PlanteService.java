package com.epf.Service;

import com.epf.Dao.PlanteDao;
import com.epf.Model.Plante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanteService {
    private final PlanteDao planteDao;

    @Autowired
    public PlanteService(PlanteDao planteDao) {
        this.planteDao = planteDao;
    }

    public int createPlante(Plante plante) {
        return planteDao.createPlante(plante);
    }

    public Plante getPlanteById(int id) {
        return planteDao.getPlanteById(id);
    }

    public List<Plante> getAllPlantes() {
        return planteDao.getAllPlantes();
    }

    public Plante updatePlante(Plante plante) {
        return planteDao.updatePlante(plante);
    }

    public boolean deletePlante(Plante plante) {
        return planteDao.deletePlante(plante);
    }
}