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
| Magnus | Prosjektansvarlig | Prosjektansvarlig har ansvar for å sørge for at prosjektet følger standarden og kravene som er gitt i oppgaven, og de forventningene som gruppen har formulert under deloppgave 3. Dette er viktig for å unngå at vi glemmer enkelte implementasjoner ved spillet eller gjør implementasjoner som er feil. |
| Karl | Scrum Master | Scrum Master har ansvar for å følge opp prosjektmetodikken som står beskrevet i deloppgave 2.1. Dette er viktig for å sikre en effektiv og oversiktlig utviklingsprosess. |
| Jonas | Testansvarlig | Testansvarlig tester kode og ser om den fungerer uten feil og bugs. Å skrive gode tester er viktig for å sikre at prosjektet holder en viss kvalitet, og at spillet innfrir de krav og forventninger som stilles. Testene er også viktig for å sikre at spillet ikke mister viktig funksjonalitet etter hvert som det utvikles og endres ved fremtidige innleveringer. |
| Jon | Kundekontakt | Kundekontakten opprettholder tett kontakt med kunden, slik at produktet holder seg innenfor avtalt rammeverk. God kundekontakt muliggjør at spillet bedre kan tilpasses kundens ønske og behov, slik at sluttresultatet blir best mulig. |

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
I denne delen av oppgaven vil vi gjennomgå (1) hvilken prosjektmetodikk vi har valgt, og (2) hvordan vi ønsker å organisere prosjektet.  

## 2.1 Prosjektmetodikk
For å finne frem fram til en passende prosjektmetodikk har vi diskutert ulike hensyn og metoder som vi mener vil være viktig for å utvikle en velfungerende og godt dokumentert programvare. For det første fant vi det viktig å ha et rammeverk som legger til rette for intensive arbeidsøkter over flere iterasjoner. Dette mener vi er viktig ettersom prosjektet vil foregå over totalt 4 innleveringer, der det skal legges til ny funksjonalitet til hver innlevering. Videre ønsket vi også å ha en prosjektmetodikk som legger til rette for at prosjektet kan tilpasses endrede kundebehov underveis i utviklingsprosessen. Dette mener vi er en viktig forutsetning for at det ferdige produktet imøtekommer de krav og forventninger som kunden måtte ha. Til sist fant vi det også viktig å ha en prosjektmetodikk som sikrer god kvalitet i koden med lite feil. Dette er også viktig da oppgaveteksten krever grundig testing for å sikre god kvalitet. Basert på disse drøftelsene fant vi det hensiktsmessig å bruke Scrum-rammeverket som vår proskektmetodikk. Dette rammeverket favner om nettopp disse hensynene for programvareutvikling. I neste avsnitt vil vi kort gjennomgå de viktigste hovedtrekkene i Scrum-rammeverket.  

### 2.1.1 Scrum
Scrum-rammeverket er en arbeidsmetodikk som brukes til å utvikle, levere og opprettholde produkter. Det bryter ned arbeidet i mindre sprintkøer med spesifikke mål som skal fullføres innenfor en gitt tidsperiode, som oftest to uker. Medlemmene i utviklingsteamet velger en arbeidsoppgavene fra sprintkøen og setter den til ferdig når oppgaven er fullført. På denne måten blir ansvar fordelt og de tilgjengelige ressursene i gruppen godt utnyttet. Underveis holdes det teammøter der medlemmene deler hvor langt de er kommet, hva som gjenstår og hvilke eventuelle utfordringer som står i veien for å fullføre arbeidsoppgaven. En fordel med  teammøtene er at gruppen oppnår effektiv kommunikasjonsflyt som sikrer god oversikt, samt muliggjør tidlig identifisering av eventuelle utfordringer. Mot slutten av sprinten avholdes det et sprint review møte der en evalurer det foreløpige arbeidet som er ferdig, og foretar vurderinger på om det er ytterligere oppgaver som bør legges til og fullføres innenfor den samme sprinten. Dette er viktig ettersom sentrale idéer til implementasjoner ofte kan komme underveis mens en jobber med en oppgave. Til slutt avholdes det et retrospektivt møte for å identifisere hva som gikk bra under denne sprinten og mulige forbedringspotensialer til neste sprint. Dersom det er nødvendig settes det også opp en tiltaksplan for å utnytte forbedringspotensialene til neste sprint.  

[Sette inn scrum-bilde her]

Kilde:
 - https://www.visma.no/blogg/en-kort-introduksjon-til-scrum/ 
 - https://no.wikipedia.org/wiki/Scrum 

## 2.2 Organsiering av prosjektet
For å organisere prodsjektet har vi vurdert følgende momenter:
 - **Møter og hyppighet av dem:** Møter planlegges etter nærmere behov. 
 - **Kommunikasjon mellom møter:** Kommunikasjon foregår i egen discord-kanal eller i Messenger-gruppe (facebook).
 - **Arbeidsfordeling:** Arbeidsfordelingen tar utgangspunkt i rollefordelingen i 1.2, og tilpasses ved behov. Vi ser for oss at mye av arbeidsfordelingen vil skje på første møte i starten av en ny sprint, men at dette kan tilpasses underveis dersom en ser at enkelte arbeidsoppgaver krever flere ressurser en først antatt. 
 - **Oppfølging av arbeid:** Vi planlegger for å ha ukentlige møter der vi kan følge hverandre opp på arbeidet, såkalt *sprint review* møter (se avsnitt 2.1.1). 
 - **Deling og oppbevaring av felles dokumenter, diagram og kodebase:** Her bruker vi egen gruppe på git til deling av all kode og rapport som tilhører prosjektet. Mindre filer kan også deles på kommunikasjonskanalene Messenger/Discord dersom dette er mer hensiktsmessig, men selve prosjektkoden lastes opp til felles git.
 - **Programvareutviklingsaktiviteter:** Aktiviteter relatert til programvareutvikling bestemmes på teammøtene. Dette ser vi for oss vil variere i omfang basert på hvilke oppgaver som ligger i sprintkøen. Ved spesielt vanskelige programmeringsoppgaver vil vi benytte parprogrammering der én person skriver kode mens den andre forteller hva som skal skrives. På denne måten involverer en flere personer til å løse vanskelige programmeringsoppgaver. 

# 3. Forventet produkt
I denne delen av oppgaven vil vi gjennomgå (1) produktspesifikasjoner og (2) brukerhistorier. Mens produktspesifikasjonen tar for seg det overordnede målet for applikasjonen, så vil brukerhistoriene utdype de ulike implementasjonene vi mener er viktig å ha med for å oppnå det overordnede målet.

## 3.1 Produktspesifikasjon
Det overordnede målet for applikasjonen er å utvikle et spill som kan spilles av flere spillere, og som fungerer på alle plattformer. I spillet vektlegger vi å ha en spillfigur som kan styres i en todimensjonal verden, fiender og hindringer for spilleren og muligheten til å plukke opp gjenstander for å samle poeng. Aspektene ved spillet utdypes nærmere i neste del av oppgaven. 

## 3.2 Brukerhistorier
Brukerhistorier er spesifikasjoner av konkrete implemtasjoner vi mener er viktig å ha med i applikasjonen. Disse spesifikasjonene muliggjør at rollene i prosjektet oppnår en felles forståelse for applikasjonen. I utformingen av brukerhistoriene har vi vektlagt funksjonalitet og nytteverdi. Brukerhistoriene er oppsummert i følgende tabell:  

--------
Format (fjernes før innlevering):
Brukeristorien (verdiforslaget): 
 - "Som rolle trenger jeg funksjonalitet for å oppnå nytteverdi. (bruker, funksjon, verdi)"
 - "få frem verdien og hvem som skal få den verdien"
 - "raskt kan få et overblikk over hva historien løser"

Løsningsbeskrivelse: 
 - "en enkel og spesifikk forklaring/oppsummering av hvordan en løser oppgaven"
 - "kan for eksempel bruke løsningsbeskrivelsen til å oppsummere akseptansekriteriene"

 Akseptansekriterier:
 - "skal fortelle utvikler og tester spesifikt hva som skal lages og testes"
 - "lite rom for tolkning"
 - "Hvert kriterium skal skrives på en slik måte at en kan bekrefte eller avkrefte om det er oppfylt."
--------

| Brukerhistorie  | Løsningsbeskrivelse | Akseptansekriterie |
|---|---|---|
| *2D spillbrett:* Som spiller ønsker jeg å se et spillbrett, slik at jeg kan orientere meg. | Når programmet kjøres vises et vindu med grafikk til spillebrettet. |  |
| *Spiller:* Som en utvikler (kan være spiller her?) ønsker jeg å kunne bevege spillebrikken i spillet med piltastene og space for å teste funksjonene til spillebrettet og se om disse fungere slik det skal. | Når en piltast trykkes beveges spillebrikken den retningen piltasten har blitt trykket, eller hvis man trykker på space skal spillebrikken hoppe. |  |
| *Vegger:* Som utvikler ønsker jeg vegger som skiller seg fra resten av spillebrettet, slik at jeg kan implementere funksjoner som sørger for at en spiller ikke kan bevege seg gjennom disse objektene. | Når en spiller beveger seg bort mot en vegg, kan den ikke gå videre gjennom veggen. |  |
| *Blokker:* Som utvikler ønsker jeg blokker som skiller seg fra resten av spillebrettet, slik at jeg kan implementere funksjoner som sørger for at en spiller ikke kan bevege seg gjennom disse objektene. | Når en spiller beveger seg mot en blokk, kan den ikke gå videre gjennom blokken, men den kan hoppe oppå blokken for å passere den. |  |
| *Fiender:* Som spiller ønsker jeg å spille mot fiender som prøver å drepe meg slik at det er en utfordring å komme til mål å vinne spillet. | Hvis en spiller kommer nær en fiende dør spilleren, så spilleren må bevege seg rundt fienden for å overleve |  |
| *Antall liv:* Som utvikler ønsker jeg å kunne gi forskjellig antall liv til spiller og fiender slik at spillet oppleves som underholdene og spennende for spilleren men ikke altfor vanskelig. | En spiller skal ha flere liv enn en fiende siden det er flere fiender enn spillere. |  |
| *Fiender/Hindringer:* Som spiller ønsker jeg å kunne drepe/kjempe mot fiender så det er elementer som prøver å stoppe meg på min vei til mål. | En spiller skal kunne drepe fiender og da skal disse fiendene forsvinne bort fra spillebrettet. |  |
|  |  |  |
|  |  |  |


### 3.2.1 2D spillbrett

### 3.2.2 Vegger

### 3.2.3 Blokker

### 3.2.4 Spiller

Kilde:
 - https://design.entur.org/kom-i-gang/for-designere/brukerhistorier

# 4. Kode
## 4.1 

# 5. Oppsummering


