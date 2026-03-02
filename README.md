# 📧 Email Service Automation - Spring Boot

Este projeto é um microsserviço de automação para envio de e-mails, desenvolvido com **Java 21**, **Spring Boot 3** e **Jakarta Mail**. A aplicação foi construída focando em escalabilidade, desacoplamento e segurança de protocolo.

---

## 🏗️ Arquitetura do Projeto

O projeto utiliza o padrão de **Arquitetura Hexagonal (Ports & Adapters)**. Esse design permite que a lógica de negócio seja independente de tecnologias externas (como o Gmail ou AWS SES).



### Componentes Principais:
* **Core (Domínio):** Contém os Records (`EmailRequest`) e as interfaces de Caso de Uso (`SenderEmailUseCase`).
* **Application (Service):** A classe `EmailSenderService` orquestra a lógica de envio.
* **Infrastructure (Adapters):** * **Porta (Interface):** `EmailSenderGateway` define o contrato de envio.
    * **Adaptador (Implementação):** `SesEmailSender` realiza a integração real com o servidor SMTP.
* **Controller:** Expõe o endpoint REST para integração com outros sistemas ou ferramentas como Postman.

---

## 🛠️ Conceitos Técnicos Aplicados

### 1. Inversão de Dependência (SOLID)
Aplicamos o princípio de inversão de dependência onde o serviço de aplicação depende de uma abstração (`EmailSenderGateway`) e não de uma implementação concreta. Isso facilita a troca de provedores de e-mail sem alterar o código principal.

### 2. Segurança de Protocolo (SSL/TLS)
Configuramos a aplicação para utilizar **SSL Implícito na porta 465**. Diferente da porta 587 (STARTTLS), a 465 exige que a conexão seja criptografada desde o primeiro "aperto de mão" (handshake).



### 3. Troubleshooting: O desafio do erro [EOF]
Durante o desenvolvimento, identificamos que o servidor do Gmail encerrava a conexão (`EOF`) devido ao nome do host do Windows conter caracteres especiais (como o "ã" em João). 
* **Solução:** Forçamos o parâmetro `mail.smtp.localhost=localhost` nas propriedades do Spring Mail para garantir compatibilidade universal com o protocolo SMTP.

---

## 🚀 Como Executar e Testar

### Pré-requisitos
* Java 17 ou superior.
* Maven.
* Uma **Senha de App** do Google (não use sua senha comum).

### Configuração (`application.properties`)
```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=465
spring.mail.username=seu-email@gmail.com
spring.mail.password=sua-senha-de-app

spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.ssl.enable=true
spring.mail.properties.mail.smtp.ssl.trust=smtp.gmail.com
spring.mail.properties.mail.smtp.localhost=localhost
