@echo off
chcp 65001 > nul
cd /d "%~dp0..\backend"
echo Iniciando Brassaria Internacional - API Spring Boot...
mvn spring-boot:run
pause
