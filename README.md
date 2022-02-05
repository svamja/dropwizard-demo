# Dropwizard Demo with Pagination, jOOQ, ReactJS

## Getting Started

After cloning..

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/PaginationDemo-1.0.jar`
1. Visit url `http://localhost:8080`

## Concepts

* ReactJS is used for the front-end
* Complete ReactJS source is served using assets bundler from resources/assets folder

TBD -
* Database is Postgresql
* Database access layer is written using jOOQ
* Dropwizard Command is used to write a backend task to perform aggregation
* The task "update_readme" uses MarkdownPapers to convert this `readme.md` to `index.html`, which is served as the landing page of this application.

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

Dropwizard References

https://www.dropwizard.io/en/latest/

https://spin.atomicobject.com/2014/10/11/serving-static-assets-with-dropwizard/


React References

https://reactjs.org/docs/add-react-to-a-website.html

https://reactjs.org/docs/faq-ajax.html





