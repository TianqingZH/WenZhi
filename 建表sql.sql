CREATE DATABASE wenzhi;
USE wenzhi;
CREATE TABLE member(
	#id ,用户标识id,密码，昵称，性别，头像，签名，创建时间
	id INT(5) NOT NULL AUTO_INCREMENT,
	mem_id VARCHAR(20) NOT NULL,
	pass  VARCHAR(20) NOT NULL,
	nickname VARCHAR(20) NOT NULL,
	sex VARCHAR(2) NOT NULL DEFAULT '男',
	tx BLOB NOT NULL,
	sig VARCHAR(20) DEFAULT '0',
	mctime DATETIME NOT NULL,
	PRIMARY KEY(id),
	UNIQUE (mem_id)
	
);

CREATE TABLE topic(
	#id，主题id,创建时间，修改时间，用户id
	id INT(5) NOT NULL AUTO_INCREMENT,
	top_id VARCHAR(20) NOT NULL,
	ctime DATETIME NOT NULL,
	mtime DATETIME,
	mem_id VARCHAR(20) NOT NULL,
	PRIMARY KEY(id),
	UNIQUE (top_id)
);


CREATE TABLE answer(
	#id，回答id，赞数，评论，评论数，创建时间，用户id,主题id
	id INT(20) NOT NULL AUTO_INCREMENT,
	answer_id VARCHAR(20) NOT NULL,
	zan INT(4) NOT NULL DEFAULT '0',
	com VARCHAR(20) ,
	comCount INT(4) NOT NULL DEFAULT '0',
	ctime DATETIME NOT NULL,
	mem_id VARCHAR(20) NOT NULL,
	top_id VARCHAR(20) NOT NULL,
	PRIMARY KEY(id),
	UNIQUE(answer_id)
);


#topic表外键约束,设置非主键的外键约束需要将该字段设置为unique
ALTER TABLE `topic`
ADD CONSTRAINT `topic1` FOREIGN KEY (`mem_id`) REFERENCES `member` (`mem_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

#回答表外键约束
ALTER TABLE `answer`
ADD CONSTRAINT `answer1` FOREIGN KEY (`mem_id`) REFERENCES `member` (`mem_id`)ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `answer`
ADD CONSTRAINT `answer2` FOREIGN KEY (`top_id`) REFERENCES `topic` (`top_id`)ON DELETE NO ACTION ON UPDATE NO ACTION;