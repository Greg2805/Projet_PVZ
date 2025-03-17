package com.epf.Dao;

import com.epf.Model.Zombie;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ZombieDaoImpl implements ZombieDao {

    private final JdbcTemplate jdbcTemplate;

    public ZombieDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createZombie(Zombie zombie) {
        String sql = "INSERT INTO Zombie (nom, point_de_vie, attaque_par_seconde, degat_attaque, " +
                "vitesse_de_deplacement, chemin_image) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, zombie.getNom(), zombie.getPoint_de_vie(), zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(), zombie.getVitesse_de_deplacement(), zombie.getChemin_image());
    }

    @Override
    public Zombie getZombieById(int id) {
        String sql = "SELECT * FROM Zombie WHERE id_zombie = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Zombie zombie = new Zombie();
            zombie.setId_zombie(rs.getInt("id_zombie"));
            zombie.setNom(rs.getString("nom"));
            zombie.setPoint_de_vie(rs.getInt("point_de_vie"));
            zombie.setAttaque_par_seconde(rs.getInt("attaque_par_seconde"));
            zombie.setDegat_attaque(rs.getInt("degat_attaque"));
            zombie.setVitesse_de_deplacement(rs.getInt("vitesse_de_deplacement"));
            zombie.setChemin_image(rs.getString("chemin_image"));
            return zombie;
        });

    }

    @Override
    public List<Zombie> getAllZombie() {
        String sql = "SELECT * FROM Zombie";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Zombie zombie = new Zombie();
            zombie.setId_zombie(rs.getInt("id"));
            zombie.setNom(rs.getString("nom"));
            zombie.setPoint_de_vie(rs.getInt("point_de_vie"));
            zombie.setAttaque_par_seconde(rs.getInt("attaque_par_seconde"));
            zombie.setDegat_attaque(rs.getInt("degat_attaque"));
            zombie.setVitesse_de_deplacement(rs.getInt("vitesse_de_deplacement"));
            zombie.setChemin_image(rs.getString("chemin_image"));
            return zombie;
        });
    }

    @Override
    public Zombie updateZombie(Zombie zombie) {
        String sql = "UPDATE Zombie SET nom = ?, points_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, " +
                "vitesse_de_deplacement = ?, chemin_image = ? WHERE id=?";
        jdbcTemplate.update(sql,
                zombie.getNom(),
                zombie.getPoint_de_vie(),
                zombie.getAttaque_par_seconde(),
                zombie.getDegat_attaque(),
                zombie.getVitesse_de_deplacement(),
                zombie.getChemin_image(),
                zombie.getId_zombie()
        );
        return zombie;
    }

    @Override
    public Zombie deleteZombie(int id) {
        String sql = "DELETE FROM Zombie WHERE id_zombie = ?";
        jdbcTemplate.update(sql, id);
        return getZombieById(id);
    }



    @Override
    public List<Zombie> getZombieByMap(int id) {
        String sql = "SELECT * FROM Zombie WHERE id_map = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Zombie zombie = new Zombie();
            zombie.setId_zombie(rs.getInt("id"));
            zombie.setNom(rs.getString("nom"));
            zombie.setPoint_de_vie(rs.getInt("point_de_vie"));
            zombie.setAttaque_par_seconde(rs.getInt("attaque_par_seconde"));
            zombie.setDegat_attaque(rs.getInt("degat_attaque"));
            zombie.setVitesse_de_deplacement(rs.getInt("vitesse_de_deplacement"));
            zombie.setChemin_image(rs.getString("chemin_image"));
            return zombie;
        });
    }
}
