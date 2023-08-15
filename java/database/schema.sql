BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, post, likes, event CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
<<<<<<< HEAD
	CONSTRAINT PK_user PRIMARY KEY (user_id)
	email varchar (255)
=======
	CONSTRAINT PK_user PRIMARY KEY (user_id),
	email varchar (255),
>>>>>>> 81b31b297c76eca8cf1886516b1b4c97bbf9641a
	profile_name varchar (255)
);


CREATE TABLE post (
	post_id serial,
	user_id INT NOT NULL,
	post_description VARCHAR (100) NOT NULL,
	post_img VARCHAR (500) NOT NULL,
	post_likes INTEGER,
	created_on TIMESTAMP,

	CONSTRAINT PK_post PRIMARY KEY (post_id),
	CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE likes(
	post_id INT NOT NULL,
	user_id INT NOT NULL,

	CONSTRAINT FK_post FOREIGN KEY (post_id) REFERENCES post(post_id),
	CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE comments(
    comment_id serial,
    user_id INT NOT NULL,
    post_id INT NOT NULL,
    comment VARCHAR (500) NOT NULL,

    CONSTRAINT PK_comments PRIMARY KEY (comment_id),
    CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id),
    CONSTRAINT FK_post FOREIGN KEY (post_id) REFERENCES post(post_id)
);


GRANT ALL
ON ALL TABLES IN SCHEMA public
TO final_capstone_owner;
GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_owner;
GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO final_capstone_appuser;
GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO final_capstone_appuser;


COMMIT TRANSACTION;


