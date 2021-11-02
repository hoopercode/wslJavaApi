package com.nology.WSLSurfers.rest;

import com.nology.WSLSurfers.entity.Wsl;
import com.nology.WSLSurfers.exception.InvalidRequestData;
import com.nology.WSLSurfers.exception.ResourceNotFoundException;
import com.nology.WSLSurfers.repository.IWslRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/wsl-surfers")

public class WslController {

    //Dependency Injection
    @Autowired
    private IWslRepository wslrepo;

    @GetMapping()
    public ResponseEntity<List<Wsl>> allSurfers() {
        return ResponseEntity.status(HttpStatus.OK).body(wslrepo.findAll());

    }

    @PostMapping
    public ResponseEntity<Wsl> createSurfer(@RequestBody Wsl surfer) throws InvalidRequestData {
        try {
            Wsl newSurfer = wslrepo.save(surfer);
            return ResponseEntity.status(HttpStatus.CREATED).body(newSurfer);
        } catch (Exception e){
            throw new InvalidRequestData("Incorrect request data");
        }



    }
    @GetMapping("/{id}")
    public ResponseEntity<Wsl> getRecipe(@PathVariable int id) throws Exception {
        Wsl requestSurfer = wslrepo.findById(id).orElse(null);
        if(requestSurfer == null) throw new ResourceNotFoundException("Not Recipe Found" + id);


        return ResponseEntity.status(HttpStatus.FOUND).body(requestSurfer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wsl> changeRecipe(@PathVariable int id, @RequestBody Wsl changedRecipe) throws ResourceNotFoundException {
        checkIfExists(id);
        changedRecipe.setId(id);
        wslrepo.save(changedRecipe);

        return ResponseEntity.status(HttpStatus.CREATED).body(changedRecipe);
    }
    private void checkIfExists(int id) throws ResourceNotFoundException {
        Wsl existingSurfer = wslrepo.findById(id).orElse(null);
        if(existingSurfer == null) throw new ResourceNotFoundException("No Surfer Found" + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Wsl>> deleteRecipe(@PathVariable int id) throws ResourceNotFoundException {
        checkIfExists(id);
        wslrepo.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body(wslrepo.findAll());
    }
}
