
package app.linkedout.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import app.linkedout.daos.CareerExpertDao;
import app.linkedout.models.CareerExpert;

@Service
public class CareerExpertService
{
    private final CareerExpertDao careerExpertDao;

    public CareerExpertService(@Qualifier("careerExpert") CareerExpertDao careerExpertDao)
    {
        this.careerExpertDao = careerExpertDao;
    }

    public Optional<CareerExpert> getCareerExpertById(UUID id)
    {
        return careerExpertDao.selectCareerExpertById(id);
    }
}