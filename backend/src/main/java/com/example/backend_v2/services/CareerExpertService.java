package com.example.backend_v2.services;

import com.example.backend_v2.dao.CareerExpertDao;
import com.example.backend_v2.dao.PersonDao;
import com.example.backend_v2.models.CareerExpert;
import com.example.backend_v2.models.Person;
import jakarta.el.PropertyNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerExpertService {

    private final CareerExpertDao careerExpertDao;

    public CareerExpertService(CareerExpertDao careerExpertDao) {
        this.careerExpertDao = careerExpertDao;
    }

    public List<CareerExpert> getCareerExperts() {
        return careerExpertDao.getCareerExperts();
    }

    public void addCareerExpert(CareerExpert careerExpert) {
        careerExpertDao.insertCareerExpert(careerExpert);
    }

    public void deleteCareerExpertById(int id) {
        careerExpertDao.deleteCareerExpertById(id);
    }

    public CareerExpert getCareerExpertById(int id) {
        return careerExpertDao.getCareerExpertById(id).orElseThrow(PropertyNotFoundException::new);
    }

    public CareerExpert getCareerExpertByEmaill(String email) {
        return careerExpertDao.getCareerExpertByEmail(email).orElseThrow(PropertyNotFoundException::new);
    }
}
