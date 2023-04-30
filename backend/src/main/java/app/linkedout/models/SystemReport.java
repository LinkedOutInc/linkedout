package app.linkedout.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class SystemReport extends BaseEntity {
    @Id
    private int reportID;
    private String type;
    private Date date;
    private String systemStatistics;
}
