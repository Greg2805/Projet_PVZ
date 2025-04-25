package com.epf.Controller;

import com.epf.Dto.PlanteDTO;
import com.epf.Model.Plante;
import com.epf.Model.Zombie;
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

    private PlanteDTO convertToDto(Plante plante) {
        PlanteDTO planteDTO = new PlanteDTO();
        planteDTO.setId_plante(plante.getId_plante());
        planteDTO.setNom(plante.getNom());
        planteDTO.setPoint_de_vie(plante.getPoint_de_vie());
        planteDTO.setAttaque_par_seconde(plante.getAttaque_par_seconde());
        planteDTO.setDegat_attaque(plante.getDegat_attaque());
        planteDTO.setCout(plante.getCout());
        planteDTO.setSoleil_par_seconde(plante.getSoleil_par_seconde());
        planteDTO.setEffet(plante.getEffet() != null ? plante.getEffet().getLabel() : null);
        planteDTO.setChemin_image(plante.getChemin_image());
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
    public PlanteDTO getPlanteById(@PathVariable("id") int id){
        Plante plante = planteService.getPlanteById(id);
        return convertToDto(plante);
    }

    @PostMapping("")
    public int createPlante(@RequestBody Plante plante){
        return planteService.createPlante(plante);
    }

    @PutMapping("/{id}")
    public PlanteDTO updatePlante(@PathVariable("id") int id, @RequestBody Plante plante){
        plante.setId_plante(id);
        Plante updatedPlante = planteService.updatePlante(plante);
        return convertToDto(updatedPlante);
    }

    @DeleteMapping("/{id}")
    public PlanteDTO deletePlante(@PathVariable("id") int id){




        Plante deletedPlante = planteService.getPlanteById(id);

        planteService.deletePlante(deletedPlante);

        return convertToDto(deletedPlante);
    }
}
