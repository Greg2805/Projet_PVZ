package com.epf;

import com.epf.Dao.ZombieDao;
import com.epf.Dao.ZombieDaoImpl;
import com.epf.Model.Zombie;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Initialiser le contexte Spring avec les classes de configuration et l'implémentation du DAO
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DatabaseConfig.class, ZombieDaoImpl.class);

        // Récupérer le bean ZombieDao
        ZombieDao zombieDao = context.getBean(ZombieDao.class);

        // Créer un objet Zombie de test

        Zombie zombieSupp =  zombieDao.getZombieById(6);
        zombieDao.deleteZombie(zombieSupp);

        // Fermer le contexte Spring
        context.close();
    }
}

