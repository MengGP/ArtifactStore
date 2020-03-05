-- Таблица Артефактов
CREATE TABLE artifacts
(
    id BIGINT NOT NULL,
    created TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    user_id VARCHAR(256) NOT NULL,
    category VARCHAR(256),
    description VARCHAR(2048),
    PRIMARY KEY (id)
);

-- Таблица комментариев
CREATE TABLE commentaries
(
    id BIGINT NOT NULL,
    artifact_id BIGINT NOT NULL,
    user_id VARCHAR(256) NOT NULL,
    content VARCHAR(2048),
    PRIMARY KEY (id),
    FOREIGN KEY (artifact_id) REFERENCES artifacts (id)
);

-- Заполенение БД начальными данными
--

-- Artifact and comments 1: --
INSERT INTO artifacts(id, created, user_id, category, description) VALUES (
    0,
    '2020-02-18 18:50:25',
    'Amazon',
    'Cloud Computing',
    'AWS Java SDK For The AWS Simple Systems Management (SSM) Service'
);
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (0, 0, 'user01', 'Комментарий к AWS Java SDK #1');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (1, 0, 'user02', 'Комментарий к AWS Java SDK #2');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (2, 0, 'user02', 'Комментарий к AWS Java SDK #3');

-- Artifact and comments 2: --
INSERT INTO artifacts(id, created, user_id, category, description) VALUES (
    1,
    '2020-02-06 09:07:09',
    'Interledger',
    'JSON Lib',
    'Connector :: Routing API'
);
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (3, 1, 'user02', 'Комментарий к Connector Routing API #1');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (4, 1, 'user03', 'Комментарий к Connector Routing API #2');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (5, 1, 'user04', 'Комментарий к Connector Routing API #3');

-- Artifact and comments 3: --
INSERT INTO artifacts(id, created, user_id, category, description) VALUES (
    2,
    '2020-02-17 13:49:56',
    'Oracle',
    'Cloud Computing',
    'Oracle Cloud Infrastructure SDK Events'
);
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (6, 2, 'user02', 'Комментарий к Oracle Cloud Infrastructure SDK Events #1');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (7, 2, 'user05', 'Комментарий к Oracle Cloud Infrastructure SDK Events #2');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (8, 2, 'user04', 'Комментарий к Oracle Cloud Infrastructure SDK Events #3');

-- Artifact and comments 3: --
INSERT INTO artifacts(id, created, user_id, category, description) VALUES (
    3,
    '2020-02-14 21:13:37',
    'Amazon',
    'Cloud Computing',
    'AWS Java SDK For Amazon Redshift'
);
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (9, 3, 'user06', 'Комментарий к AWS Java SDK For Amazon Redshift #1');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (10, 3, 'user07', 'Комментарий к AWS Java SDK For Amazon Redshift #2');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (11, 3, 'user04', 'Комментарий к AWS Java SDK For Amazon Redshift #3');


