package Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository{

	List<ProgrammingLanguage> programmingLanguages;
	
	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1,"C#"));
		programmingLanguages.add(new ProgrammingLanguage(2,"JavaScript"));
		programmingLanguages.add(new ProgrammingLanguage(3,"C++"));
		programmingLanguages.add(new ProgrammingLanguage(4,"Python"));
		programmingLanguages.add(new ProgrammingLanguage(5,"Ruby"));
		programmingLanguages.add(new ProgrammingLanguage(6,"Go"));
		programmingLanguages.add(new ProgrammingLanguage(7,"C"));
		programmingLanguages.add(new ProgrammingLanguage(8,"Java"));
		
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		return programmingLanguages;
	}

	
	@Override
	public ProgrammingLanguage getById(int id) throws Exception{
		for(ProgrammingLanguage pL : programmingLanguages) {
			if(pL.getId() == id)
				return pL;
		}
		throw new Exception("Böyle bir id yok.");
	}

	
	
	@Override
	public void delete(int id) throws Exception{
		ProgrammingLanguage pL = getById(id);
		programmingLanguages.remove(pL);
		
	}

	@Override
	public void create(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.add(programmingLanguage);
		
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		ProgrammingLanguage pL = getById(programmingLanguage.getId());
		pL.setName(programmingLanguage.getName());
	}

	
	
}
