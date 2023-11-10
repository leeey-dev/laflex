DROP TABLE IF EXISTS member;
CREATE TABLE member
(
    id               DECIMAL GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    created_at       TIMESTAMP,
    created_by       VARCHAR(255),
    last_modified_at TIMESTAMP,
    last_modified_by VARCHAR(255),
    username         VARCHAR(255),
    phone            VARCHAR(255),
    CONSTRAINT pk_member PRIMARY KEY (id)
);