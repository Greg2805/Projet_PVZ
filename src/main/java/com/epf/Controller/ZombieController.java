package com.epf.Controller;

import com.epf.Dto.ZombieDTO;
import com.epf.Model.Map;
import com.epf.Model.Zombie;
import com.epf.Service.ZombieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/zombies")
public class ZombieController {

    private final ZombieService zombieService;

    @Autowired
    public ZombieController(ZombieService zombieService) {
        this.zombieService = zombieService;
    }

    private ZombieDTO convertToDto(Zombie zombie) {
        ZombieDTO zombieDTO = new ZombieDTO();
        zombieDTO.setId_zombie(zombie.getId_zombie());
        zombieDTO.setNom(zombie.getNom());
        zombieDTO.setPointDeVie(zombie.getPoint_de_vie());
        zombieDTO.setAttaque_par_seconde(zombie.getAttaque_par_seconde());
        zombieDTO.setDegat_attaque(zombie.getDegat_attaque());
        zombieDTO.setVitesse_de_deplacement(zombie.getVitesse_de_deplacement());
        zombieDTO.setChemin_image(zombie.getChemin_image());
        zombieDTO.setId_map(zombie.getId_map());
        return zombieDTO;
    }


    @GetMapping("/test")
    public String test() {
        return "Zombie Controller OK ";
    }

    @GetMapping(produces = "application/json")
    public List<ZombieDTO> getAllZombies() {
        return zombieService.getAllZombie()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }


    @GetMapping(value = "/{id}", produces = "application/json")
    public ZombieDTO getZombieById(@PathVariable int id) {
        return convertToDto(zombieService.getZombieById(id));
    }


    @PostMapping(produces = "application/json", consumes = "application/json")
    public int createZombie(@RequestBody Zombie zombie) {
        return zombieService.createZombie(zombie);
    }

    @PutMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
    public ZombieDTO updateZombie(@PathVariable("id") int id, @RequestBody Zombie zombie) {
        zombie.setId_zombie(id);
        Zombie updatedZombie = zombieService.updateZombie(zombie);
        return convertToDto(updatedZombie);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    public ZombieDTO deleteZombie(@PathVariable("id") int id) {
        Zombie deletedZombie = zombieService.getZombieById(id);

        zombieService.deleteZombie(deletedZombie);

        return convertToDto(deletedZombie);
    }
}
