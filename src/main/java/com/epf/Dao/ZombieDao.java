package com.epf.Dao;
import com.epf.Model.Zombie;
import java.util.List;
public interface ZombieDao {
    int createZombie(Zombie zombie);
    Zombie getZombieById(int id);
    List<Zombie> getAllZombie();
    Zombie updateZombie(Zombie zombie);
    boolean deleteZombie(Zombie zombie);
    List<Zombie> getZombieByMap(int id);
}

