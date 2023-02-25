
package app.linkedout.daos;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

import app.linkedout.models.CareerExpert;
import lombok.RequiredArgsConstructor;

@Repository("careerexpert")
@RequiredArgsConstructor
public class CareerExpertDataAccess implements CareerExpertDao 
{

        @Override
        public Optional<CareerExpert> selectCareerExpertById(UUID id)
        {
            return null;
        }
}
