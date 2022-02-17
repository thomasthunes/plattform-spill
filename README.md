# INF112 libGDX + Maven template 
Simple skeleton with [libGDX](https://libgdx.com/). See the tutorial in [Filer / Tutorials](https://mitt.uib.no/courses/33532/files/folder/Tutorials) on Mitt UiB. 


# Maven Setup
This project comes with a working Maven `pom.xml` file. You should be able to import it into Eclipse using *File → Import → Maven → Existing Maven Projects* (or *Check out Maven Projects from SCM* to do Git cloning as well). You can also build the project from the command line with `mvn clean compile` and test it with `mvn clean test`.

Pay attention to these folders:
* `src/main/java` – Java source files go here (as usual for Maven)
* `src/main/resources` – data files go here, for example in an `assets` sub-folder
* `src/test/java` – JUnit tests
* `target/classes` – compiled Java class files

You should probably edit the `pom.xml` and fill in details such as the project `name` and `artifactId`:


```xml

	< !-- FIXME - set group id -->
	<groupId>inf112.skeleton.app</groupId>
	< !-- FIXME - set artifact name -->
	<artifactId>gdx-app</artifactId>
	<version>1.0-SNAPSHOT</version>
	<packaging>jar</packaging>

	< !-- FIXME - set app name -->
	<name>mvn-app</name>
	< !-- FIXME change it to the project's website -->
	<url>http://www.example.com</url>
```

	
## Running
You can run the project from Eclipse, or with Maven using `mvn exec:java`. Change the main class by modifying the `main.class` setting in `pom.xml`:

```
		<main.class>inf112.skeleton.app.Main</main.class>
```

If you run `mvn package` you'll get a everything bundled up into a JAR file
* `target/*.jar` – your compiled project, packaged in a JAR file

## Jar Files

If you run `mvn package` you get everything bundled up into a `.jar` file + a ‘fat’ Jar file where all the necessary dependencies have been added:

* `target/NAME-VERSION.jar` – your compiled project, packaged in a JAR file
* `target/NAME-VERSION-fat.jar` – your JAR file packaged with dependencies

Run Jar files with, for example, `java -jar target/javafx-app-1.0-SNAPSHOT-fat.jar`.

## Eclipse Setup

It's usually smart to change Eclipse's Maven settings so that it'll automatically download Javadocs and the source code for your dependencies:

![Turn on Download Sources and Javadoc](https://git.app.uib.no/inf112/22v/lectures/-/raw/master/img/eclipse-maven.png)


Markdown guide: https://docs.gitlab.com/ee/user/markdown.html

# Obligatorisk oppgave 1

# Introduksjon

[[_TOC_]]

# 1. Organisering av teamet
I denne delen av oppgaven vil vi gjennomgå (1) en kartlegging av gruppens kompetanse, (2) en rollefordeling mellom gruppens medlemmer og (3) et project board som gir oversikt på prosjektets status.  

## 1.1 Kartlegging av kompetanse  
Følgende komtanse er kartlagt mellom gruppens medlemmer: (kan endre/legge til mer på denne)
| Navn  | Kompetanse programmering |
|---|---|
| Thomas | Java, Python, SQL |
| Magnus | Java, Python, SQL |
| Karl | Java, Python, SQL |
| Jonas | Java, Python, SQL |
| Jon | Python |

## 1.2 Roller  
Som utgangspunkt for rollefordelingen har vi valgt å tildele roller basert på hvilke ansvarsområder vi har behov for å dekke. Rollefordelingen er også basert på kompetansen som vi har kartlagt i 1.1. Følgende roller er fordelt på gruppens medlemmer:  

| Navn  | Rolle | Begrunnelse |
|---|---|---|
| Thomas | Teamleader | Teamleder har oversikt på hele uviklingsprosessen. Dette er viktig for at prosjektet og gruppen skal ha den progresjonen som kreves til hver innlevering. |
| Magnus | Prosjektansvarlig | Prosjektansvarlig har ansvar for å sørge for at prosjektet følger standarden og kravene som er gitt i oppgaven, og de forventningene som gruppen har formulert under deloppgave 3. Dette er viktig for å unngå at vi glemmer enkelte implementasjoner ved spillet eller gjør implementasjoner som er feil.  |
| Karl | Scrum Master | Scrum Master har ansvar for å følge opp prosjektmetodikken som står beskrevet i deloppgave 2.1. Dette er viktig for å sikre en effektiv og oversiktlig utviklingsprosess. |
| Jonas | Testansvarlig | Testansvarlig tester kode og ser om den fungerer uten feil og bugs. Å skrive gode tester er viktig for å sikre at prosjektet holder en viss kvalitet, og at spillet innfrir de krav og forventninger som stilles. Testene er også viktig for å sikre at spillet ikke mister viktig funksjonalitet etter hvert som det utvikles og endres ved fremtidige innleveringer.  |
| Jon | Kundekontakt | Kundekontakten opprettholder tett kontakt med kunden, slik at produktet holder seg innenfor avtalt rammeverk. God kundekontakt muliggjør at spillet bedre kan tilpasses kundens ønske og behov, slik at sluttresultatet blir best mulig.  |

## 1.3 Project Board
Project Board viser oversikt på prosessen i prosjektet og arbeidsoppgavene. Den er delt inn i fire lister:
1. **Spørsmål til neste møte:** Neste møtetidspunkt spesifiseres her. Eventuelle spørsmål/saker som bør gjennomgås på møtet kan legges til i denne kategorien.  
2. **Backlog:** Alle funksjonaliteter ved spillet som kan/skal implementeres plasseres i kø her. Når vi begynner å jobbe med en gitt funksjonalitet i denne køen flyttes den over til "Pågående".  
3. **Pågående/Sprint:** Oppgaver som jobbes med i den pågående iterasjonen plasseres her. Dette gjelder spesielt nært forestående arbeid. Tidsfrist og hvem som arbeider med oppgaven kan også tagges på hver oppgave.  
4. **Fullført:** Fullførte arbeidsoppgaver flyttes over hit etter hvert som de blir ferdig.  

Bilde:  
![alt text](img/projectBoard.png)
Link: https://trello.com/b/phyvJKO5/project-board 


# 2. Prosess for laget
I denne delen av oppgaven vil vi gjennomgå hvilken prosess for laget som vi har valgt (2.1), og hvordan vi ønsker å organisere prosjektet (2.2).  

## 2.1 Prosjektmetodikk
For å finne frem fram til en passende prosjektmetodikk har vi diskutert ulike hensyn og metoder som vi mener vil være viktig for å utvikle en velfungerende og godt dokumentert programvare. For det første fant vi det viktig å ha et rammeverk som legger til rette for intensive arbeidsøkter over flere iterasjoner. Dette mener vi er viktig ettersom prosjektet vil foregå over totalt 4 innleveringer, der det skal legges til ny funksjonalitet til hver innlevering. Videre ønsket vi også å ha en prosjektmetodikk som legger til rette for at prosjektet kan tilpasses endrede kundebehov underveis i utviklingsprosessen. Dette mener vi er en viktig forutsetning for at det ferdige produktet imøtekommer de krav og forventninger som kunden måtte ha. Til sist fant vi det også viktig å ha en prosjektmetodikk som sikrer god kvalitet i koden med lite feil. Dette er også viktig da oppgaveteksten krever grundig testing for å sikre god kvalitet. Basert på disse drøftelsene fant vi det hensiktsmessig å bruke Scrum-rammeverket som vår proskektmetodikk. Dette rammeverket favner om nettopp disse hensynene for programvareutvikling. I neste avsnitt vil vi kort gjennomgå de viktigste hovedtrekkene i Scrum-rammeverket.  

### 2.1.1 Scrum
Scrum-rammeverket er en arbeidsmetodikk som brukes til å utvikle, levere og opprettholde produkter. Det bryter ned arbeidet i mindre sprintkøer med spesifikke mål som skal fullføres innenfor en gitt tidsperiode, som oftest to uker. Medlemmene i utviklingsteamet velger en arbeidsoppgavene fra sprintkøen og setter den til ferdig når oppgaven er fullført. På denne måten blir ansvar fordelt og de tilgjengelige ressursene i gruppen godt utnyttet. Underveis holdes det teammøter der medlemmene deler hvor langt de er kommet, hva som gjenstår og hvilke eventuelle utfordringer som står i veien for å fullføre arbeidsoppgaven. En fordel med  teammøtene er at gruppen oppnår effektiv kommunikasjonsflyt som sikrer god oversikt, samt muliggjør tidlig identifisering av eventuelle utfordringer. Mot slutten av sprinten avholdes det et sprint review møte der en evalurer det foreløpige arbeidet som er ferdig, og foretar vurderinger på om det er ytterligere oppgaver som bør legges til og fullføres innenfor den samme sprinten. Dette er viktig ettersom sentrale idéer til implementasjoner ofte kan komme underveis mens en jobber med en oppgave. Til slutt avholdes det et retrospektivt møte for å identifisere hva som gikk bra under denne sprinten og mulige forbedringspotensialer til neste sprint. Dersom det er nødvendig settes det også opp en tiltaksplan for å utnytte forbedringspotensialene til neste sprint.  

Kilde:  
 - https://www.visma.no/blogg/en-kort-introduksjon-til-scrum/ 
 - https://no.wikipedia.org/wiki/Scrum 

## 2.2 Organsiering av prosjektet  


# 3. Forventet produkt
## 3.1 Produktspesifikasjon

## 3.2 Brukerhistorier
### 3.2.1 2D spillbrett

### 3.2.2 Vegger

### 3.2.3 Blokker

### 3.2.4 Spiller


# 4. Kode
## 4.1 

# 5. Oppsummering


