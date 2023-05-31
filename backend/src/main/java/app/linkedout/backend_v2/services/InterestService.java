package app.linkedout.backend_v2.services;

import app.linkedout.backend_v2.dao.InterestDao;
import app.linkedout.backend_v2.models.Interest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InterestService {
    private final InterestDao interestDao;

    public InterestService(InterestDao interestDao) {
        this.interestDao = interestDao;
    }

    public List<Interest> getUserInterests(int user_id) {
        return interestDao.getUserInterests(user_id);
    }
    public Optional<Interest> getInterestById(int id) {
        return interestDao.getInterestById(id);
    }
    public int insertInterest(Interest interest, int user_id) {
        return interestDao.insertInterest(interest, user_id);
    }
    public int deleteInterestById(int id) {
        return interestDao.deleteInterestById(id);
    }
}
