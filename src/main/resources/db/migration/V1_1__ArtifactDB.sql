-- Таблица Артефактов
CREATE TABLE artifacts
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    created TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    user_id VARCHAR(256) NOT NULL,
    category VARCHAR(256),
    description VARCHAR(2048) NOT NULL,
    PRIMARY KEY (id)
);

-- Таблица комментариев
CREATE TABLE commentaries
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    artifact_id BIGINT NOT NULL,
    user_id VARCHAR(256) NOT NULL,
    content VARCHAR(2048) NOT NULL,
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
    'No category',
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

-- Artifact and comments 4: --
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

-- Artifact and comments 5: --
INSERT INTO artifacts(id, created, user_id, category, description) VALUES (
    4,
    '2020-02-09 12:08:26',
    'Google',
    'Service',
    'Cloud Dataproc API V1 Rev149 1.25.0'
);
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (12, 4, 'user08', 'Комментарий к Cloud Dataproc API #1');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (13, 4, 'user09', 'Комментарий к Cloud Dataproc API #2');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (14, 4, 'user07', 'Комментарий к Cloud Dataproc API #3');

-- Artifact and comments 6: --
INSERT INTO artifacts(id, created, user_id, category, description) VALUES (
    5,
    '2020-02-13 15:22:28',
    'Google',
    'Service',
    'Google Sheets API V4 Rev610 1.25.0'
);
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (15, 5, 'user62', 'Комментарий к Google Sheets API #1');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (16, 5, 'user46', 'Комментарий к Google Sheets API #2');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (17, 5, 'user12', 'Комментарий к Google Sheets API #3');

-- Artifact and comments 7: --
INSERT INTO artifacts(id, created, user_id, category, description) VALUES (
    6,
    '2020-02-16 11:18:29',
    'Jboss',
    'REST',
    'RESTEasy JAX RS JSAPI'
);
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (18, 6, 'user62', 'Комментарий к RESTEasy JAX RS JSAPI #1');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (19, 6, 'user46', 'Комментарий к RESTEasy JAX RS JSAPI #2');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (20, 6, 'user12', 'Комментарий к RESTEasy JAX RS JSAPI #3');

-- Artifact and comments 8: --
INSERT INTO artifacts(id, created, user_id, category, description) VALUES (
    7,
    '2020-02-14 03:38:54',
    'Tesler',
    'I/O Utilities',
    'IO Tesler API'
);
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (21, 7, 'user36', 'Комментарий к IO Tesler API #1');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (22, 7, 'user90', 'Комментарий к IO Tesler API #2');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (23, 7, 'user49', 'Комментарий к IO Tesler API #3');

-- Artifact and comments 9: --
INSERT INTO artifacts(id, created, user_id, category, description) VALUES (
    8,
    '2020-02-01 23:09:15',
    'Spring.io',
    'Security Frameworks',
    'Spring Security Core'
);
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (24, 8, 'user62', 'Комментарий к Spring Security Core #1');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (25, 8, 'user06', 'Комментарий к Spring Security Core #2');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (26, 8, 'user97', 'Комментарий к Spring Security Core #3');

-- Artifact and comments 10: --
INSERT INTO artifacts(id, created, user_id, category, description) VALUES (
    9,
    '2020-02-25 18:58:16',
    'JetBrains',
    'Kotlin core',
    'Kotlinx Serialization Runtime'
);
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (27, 9, 'user62', 'Комментарий к Kotlinx Serialization Runtime #1');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (28, 9, 'user06', 'Комментарий к Kotlinx Serialization Runtime #2');
INSERT INTO commentaries (id, artifact_id, user_id, content) VALUES (29, 9, 'user97', 'Комментарий к Kotlinx Serialization Runtime #3');