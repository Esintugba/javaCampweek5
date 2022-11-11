package kodlama.io.Devs.business.abstracts;

import kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.technology.UpdateTechologyRequest;
import kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;
import kodlama.io.Devs.entities.concretes.Technologies;

import java.util.List;

public interface TechnologiesService {

    List<GetAllTechnologyResponse> getAll();

    Technologies findByID(int id);

    void Add(CreateTechnologyRequest createTechnologyRequest) throws Exception;
    void Delete (DeleteTechnologyRequest deleteTechnologyRequest) throws Exception;
    void Update (UpdateTechologyRequest updateTechologyRequest) throws Exception;

}
