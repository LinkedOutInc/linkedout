package app.linkedout.backend_v2.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
public class Success extends HashMap<String, Object> {
    private String message;

    private Success(String message) {
        put("status", 200);
        put("message", message);
    }

    public static ResponseEntity create(String message) {
        return ResponseEntity.status(200).body(new Success(message));
    }
}
