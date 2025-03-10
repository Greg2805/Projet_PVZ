package com.epf.Service;
import com.epf.Model.Zombie;
import com.epf.Dao.ZombieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class ZombieService {
    private final ZombieDao zombieDao;

    @Autowired
    public ZombieService(ZombieDao zombieDao) {
        this.zombieDao = zombieDao;
    }

    public int createZombie(Zombie zombie){
        return zombieDao.createZombie(zombie);
    }

    public Zombie getZombieById(int id){
        return zombieDao.getZombieById(id);
    }

    public List<Zombie> getAllZombie(){
        return zombieDao.getAllZombie();
    }

    public Zombie updateZombie(Zombie zombie){
        return zombieDao.updateZombie(zombie);
    }

    public Zombie deleteZombie(Zombie zombie){
        return zombieDao.deleteZombie(zombie);
    }

    public List<Zombie> getZombieByMap(Zombie zombie){
        return zombieDao.getZombieByMap(zombie.getId_map());
    }
}
