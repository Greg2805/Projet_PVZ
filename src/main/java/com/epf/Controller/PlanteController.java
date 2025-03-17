package com.epf.Controller;

import com.epf.Dto.PlanteDTO;
import com.epf.Model.Plante;
import com.epf.Service.PlanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/plantes")

public class PlanteController {
    private final PlanteService planteService;

    @Autowired
    public PlanteController(PlanteService planteService) {
        this.planteService = planteService;
    }

    private PlanteDTO convertToDto(Plante plante){
        PlanteDTO planteDTO = new PlanteDTO();
        planteDTO.setNom(plante.getNom());
        planteDTO.setPointDeVie(plante.getPoint_de_vie());
        return planteDTO;
    }

    @GetMapping("")
    public List<PlanteDTO> getAllPlantes() {
        List<Plante> plantes = planteService.getAllPlantes();
        return plantes.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PlanteDTO getPlanteById(@PathVariable int id){
        Plante plante = planteService.getPlanteById(id);
        return convertToDto(plante);
    }

    @PostMapping("")
    public int createPlante(@RequestBody Plante plante){
        int i = planteService.createPlante(plante);
        return i;
    }

    @PutMapping("/{id}")
    public PlanteDTO updatePlante(@PathVariable int id, @RequestBody Plante plante){
        plante.setId_plante(id);
        Plante updatedPlante = planteService.updatePlante(plante);
        return convertToDto(updatedPlante);
    }

    @DeleteMapping("/{id}")
    public PlanteDTO deletePlante(@PathVariable int id, @RequestBody Plante plante){
        plante.setId_plante(id);
        Plante deletedPlante = planteService.deletePlante(plante);
        return convertToDto(deletedPlante);
    }
}
