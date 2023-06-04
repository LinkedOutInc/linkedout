package app.linkedout.backend_v2.models;

import java.sql.Date;

public record UserReaction(Integer user_id, Integer reaction_id, Integer post_id){
}
