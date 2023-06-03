package app.linkedout.backend_v2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
public class Error extends HashMap<String, Object> {
    private int status;
    private String message;

    private Error(int status, String message) {
        put("status", status);
        put("message", message);
    }

    public static ResponseEntity create(int status, String message) {
        return ResponseEntity.status(status).body(new Error(status, message));
    }
}
