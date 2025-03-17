package com.epf.Controller;
import com.epf.Dto.MapDTO;
import com.epf.Dto.PlanteDTO;
import com.epf.Model.Map;
import com.epf.Model.Plante;
import com.epf.Service.MapService;
import com.epf.Service.PlanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/maps")
public class MapController {
    private final MapService mapService;

    @Autowired
    public MapController(MapService mapService){
        this.mapService = mapService;
    }

    private MapDTO convertToDto(Map map){
        MapDTO mapDto = new MapDTO();
        mapDto.setNbColonne(map.getColonne());
        mapDto.setNbLigne(map.getLigne());
        return mapDto;
    }

    @GetMapping("")
    public List<MapDTO> getAllMaps(){
        List<Map> maps = mapService.getAllMaps();
        return maps.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("")
    public int createMap(@RequestBody Map map){
        int i = mapService.createMap(map);
        return i;
    }

    @PutMapping("{/id}")
    public MapDTO updateMap(@PathVariable int id, @RequestBody Map map){
        map.setId(id);
        Map updatedMap = mapService.updateMap(map);
        return convertToDto(updatedMap);
    }

    @DeleteMapping("/{id}")
    public MapDTO deleteMap(@PathVariable int id){
        Map deletedMap = mapService.getMapById(id);
        return convertToDto(deletedMap);
    }

}
