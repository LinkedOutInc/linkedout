package app.linkedout.daos;

import java.util.Optional;
import java.util.UUID;

import app.linkedout.models.CareerExpert;



public interface CareerExpertDao 
{
    Optional<CareerExpert> selectCareerExpertById(UUID id);
}
