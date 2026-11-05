@echo off
chcp 65001 > nul
cd /d "%~dp0..\backend"
echo Baixando dependencias e compilando o projeto...
mvn clean install
pause
