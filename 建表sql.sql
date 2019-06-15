﻿CREATE DATABASE wenzhi;
USE wenzhi;
CREATE TABLE member(
	#id ,用户标识id,密码，昵称，性别，头像，签名，创建时间
	id INT(5) NOT NULL AUTO_INCREMENT,
	memId VARCHAR(20) NOT NULL,
	pass  VARCHAR(20) NOT NULL,
	nickname VARCHAR(20) NOT NULL,
	sex VARCHAR(2) NOT NULL DEFAULT '男',
	tx BLOB NOT NULL,
	sig VARCHAR(20) DEFAULT '0',
	mctime DATETIME NOT NULL,
	PRIMARY KEY(id),
	UNIQUE (memId)
	
);

CREATE TABLE topic(
	#id，主题id,创建时间，修改时间，用户id
	id INT(5) NOT NULL AUTO_INCREMENT,
	topId VARCHAR(20) NOT NULL,
	ctime DATETIME NOT NULL,
	mtime DATETIME,
	memId VARCHAR(20) NOT NULL,
	PRIMARY KEY(id),
	UNIQUE (topId)
);


CREATE TABLE answer(
	#id，回答id，赞数，评论，评论数，创建时间，用户id,主题id
	id INT(20) NOT NULL AUTO_INCREMENT,
	answerId VARCHAR(20) NOT NULL,
	zan INT(4) NOT NULL DEFAULT '0',
	com VARCHAR(20) ,
	comCount INT(4) NOT NULL DEFAULT '0',
	ctime DATETIME NOT NULL,
	memId VARCHAR(20) NOT NULL,
	topId VARCHAR(20) NOT NULL,
	PRIMARY KEY(id),
	UNIQUE(answerId)
);


#topic表外键约束,设置非主键的外键约束需要将该字段设置为unique
ALTER TABLE `topic`
ADD CONSTRAINT `topic1` FOREIGN KEY (`memId`) REFERENCES `member` (`memId`) ON DELETE NO ACTION ON UPDATE NO ACTION;

#回答表外键约束
ALTER TABLE `answer`
ADD CONSTRAINT `answer1` FOREIGN KEY (`memId`) REFERENCES `member` (`memId`)ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE `answer`
ADD CONSTRAINT `answer2` FOREIGN KEY (`topId`) REFERENCES `topic` (`topId`)ON DELETE NO ACTION ON UPDATE NO ACTION;