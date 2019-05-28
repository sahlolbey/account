create database sample_bank; -- Create the new database
create user 'sbank'@'localhost' identified by 'mypass@123'; -- Creates the user
grant all on sample_bank.* to 'sbank'@'localhost'; -- Gives all the privileges to the new user on the newly created database