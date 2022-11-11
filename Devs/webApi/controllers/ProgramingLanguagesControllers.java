package kodlama.io.Devs.webApi.controllers;

import kodlama.io.Devs.business.abstracts.ProgramingLanguagesService;
import kodlama.io.Devs.business.requests.languages.CreateLanguagesRequest;
import kodlama.io.Devs.business.requests.languages.DeleteLanguagesRequest;
import kodlama.io.Devs.business.requests.languages.UpdateLanguagesRequest;
import kodlama.io.Devs.business.responses.languages.GetAllLanguagesResponse;
import kodlama.io.Devs.entities.concretes.Technologies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/programlanguage")

public class ProgramingLanguagesControllers {
    private ProgramingLanguagesService programingLanguagesService;

    @Autowired
    public ProgramingLanguagesControllers(ProgramingLanguagesService programingLanguagesService){
        this.programingLanguagesService=programingLanguagesService;
    }
    @GetMapping("/getAll")
    public List<GetAllLanguagesResponse> getAll(){
        return programingLanguagesService.getAll();
    }

    @GetMapping("/findbyid")

    public Technologies findbyId(int id){
        return (Technologies) programingLanguagesService.findById(id);
    }
    @PostMapping("/add")
    public void add(CreateLanguagesRequest createLanguagesRequest) throws Exception {
        programingLanguagesService.Add(createLanguagesRequest);
    }
    @DeleteMapping("/delete")
    public void delete(DeleteLanguagesRequest deleteLanguagesRequest){
        programingLanguagesService.Delete(deleteLanguagesRequest);
    }
    @PutMapping("/update")
    public void update(UpdateLanguagesRequest updateLanguagesRequest) throws Exception {
        programingLanguagesService.Update(updateLanguagesRequest);
    }
}
