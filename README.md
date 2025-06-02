# Spring Pojištění – Závěrečný projekt

Tento projekt je jednoduchá webová aplikace pro správu pojištěnců a jejich pojištění, vytvořená pomocí Java a Spring Boot. Slouží jako závěrečný projekt programátorského kurzu.

##  Použité technologie

- Java 17+
- Spring Boot
- Spring MVC
- Thymeleaf
- Bootstrap
- HTML & CSS
- MariaDB / MySQL
- Maven

##  Funkcionality

- Přidání, úprava a mazání pojištěnců
- Přehled a detail pojištění každého klienta
- Validace vstupních dat ve formulářích
- Navigace přes fragmenty (hlavička, patička)
- DTO vrstva pro přenos dat
- Oddělení frontend a backend logiky

##  Jak aplikaci spustit

### 1. Klonování repozitáře

```bash
git clone https://github.com/Luban1990/SpringPojisteniProjekt.git
cd SpringPojisteniProjekt

2. Otevření projektu
Otevři projekt v IDE (např. IntelliJ IDEA)

Ujisti se, že máš nainstalovanou Javu (doporučeno Java 17)

Spusť aplikaci přes PojisteniProjektApplication.java

3. Nastavení databáze
Vytvoř si databázi v MariaDB/MySQL s názvem např. pojisteni

Nastav přístupové údaje v application.properties:


spring.datasource.url=jdbc:mysql://localhost:3306/pojisteni
spring.datasource.username=uzivatel
spring.datasource.password=heslo
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true


4. Otevření v prohlížeči
Po spuštění najedeš na http://localhost:8080

 Autor
Lubomír Čipčala
📍 Ústí nad Orlicí
📧 cipcala1@gmail.com
📞 605 916 101
LinkedIn

 Poznámka
Tento projekt je ukázkou schopností v oblasti Java backend vývoje s použitím Spring Boot frameworku. Nejedná se o produkční aplikaci.
