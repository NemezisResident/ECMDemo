# Pull base image
FROM mysql:8

# Настраиваем переменные окружения
ENV MYSQL_ROOT_PASSWORD=123
ENV MYSQL_DATABASE=ecm
ENV MYSQL_USER=nemezis
ENV MYSQL_PASSWORD=123

ENV MYSQL_DATA_DIR=/var/lib/mysql \
    MYSQL_RUN_DIR=/run/mysqld \
    MYSQL_LOG_DIR=/var/log/mysql

# Копируем sql в папку для наполнения БД
COPY ./setup.sql /docker-entrypoint-initdb.d/
#COPY ./setup.sh /docker-entrypoint-initdb.d/
#RUN /mysql/setup.sh
