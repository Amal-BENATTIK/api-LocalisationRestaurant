package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Specialite;
import com.example.demo.service.SpecialiteService;


@CrossOrigin
@RestController
@RequestMapping("/api/specialites")
public class SpecialiteController {

	@Autowired
	private SpecialiteService specialiteService;
	
	
	@GetMapping("")
	public List<Specialite> getAllSpecialtes() {
		return specialiteService.findAll();
	}
	
	@GetMapping("/{id}")
	public Specialite getSpecialte(@PathVariable Integer id) {
		return specialiteService.findById(id);
	}

	@PostMapping("")
	public void save(@RequestBody Specialite s) {
		specialiteService.save(s);
	}
	
	
	@PostMapping("/{id}/{nom}")
    public Specialite update(@PathVariable Integer id, @PathVariable String nom ) {
		Specialite s = specialiteService.findById(id);
        if (s != null) {
            s.setNom(nom);
            return specialiteService.save(s);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
    	specialiteService.delete(id);
    }
	
	

}
