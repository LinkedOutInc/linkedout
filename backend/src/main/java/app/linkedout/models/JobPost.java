package app.linkedout.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class JobPost extends BaseEntity {
    @Id
    private int postID;
    private Date date;
    private String content;
    private String jobTitle;
    private int companyId;
    private String workplace;
    private String location;
    private String position;
    private String profession;
}
