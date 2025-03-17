package com.epf.Controller;
import com.epf.Dto.ZombieDTO;
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

    private ZombieDTO convertToDto(Zombie zombie){
        ZombieDTO zombieDTO = new ZombieDTO();
        zombieDTO.setNom(zombie.getNom());
        zombieDTO.setPointDeVie(zombie.getPoint_de_vie());
        return zombieDTO;
    }

    @GetMapping("")
    public List<ZombieDTO> getAllZombies() {
        List<Zombie> zombies = zombieService.getAllZombie();
        return zombies.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ZombieDTO getZombieById(@PathVariable int id){
        Zombie zombie = zombieService.getZombieById(id);
        return convertToDto(zombie);
    }

    @PostMapping("")
    public int createZombie(@RequestBody Zombie zombie){
         int i = zombieService.createZombie(zombie);
         return i;
    }

    @PutMapping("{/id}")
    public ZombieDTO updateZombie(@PathVariable int id, @RequestBody Zombie zombie){
        zombie.setId_zombie(id);
        Zombie updatedZombie = zombieService.updateZombie(zombie);
        return convertToDto(updatedZombie);
    }

    @DeleteMapping("{/id}")
    public ZombieDTO deleteZombie(@PathVariable int id){

        Zombie deletedZombie = zombieService.deleteZombie(id);
        return convertToDto(deletedZombie);
    }

}
