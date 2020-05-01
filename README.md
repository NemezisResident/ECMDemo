# ECMDemo
Заготовка система документооборота

used technologies:

multi modules project,
Docker,
Spring Boot,
Spring Data (JpaRepository),
Orika mapper mapping,
HATEOAS (links) dynamic URL,
RestTemplate Rest integration (client module),
Swagger interface for test, 
Mysql DB,
Hibernate,
java 8 features,
Lombok, 


   При сборке приложения mvn clean package - docker скачает образ mysql, настроит переменные окружения 
и запустит контейнер из него наполнив данными из скрипта setup.sql.


   When building the mvn clean package application - docker downloads the mysql image, sets up environment variables
and start the container from it by filling in the data from the setup.sql script.