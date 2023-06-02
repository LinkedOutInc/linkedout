CREATE TABLE IF NOT EXISTS Admin
(
    PRIMARY KEY (id)
) INHERITS (Person);

CREATE TABLE IF NOT EXISTS SystemReport (
    report_id BIGSERIAL PRIMARY KEY,
    type VARCHAR(50) NOT NULL,
    date DATE NOT NULL,
    system_statistics VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Reports (
    admin_id BIGSERIAL NOT NULL,
    report_id BIGSERIAL NOT NULL,
    FOREIGN KEY (admin_id) REFERENCES Admin(id),
    FOREIGN KEY (report_id) REFERENCES SystemReport(report_id)
);

CREATE TABLE IF NOT EXISTS Hiring_Reports (
    JobPost_id BIGSERIAL NOT NULL,
    Report_id BIGSERIAL NOT NULL,
    apply_count BIGSERIAL NOT NULL,
    FOREIGN KEY (JobPost_id) REFERENCES JobPost(post_ID),
    PRIMARY KEY (Report_id)
);

CREATE OR REPLACE FUNCTION trigger_function()
    RETURNS TRIGGER
AS $$
BEGIN
    IF NEW.post_ID IS NOT NULL THEN
        UPDATE Hiring_Reports SET apply_count = apply_count + 1
        WHERE JobPost_id = NEW.post_ID;
    end if;
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE OR REPLACE TRIGGER apply_count_update
    AFTER INSERT ON applies
    FOR EACH ROW
    EXECUTE FUNCTION trigger_function();

