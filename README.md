# android-database
### An android application using SQLite Database.

Main activity has the buttons for the following operations:
Create, Insert, Update, Delete, Retrieve, Retrieve All.

1. On clicking Create Button, a new database is created to store the Product details. (SQLite Database)

a. Product ID (primary key)

b. Product Name

c. Product Brand

d. Description

e. Product Price

2. On Clicking Insert, moving to a new view which contains the following details: (Insert new Product to the database)

a. Product ID (EditText-Validation checking- 4 digit Numbers)

b. Product Name (Spinner)

c. Product Brand (RadioButton)

d. Description (EditText-Alphanumeric characters)

e. Product Price (EditText-Validation checking Numbers)

f. Submit (Button) – On click, the data is inserted into the database.

3. On clicking Update, moving to a new view which contains above details and Product Price is updated using Product ID.
 
4. On clicking Delete, deleting the whole row in the table by Product ID.

5. On clicking Retrieve, retrieving the product using Product ID.

6. On clicking Retrieve All, retrieving the details of all the products in a particular brand.
