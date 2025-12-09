CREATE TABLE venue (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    total_capacity BIGINT NOT NULL,
    address VARCHAR(255) NOT NULL
);

CREATE TABLE event (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    total_capacity BIGINT NOT NULL,
    left_capacity BIGINT NOT NULL,
    venue_id BIGINT NOT NULL REFERENCES venue(id),
    CONSTRAINT fk_event_venue FOREIGN KEY (venue_id) REFERENCES venue(id) ON DELETE CASCADE
);