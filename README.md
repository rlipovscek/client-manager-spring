# Claro - Client manager

Api para gestão de clientes

### Rodar o projeto local
  Instalar dependencias:
  `$ mvn clean install`  
  
  Rodar o projeto:
  `$ mvn spring-boot:run`
  
  Rodar apenas os testes:
   `$ mvn test` 
   
## rodar via docker

   Criar pacote (caso não tenha rodado os comandos anteriores):
  `$  mvn clean package`  
  
  Criar a imagem:
  `$ docker build -t client-manager-claro:v1 .` 
  
   Criar o container:
  `$ docker run -d -p 8092:8092 client-manager-claro:v1` 
  
## rodar via docker-compose
  Rodar o comando:
  `$ docker-compose up -d --build` 
  

### Documentação
[Swagger](http://localhost:8092/swagger-ui.html#/)

`http://localhost:8092/swagger-ui.html`

### Health check
 O projeto utiliza o actuator do spring para o monitoramento do estado do microservice, para verificar o estádo utilize o seguinte link:
 [health](http://localhost:8092/actuator/health)
 
 `http://localhost:8092/actuator/health`
 
  [actuator](http://localhost:8092/actuator) 
  `http://localhost:8092/actuator`
 
### Criação do banco de dados

 O projeto utiliza uma base h2, a mesma sobe assim que o projeto roda.
 [painel do h2](http://localhost:8092/h2-console)
	
	para acessar o painel administrativo utilize os seguintes dados:
	usuário: sa
	senha: password

    
	
