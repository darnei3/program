create table usr (
                      id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                      login VARCHAR(128) NOT NULL,
                      email VARCHAR(128) NOT NULL,
                      password VARCHAR(128) NOT NULL,
                      salary INTEGER NOT NULL
);
