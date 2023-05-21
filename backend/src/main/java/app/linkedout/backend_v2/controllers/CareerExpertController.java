package app.linkedout.backend_v2.controllers;

import app.linkedout.backend_v2.services.CareerExpertService;
import app.linkedout.backend_v2.models.CareerExpert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/careerexperts")
public class CareerExpertController {
    private final CareerExpertService careerExpertService;

    public CareerExpertController(CareerExpertService careerExpertService) {
        this.careerExpertService = careerExpertService;
    }

    @GetMapping
    public List<CareerExpert> getCareerExperts() {
        return careerExpertService.getCareerExperts();
    }

    @GetMapping("{id}")
    public CareerExpert getCareerExpertById(@PathVariable Integer id) {
        return careerExpertService.getCareerExpertById(id);
    }

    @PostMapping
    public void insertCareerExpert(@RequestBody CareerExpert careerExpert) {
        careerExpertService.addCareerExpert(careerExpert);
    }

    @DeleteMapping("{id}")
    public void deleteCareerExpert(@PathVariable("id") Integer id) {
        careerExpertService.deleteCareerExpertById(id);
    }

}
