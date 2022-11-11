package kodlama.io.Devs.webApi.controllers;

import kodlama.io.Devs.business.abstracts.TechnologiesService;
import kodlama.io.Devs.business.requests.technology.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.technology.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.technology.UpdateTechologyRequest;
import kodlama.io.Devs.business.responses.technology.GetAllTechnologyResponse;
import kodlama.io.Devs.entities.concretes.Technologies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesControllers {
    private TechnologiesService technologiesService;

    @Autowired
    public TechnologiesControllers(TechnologiesService technologiesService){
        this.technologiesService=technologiesService;
    }
    @GetMapping("/getAll")
    public List<GetAllTechnologyResponse> getAll(){
        return technologiesService.getAll();
    }

    @GetMapping("/findbyid")
    public Technologies findById(int id){
        return technologiesService.findByID(id);
    }

    @PostMapping("/add")
    public void add(CreateTechnologyRequest createTechnologyRequest) throws Exception {
        technologiesService.Add(createTechnologyRequest);
    }

    @DeleteMapping("/delete")
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) throws Exception {
        technologiesService.Delete(deleteTechnologyRequest);
    }
    @PutMapping("/update")
    public void update(UpdateTechologyRequest updateTechologyRequest) throws Exception {
        technologiesService.Update(updateTechologyRequest);
    }



}
