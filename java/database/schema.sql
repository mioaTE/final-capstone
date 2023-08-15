BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, post, likes, event CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id),
	email varchar (255),
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
	UPDATE post SET post_likes = (SELECT COUNT(likes.post_id) FROM likes WHERE post.post_id = likes.post_id);
);

CREATE TABLE likes(
	post_id INT NOT NULL,
	user_id INT NOT NULL,

	CONSTRAINT FK_post FOREIGN KEY (post_id) REFERENCES post(post_id),
	CONSTRAINT FK_user FOREIGN KEY (user_id) REFERENCES users(user_id)
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


