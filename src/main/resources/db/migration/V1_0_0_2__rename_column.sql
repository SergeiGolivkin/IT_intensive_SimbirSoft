ALTER TABLE publisher RENAME COLUMN firstname TO first_name;
ALTER TABLE publisher RENAME COLUMN lastname TO last_name;

ALTER TABLE author RENAME COLUMN publisherid TO publisher_id;
ALTER TABLE author RENAME COLUMN firstname TO first_name;
ALTER TABLE author RENAME COLUMN lastname TO last_name;

ALTER TABLE book RENAME COLUMN authorid TO author_id;
ALTER TABLE book RENAME COLUMN yearofpublishing TO year_of_publishing;