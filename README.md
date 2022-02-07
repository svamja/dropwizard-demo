# Dropwizard Demo (JDBI 3, ReactJS, Pagination, Master-Detail)

A Dropwizard demo to demonistrate JDBI 3, ReactJS, Pagination and Master-Detail relations

## Getting Started

After cloning..

1. Run `mvn clean install` to build your application
1. Update `config.yml` database section as per your database connection.
1. Create a database named `dropwizard`.
1. Start application with `java -jar target/PaginationDemo-1.0.jar`
1. Visit url `http://localhost:8080`

## Concepts

* ReactJS is used for the front-end
* Complete ReactJS source is served using assets bundler from reso`urces/assets` folder
* Database is any configurable RDBMS (tested with MySQL)
* Database access layer is written using JDBI 3
* Master-detail (or Primary Foreign key) relation is explored using `Order` and `OrderItem` entities
* Simple create and listing operations are done on Master Detail entities
* Very basic paginatioin demonstrated using query parameter
* Dropwizard Command is used to demonstrate backend tasks like dropping all tables or runnings simple aggregation (see below)

### Tasks

To wipe tables `orders` and `order_items` created by this demo project

    java -jar target/PaginationDemo-1.0.jar drop config.yml

To run a simple aggregation of total values on `orders` table using detail `order_items` table.

    java -jar target/PaginationDemo-1.0.jar total config.yml


## References

Command used to create this project

    mvn archetype:generate \
        -DgroupId=com.example \
        -DartifactId=PaginationDemo \
        -Dname=PaginationDemo \
        -Dpackage=com.example.pagination \
        -DarchetypeGroupId=io.dropwizard.archetypes \
        -DarchetypeArtifactId=java-simple \
        -DinteractiveMode=false

**Dropwizard References**

https://www.dropwizard.io/en/latest/

https://www.dropwizard.io/en/latest/manual/core.html#commands

https://www.dropwizard.io/en/latest/manual/jdbi3.html

https://spin.atomicobject.com/2014/10/11/serving-static-assets-with-dropwizard/


**React References**

https://reactjs.org/docs/add-react-to-a-website.html

https://reactjs.org/docs/faq-ajax.html





