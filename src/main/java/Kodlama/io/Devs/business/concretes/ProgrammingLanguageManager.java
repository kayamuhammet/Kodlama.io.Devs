package Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlama.io.Devs.business.abstracts.ProgrammingLanguageService;
import Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{
	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}


	@Override
	public List<ProgrammingLanguage> getAll() {
		//iş kuralları
		return programmingLanguageRepository.getAll();
	}


	@Override
	public ProgrammingLanguage getById(int id) throws Exception {
		return programmingLanguageRepository.getById(id);
	}
	
	@Override
	public void delete(int id) throws Exception {
		programmingLanguageRepository.delete(id);
	}


	@Override
	public void create(ProgrammingLanguage programmingLanguage) throws Exception{
		if(programmingLanguage.getName().isEmpty()) {
			throw new Exception("Programlama dili boş geçilemez.");
		}
		//isimler tekrar edemez.
		for(ProgrammingLanguage pL : getAll()) {
			if(pL.getName().equals(programmingLanguage.getName())) {
				throw new Exception("Bu programlama dili zaten var!");
			}
		}
		programmingLanguageRepository.create(programmingLanguage);
	}


	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		programmingLanguageRepository.update(programmingLanguage);
	}



	
	
}
