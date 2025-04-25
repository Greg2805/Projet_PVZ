package com.epf.Controller;
import com.epf.Dto.MapDTO;
import com.epf.Model.Map;
import com.epf.Service.MapService;
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
        return mapService.createMap(map);
    }

    @PutMapping("/{id}")
    public MapDTO updateMap(@PathVariable("id") int id, @RequestBody Map map){
        map.setId(id);
        Map updatedMap = mapService.updateMap(map);
        return convertToDto(updatedMap);
    }

    @DeleteMapping("/{id}")
    public MapDTO deleteMap(@PathVariable("id") int id){
        Map deletedMap = mapService.getMapById(id);

        mapService.deleteMap(deletedMap);

        return convertToDto(deletedMap);
    }
}
