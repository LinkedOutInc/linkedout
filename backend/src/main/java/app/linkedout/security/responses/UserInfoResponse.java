package app.linkedout.security.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoResponse {
    private Long id;
    private String email;
    private String role;
    private String cookie;

    public UserInfoResponse(Long id, String email, String role, String cookie) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.cookie = cookie;
    }
}
