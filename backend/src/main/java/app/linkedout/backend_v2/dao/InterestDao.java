package app.linkedout.backend_v2.dao;

import app.linkedout.backend_v2.models.Interest;

import java.util.List;
import java.util.Optional;

public interface InterestDao {
    List<Interest> getUserInterests(int user_id);
    Optional<Interest> getInterestById(int id);
    int insertInterest(Interest interest);
    int deleteInterestById(int id);
}
