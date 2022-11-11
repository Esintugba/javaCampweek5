package kodlama.io.Devs.business.abstracts;

import kodlama.io.Devs.business.requests.languages.CreateLanguagesRequest;
import kodlama.io.Devs.business.requests.languages.DeleteLanguagesRequest;
import kodlama.io.Devs.business.requests.languages.UpdateLanguagesRequest;
import kodlama.io.Devs.business.responses.languages.GetAllLanguagesResponse;
import kodlama.io.Devs.entities.concretes.ProgramingLanguage;

import java.util.List;

public interface ProgramingLanguagesService {
    List<GetAllLanguagesResponse> getAll();
    ProgramingLanguage findById(int id);

    void Add (CreateLanguagesRequest createLanguagesRequest) throws Exception;
    void Delete (DeleteLanguagesRequest deleteLanguagesRequest);
    void Update (UpdateLanguagesRequest updateLanguagesRequest) throws Exception;

}


