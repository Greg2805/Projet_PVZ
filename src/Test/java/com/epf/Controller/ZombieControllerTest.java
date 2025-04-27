package com.epf.Controller;

import com.epf.Dto.ZombieDTO;
import com.epf.Model.Zombie;
import com.epf.Service.ZombieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ZombieControllerTest {

    @Mock
    private ZombieService zombieService;

    @InjectMocks
    private ZombieController zombieController;

    private Zombie makeZombie(int id) {
        Zombie z = new Zombie();
        z.setId_zombie(id);
        z.setNom("Zombie" + id);
        z.setPoint_de_vie(100 + id);
        z.setAttaque_par_seconde(1 + id);
        z.setDegat_attaque(10 + id);
        z.setVitesse_de_deplacement(2.0 + id);
        z.setChemin_image("/images/zombie" + id + ".png");
        z.setId_map(42);
        return z;
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testEndpoint_shouldReturnOkMessage() {
        String result = zombieController.test();
        assertEquals("Zombie Controller OK ", result);
    }

    @Test
    public void getAllZombies_shouldReturnListOfDto() {

        Zombie z1 = makeZombie(1);
        Zombie z2 = makeZombie(2);
        when(zombieService.getAllZombie()).thenReturn(Arrays.asList(z1, z2));

        List<ZombieDTO> dtos = zombieController.getAllZombies();
        assertNotNull(dtos);
        assertEquals(2, dtos.size());

        ZombieDTO dto1 = dtos.get(0);
        assertEquals(1, dto1.getId_zombie());
        assertEquals("Zombie1", dto1.getNom());
        assertEquals(101, dto1.getPointDeVie());
        assertEquals(1.5 + 1, dto1.getAttaque_par_seconde(), 0.0001);
        assertEquals(11, dto1.getDegat_attaque());
        assertEquals(3.0, dto1.getVitesse_de_deplacement(), 0.0001);
        assertEquals("/images/zombie1.png", dto1.getChemin_image());
        assertEquals(42, dto1.getId_map());

        verify(zombieService, times(1)).getAllZombie();
    }

    @Test
    public void getZombieById_shouldReturnDto() {
        Zombie z = makeZombie(5);
        when(zombieService.getZombieById(5)).thenReturn(z);
        ZombieDTO dto = zombieController.getZombieById(5);
        assertNotNull(dto);
        assertEquals(5, dto.getId_zombie());
        assertEquals("Zombie5", dto.getNom());
        verify(zombieService, times(1)).getZombieById(5);
    }

    @Test
    public void createZombie_shouldReturnNewId() {
        Zombie newZombie = makeZombie(0);
        newZombie.setNom("Newbie");
        when(zombieService.createZombie(newZombie)).thenReturn(123);
        int id = zombieController.createZombie(newZombie);
        assertEquals(123, id);
        verify(zombieService, times(1)).createZombie(newZombie);
    }

    @Test
    public void updateZombie_shouldReturnUpdatedDto() {
        // Given
        Zombie input = makeZombie(0);
        input.setNom("BeforeUpdate");
        Zombie updated = makeZombie(10);
        updated.setNom("AfterUpdate");
        when(zombieService.updateZombie(any(Zombie.class))).thenReturn(updated);
        ZombieDTO dto = zombieController.updateZombie(10, input);
        assertEquals(10, input.getId_zombie());
        assertNotNull(dto);
        assertEquals(10, dto.getId_zombie());
        assertEquals("AfterUpdate", dto.getNom());
        verify(zombieService, times(1)).updateZombie(input);
    }

    @Test
    public void deleteZombie_shouldReturnDeletedDto() {
        Zombie toDelete = makeZombie(7);
        when(zombieService.getZombieById(7)).thenReturn(toDelete);
        ZombieDTO dto = zombieController.deleteZombie(7);
        assertNotNull(dto);
        assertEquals(7, dto.getId_zombie());
        assertEquals("Zombie7", dto.getNom());
        verify(zombieService, times(1)).getZombieById(7);
        verify(zombieService, times(1)).deleteZombie(toDelete);
    }
}
