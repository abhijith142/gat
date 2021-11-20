CREATE table Book(
 isbn varchar(100) Primary Key,
 bookName varchar(100) NOT NULL,
 pub_id varchar(100) NOT NULL,
 Foreign Key(pub_id) references Publisher(id)
)

CREATE table Publisher(
    id varchar(100) Primary Key,
    publisherName varchar(100) NOT NULL
)