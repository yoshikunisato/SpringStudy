# SpringStudy

### Spring Frameworkの自習用サンプル
#####環境：
#####Eclipse neon.2(J2EE) + STS
#####PostgreSQL 
自分のメモ  
PostgreSQLのスキーマ  

```SQL
CREATE TABLE users
(
  id integer NOT NULL,
  name character varying(40),
  CONSTRAINT pk_id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
```
