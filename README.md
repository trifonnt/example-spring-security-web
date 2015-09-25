### Create MySQL database
```shell
$ mysql -u root -p
```

```sql
CREATE DATABASE IF NOT EXISTS userexample
 DEFAULT CHARACTER SET = utf8
;
```

### Create MySQL user
```shell
$ mysql -u root -p
```
```sql
GRANT ALL ON userexample.* TO 'userexample'@'localhost' IDENTIFIED BY 'userexample';
```


### Execute SQL file
```shell
$ mysql -u userexample -p
```

```sql
mysql> use userexample;
mysql> source src/main/sql/create.mysql.sql
mysql> source src/main/sql/insert.mysql.sql
```


## Start Spring Boot application
$ mvn clean install spring-boot:run


## Open Browser
 - http://localhost:8080/login

