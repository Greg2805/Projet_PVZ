package com.epf.Dao;

import com.epf.Model.Effet;
import com.epf.Model.Plante;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PlanteDaoImpl implements PlanteDao{

    private final JdbcTemplate jdbcTemplate;

    public PlanteDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createPlante(Plante plante) {
        String sql = "INSERT INTO Plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, " +
                "cout, soleil_par_seconde, effet,chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(), plante.getCout(), plante.getSoleil_par_seconde(), plante.getEffet().getLabel(),
                plante.getChemin_image());
    }

    @Override
    public Plante getPlanteById(int id) {
        String sql = "SELECT * FROM Plante WHERE id_plante = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Plante plante = new Plante();
            plante.setId_plante(rs.getInt("id_plante"));
            plante.setNom(rs.getString("nom"));
            plante.setPoint_de_vie(rs.getInt("point_de_vie"));
            plante.setAttaque_par_seconde(rs.getInt("attaque_par_seconde"));
            plante.setDegat_attaque(rs.getInt("degat_attaque"));
            plante.setCout(rs.getInt("cout"));
            plante.setSoleil_par_seconde(rs.getDouble("soleil_par_seconde"));
            String effetLabel = rs.getString("effet");
            if (effetLabel != null) {
                plante.setEffet(Effet.fromString(effetLabel));
            } else {
                plante.setEffet(null);
            }
            plante.setChemin_image(rs.getString("chemin_image"));
            return plante;
        });
    }

    @Override
    public List<Plante> getAllPlantes() {
        String sql = "SELECT * FROM Plante";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Plante plante = new Plante();
            plante.setId_plante(rs.getInt("id_plante"));
            plante.setNom(rs.getString("nom"));
            plante.setPoint_de_vie(rs.getInt("point_de_vie"));
            plante.setAttaque_par_seconde(rs.getInt("attaque_par_seconde"));
            plante.setDegat_attaque(rs.getInt("degat_attaque"));
            plante.setCout(rs.getInt("cout"));
            plante.setSoleil_par_seconde(rs.getDouble("soleil_par_seconde"));
            plante.setEffet(Effet.fromString(rs.getString("effet")));
            plante.setChemin_image(rs.getString("chemin_image"));
            return plante;
        });
    }

    @Override
    public Plante updatePlante(Plante plante) {
        String sql = "UPDATE Plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, " +
                "cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante=?";
        jdbcTemplate.update(sql,
                plante.getNom(),
                plante.getPoint_de_vie(),
                plante.getAttaque_par_seconde(),
                plante.getDegat_attaque(),
                plante.getCout(),
                plante.getSoleil_par_seconde(),
                plante.getEffet(),
                plante.getChemin_image(),
                plante.getId_plante()
        );
        return plante;
    }

    @Override
    public boolean deletePlante(Plante plante) {
        String sql = "DELETE FROM Plante WHERE id_plante = ?";
        int i = jdbcTemplate.update(sql, plante.getId_plante());
        return i == 1;
    }
}
