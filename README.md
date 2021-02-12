# app-pass-validator
Api para validação de senha

## Requisitos
Para realizar o build e executar a aplicação será necessário:

- [JDK 1.11](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Maven 3](https://maven.apache.org)

## Executando a aplicação localmente
```shell
mvn spring-boot:run
```

## Solução do problema 
Para deixar a validação mais simples de ser implementar, foi separado as validações cada uma respeitando sua responsabilidade.
Trambém foi criada uma classe abstrata base, para implementar as regras de validação.

