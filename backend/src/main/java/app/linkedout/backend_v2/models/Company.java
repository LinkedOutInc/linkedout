package app.linkedout.backend_v2.models;

import java.sql.Blob;

public record Company(Integer company_ID, String name, String location, String about, String domain, Blob company_picture) {
}
