package com.boot.unitTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;

import com.boot.cotroller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ShipwreckControllerTest {

    @InjectMocks
    private ShipwreckController controller;

    @Mock
    private ShipwreckRepository repository;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreckGet(){
        Shipwreck sw = new Shipwreck();
        sw.setId(1L);
        Mockito.when(repository.findOne(1L)).thenReturn(sw);
        Shipwreck shipwreck = controller.get(1L);
        verify(repository).findOne(1L);
        //assertEquals(1L,shipwreck.getId().longValue());
        assertThat(shipwreck.getId(),is(1L));
    }
}
