package app.linkedout.backend_v2.dao;

import app.linkedout.backend_v2.models.CareerExpert;

import java.util.List;
import java.util.Optional;

public interface CareerExpertDao {
        List<CareerExpert> getCareerExperts();
        int insertCareerExpert(CareerExpert careerExpert);
        int deleteCareerExpertById(int id);
        Optional<CareerExpert> getCareerExpertById(int id);
        Optional<CareerExpert> getCareerExpertByEmail(String email);
}
