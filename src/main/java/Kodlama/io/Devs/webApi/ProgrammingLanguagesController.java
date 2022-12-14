package Kodlama.io.Devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingLanguage")
public class ProgrammingLanguagesController {
	private ProgrammingLanguageService programmingLanguageService;
	
	
	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}


	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@GetMapping("/getById")
	public ProgrammingLanguage getById(@PathVariable int id) throws Exception{
		return programmingLanguageService.getById(id);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void delete(@PathVariable int id) throws Exception{
		programmingLanguageService.delete(id);
	}
	
	@PostMapping("/create")
	public void create(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception{
		programmingLanguageService.create(programmingLanguage);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody ProgrammingLanguage programmingLanguage) throws Exception{
		programmingLanguageService.update(programmingLanguage);
	}
	
	
	
}
