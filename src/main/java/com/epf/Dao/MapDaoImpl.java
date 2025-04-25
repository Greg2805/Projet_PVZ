package com.epf.Dao;

import com.epf.Model.Map;
import com.epf.Model.Plante;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
@Repository
public class MapDaoImpl implements MapDao{

    private final JdbcTemplate jdbcTemplate;

    public MapDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createMap(Map map) {
        String sql = "INSERT INTO Map (ligne, colonne, chemin_image) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, map.getLigne(), map.getColonne(), map.getCheminImage());
    }

    @Override
    public Map getMapById(int id_map) {
        String sql = "SELECT * FROM Map Where id_map = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id_map}, (rs, rowNum) ->  {
            Map map = new Map();
            map.setLigne(rs.getInt("ligne"));
            map.setColonne(rs.getInt("colonne"));
            map.setCheminImage(rs.getString("chemin_image"));
            return map;
        });
    }

    @Override
    public List<Map> getAllMap() {

        String sql = "SELECT * FROM Map";

        return jdbcTemplate.query(sql, ((ResultSet rs, int rowNum) -> {
            Map map = new Map();
            map.setCheminImage(rs.getString("chemin_image"));
            map.setLigne((rs.getInt("ligne")));
            map.setColonne((rs.getInt("colonne")));

            return map;
        }));


    }

    @Override
    public Map updateMap(Map map) {

        String sql = "UPDATE Map SET ligne = ?, colonne = ?, chemin_image = ? WHERE id_map =?";

        jdbcTemplate.update(sql,
                map.getLigne(),
                map.getColonne(),
                map.getCheminImage(),
                map.getId()
        );

        return map;
    }

    @Override
    public boolean deleteMap(Map map) {
        String sql = "DELETE FROM Map WHERE id_map = ?";
        int i = jdbcTemplate.update(sql, map.getId());
        return i == 1;
    }
}
