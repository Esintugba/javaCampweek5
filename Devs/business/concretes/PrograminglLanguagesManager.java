package kodlama.io.Devs.business.concretes;

import kodlama.io.Devs.business.abstracts.ProgramingLanguagesService;
import kodlama.io.Devs.business.requests.languages.CreateLanguagesRequest;
import kodlama.io.Devs.business.requests.languages.DeleteLanguagesRequest;
import kodlama.io.Devs.business.requests.languages.UpdateLanguagesRequest;
import kodlama.io.Devs.business.responses.languages.GetAllLanguagesResponse;
import kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;
import kodlama.io.Devs.dataAccess.abstracts.ProgramingLanguagesRepository;
import kodlama.io.Devs.dataAccess.abstracts.TechnologiesRepository;
import kodlama.io.Devs.entities.concretes.ProgramingLanguage;
import kodlama.io.Devs.entities.concretes.Technologies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrograminglLanguagesManager implements ProgramingLanguagesService {
    private ProgramingLanguagesRepository programingLanguagesRepository;


    @Autowired
    public PrograminglLanguagesManager(ProgramingLanguagesRepository programingLanguagesRepository) {
        this.programingLanguagesRepository = programingLanguagesRepository;

    }

    @Override
    public List<GetAllLanguagesResponse> getAll() {
        List<ProgramingLanguage> languages = programingLanguagesRepository.findAll();
        List<GetAllLanguagesResponse> languagesResponses = new ArrayList<GetAllLanguagesResponse>();
        for (ProgramingLanguage language : languages) {
            GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
            responseItem.setId(language.getId());
            responseItem.setName(language.getName());

            languagesResponses.add(responseItem);
        }
        //İş kuralları
        return languagesResponses;
    }

    @SuppressWarnings("deprecation")
    public ProgramingLanguage findById(int id) {
        return programingLanguagesRepository.getById(id);
    }

    @Override
    public void Add(CreateLanguagesRequest createLanguagesRequest) throws Exception{
        ProgramingLanguage programingLanguage = new ProgramingLanguage();
        programingLanguage.setName(createLanguagesRequest.getName());

        List<ProgramingLanguage> programingLanguages=programingLanguagesRepository.findAll();
        for(ProgramingLanguage programingLanguage1:programingLanguages){
            if (programingLanguage1.getName().equals(programingLanguage.getName())){
                throw new Exception("Aynı isimde bir programlama dili mecvut!!");
            }
        }
        if(programingLanguage.getName().isEmpty()){
            throw new Exception("Programlama dili boş geçilemez!!");
        }
        this.programingLanguagesRepository.save(programingLanguage);
    }

    @Override
    public void Delete(DeleteLanguagesRequest deleteLanguagesRequest) {
        ProgramingLanguage programingLanguage=new ProgramingLanguage();
        programingLanguage.setId(deleteLanguagesRequest.getId());
        this.programingLanguagesRepository.delete(programingLanguage);
    }

    @Override
    public void Update(UpdateLanguagesRequest updateLanguagesRequest)  throws Exception{
        ProgramingLanguage programingLanguage=new ProgramingLanguage();
        programingLanguage.setName(updateLanguagesRequest.getName());
        List<ProgramingLanguage> programingLanguages=programingLanguagesRepository.findAll();
        for(ProgramingLanguage programingLanguage1:programingLanguages){
            if (programingLanguage1.getName().equals(programingLanguage.getName())){
                throw new Exception("Aynı isimde bir programlama dili mecvut!!");
            }
        }
        if(programingLanguage.getName().isEmpty()){
            throw new Exception("Programlama dili boş geçilemez!!");
        }
        ProgramingLanguage updatedProgramingLanguage = programingLanguagesRepository
                .getReferenceById(programingLanguage.getId());
        updatedProgramingLanguage.setName(programingLanguage.getName());
        programingLanguagesRepository.save(updatedProgramingLanguage);
        this.programingLanguagesRepository.save(programingLanguage);
    }


}