## Prerequisitos
Para poder iniciar la aplicaccion se debe tener instalado docker y docker-compose

## Tecnologias Utilizadas

- DevOps
    - Docker & Docker-compose
- Aplicacion
    - JDK 11
    - Apache Maven 3.3.9
- IDE
    - Intellij 2020
- Servidores de BD
    - Mongo DB
- Infraestructura
    - NGINX como balanceador de carga
    
La arquitectura de la aplicacion esta compuesta armada en un docker compose el cual levanta
4 replicas del backend, 1 base de datos Mongo y un NGINX como reverse proxy para 
balancear la carga.
    
### Conventional commits

Para este proyecto se uso la metodologia de conventional commits. [Abrir](https://www.conventionalcommits.org/en/v1.0.0/) 

## Cobertura Testing

![coverage](https://i.imgur.com/a95aIcE.png)

Decisiones: Dado que no contamos con un proceso de CI/CD al levantar la app omitimos los tests,
 idealmente deberiamos contar con una pipeline que corra los tests antes de buildear la imagen de docker.

## Deploy local

- Para correr el proyecto local (linux):
```bash
   someone@# git clone https://github.com/eric-stoppel/mutants.git
   someone@# cd mutants
   someone@# sh deploy.sh
```

## Decisiones de diseño

1. Las credenciales de la base de datos estan en el application.properties, lo ideal seria
 que no se pusheen al repo, para esto deberiamos usar variables de entorno.

2. En caso de existir distintos tipos de mutantes en un futuro se puede crear una interfaz MutantServiceInterface y 
realizar implementaciones sobre esta, al ser el dominio acotado no fue necesario.

## Servicios cloud

La api fue hosteada en heroku y la base de datos en un cluster de Atlas 

- Base url: https://ericstoppel-mutants.herokuapp.com
    - Endpoints
        - [GET] /mutant/stats <br><br>
        curl  --request GET \
          https://ericstoppel-mutants.herokuapp.com/mutant/stats <br><br>
        - [POST] /mutant  <br><br>
        curl --header "Content-Type: application/json" \
                                  --request POST \
                                  --data '{"dna": [ "GTGCAA","CAGTGC","TTATGT","AGAAGG","CCACTA", "TCACTG"]}' \
                                  https://ericstoppel-mutants.herokuapp.com/mutant
            