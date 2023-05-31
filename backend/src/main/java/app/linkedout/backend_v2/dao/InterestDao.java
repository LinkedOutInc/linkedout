package app.linkedout.backend_v2.dao;

import app.linkedout.backend_v2.models.Interest;

import java.util.List;
import java.util.Optional;

public interface InterestDao {
    List<Interest> getUserInterests(int user_id);
    Optional<Interest> getInterestById(int id);
    int insertInterest(Interest interest, int user_id);
    int deleteInterestById(int id);
    int deleteInterest(Interest interest);
}
