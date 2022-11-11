package kodlama.io.Devs.business.concretes;

import kodlama.io.Devs.business.abstracts.TechnologiesService;
import kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.technology.UpdateTechologyRequest;
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
public class TechnologiesManager implements TechnologiesService {

    private TechnologiesRepository technologiesRepository;
    private ProgramingLanguagesRepository programingLanguagesRepository;

    @Autowired
    public TechnologiesManager(TechnologiesRepository technologiesRepository,ProgramingLanguagesRepository programingLanguagesRepository){
        this.technologiesRepository=technologiesRepository;
        this.programingLanguagesRepository=programingLanguagesRepository;
    }
    @Override
    public List<GetAllTechnologyResponse> getAll() {
        List<Technologies> technologies=technologiesRepository.findAll();
        List<GetAllTechnologyResponse> technologyResponses=new ArrayList<GetAllTechnologyResponse>();
        for(Technologies technology:technologies){
            GetAllTechnologyResponse responseItem=new GetAllTechnologyResponse();

            ProgramingLanguage programingLanguage=programingLanguagesRepository.getReferenceById(technology.getLanguage().getId());
            responseItem.setId(technology.getId());
            responseItem.setName(technology.getName());
            responseItem.setName(programingLanguage.getName());

            technologyResponses.add(responseItem);

        }
        return technologyResponses;
    }

    @Override
    public Technologies findByID(int id) {
        Technologies technologies= technologiesRepository.getReferenceById(id);
        ProgramingLanguage language=programingLanguagesRepository.getReferenceById(technologies.getLanguage().getId());
        Technologies technologyResponse=new Technologies();
        technologyResponse.setId(language.getId());
        technologyResponse.setName(technologies.getName());
        technologyResponse.setName(language.getName());

        return technologyResponse;
    }

    @Override
    public void Add(CreateTechnologyRequest createTechnologyRequest) throws Exception{

    }

    @Override
    public void Delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
        Technologies technologies=new Technologies();
        technologies.setId(deleteTechnologyRequest.getId());
        this.programingLanguagesRepository.delete(technologies);

    }

    @Override
    public void Update(UpdateTechologyRequest updateTechologyRequest) throws Exception{

    }
}
