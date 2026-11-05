-- Execute este arquivo no MySQL Workbench ou no terminal MySQL.
CREATE DATABASE IF NOT EXISTS brassaria_db
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE brassaria_db;
-- As tabelas bebidas e eventos são criadas/atualizadas pelo Hibernate
-- quando a aplicação Spring Boot inicia (spring.jpa.hibernate.ddl-auto=update).
