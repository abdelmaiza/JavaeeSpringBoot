package com.boot.cotroller;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class ShipwreckController {

    @Autowired
    private ShipwreckRepository repository;

    @RequestMapping(value = "shipwrecks" , method = RequestMethod.GET)
    public List<Shipwreck> list(){
        return repository.findAll();
    }

    @RequestMapping(value = "shipwrecks" , method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck){
        return repository.saveAndFlush(shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}" , method = RequestMethod.GET)
    public Shipwreck get(@PathVariable Long id){
        return repository.findOne(id);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update(@PathVariable Long id , @RequestBody Shipwreck shipwreck){
        Shipwreck existingShipwreck = repository.findOne(id);
        BeanUtils.copyProperties(shipwreck,existingShipwreck);
        return repository.saveAndFlush(existingShipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}" , method = RequestMethod.DELETE)
    public Shipwreck delete(@PathVariable Long id){
        Shipwreck existingShipwreck = repository.findOne(id);
        repository.delete(existingShipwreck);
        return existingShipwreck;
    }
}
