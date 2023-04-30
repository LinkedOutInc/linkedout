package app.linkedout.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class HiringReports extends BaseEntity {
    @Id
    private int postID;
    @Id
    private int reportID;
    private int applyCount;
}
