CREATE TABLE task (
    id UUID PRIMARY KEY,
    account_id UUID REFERENCES account (id) NOT NULL,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    due_date TIMESTAMP NOT NULL,
    priority VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    category VARCHAR(255) NOT NULL
);