CREATE TABLE ecm.users (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, fio VARCHAR(300), role VARCHAR(100));
insert into ecm.users (fio, role) values ('Nemezis Resident', 'admin');
insert into ecm.users (fio, role) values ('Anna SW', 'user');

CREATE TABLE ecm.doc_type (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, type VARCHAR(300), text VARCHAR(1000));
insert into ecm.doc_type (type, text) values ('leave_request', 'Прошу предоставить мне очередной оплачиваемый отпуск с data1 на n календарных дней');
insert into ecm.doc_type (type, text) values ('material_support_request', 'Прошу оказать мне материальную помощь на основании n причины');

CREATE TABLE ecm.documents (id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 doc_type INT,
 data1 Date,
 data2 Date,
 user INT,
 FOREIGN KEY (doc_type) REFERENCES doc_type(id),
 FOREIGN KEY (user) REFERENCES users(id)
 );

 insert into ecm.documents (doc_type, data1,user) values (1, '2020-04-17',1);
 insert into ecm.documents (doc_type, data1,user) values (2, '2020-04-18',1);
 insert into ecm.documents (doc_type, data1,user) values (1, '2020-04-17',2);
 insert into ecm.documents (doc_type, data1,user) values (2, '2020-04-18',2);