package Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageRepository {
	//getAll çağırılırsa diller listelenir.
	List<ProgrammingLanguage> getAll();
	
	ProgrammingLanguage getById(int id) throws Exception;
	
	void delete(int id) throws Exception;
	
	void create(ProgrammingLanguage programmingLanguage);
	
	void update(ProgrammingLanguage programmingLanguage) throws Exception;
	
}	
