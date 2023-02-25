
package app.linkedout.controllers;
import java.util.UUID;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.linkedout.models.CareerExpert;
import app.linkedout.services.CareerExpertService;


@RequestMapping("/api/v1/careerexpert")
@CrossOrigin(origins = "*")
@RestController
public class CareerExpertController 
{
    private final CareerExpertService careerExpertService;

    public CareerExpertController(CareerExpertService careerExpertService)
    {
        this.careerExpertService = careerExpertService;
    }

    @GetMapping(path = "{id}")
    public CareerExpert getCareerExpertById(@PathVariable("id") UUID id)
    {
        return careerExpertService.getCareerExpertById(id).orElse(null);
    }
}
