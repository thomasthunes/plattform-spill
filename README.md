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
 - **Oppfølging av arbeid:** Vi planlegger å ha ukentlige møter der vi kan følge hverandre opp på arbeidet, såkalt *sprint review*-møter (se avsnitt 2.1.1). 
 - **Deling og oppbevaring av felles dokumenter, diagram og kodebase:** Her bruker vi egen gruppe på git til deling av all kode og rapport som tilhører prosjektet. Mindre filer kan også deles på kommunikasjonskanalene Messenger/Discord dersom dette er mer hensiktsmessig, men selve prosjektkoden lastes opp til felles git.
 - **Programvareutviklingsaktiviteter:** Aktiviteter relatert til programvareutvikling bestemmes på teammøtene. Dette ser vi for oss vil variere i omfang basert på hvilke oppgaver som ligger i sprintkøen. Ved spesielt vanskelige programmeringsoppgaver vil vi benytte parprogrammering der én person skriver kode mens den andre forteller hva som skal skrives. På denne måten involverer en flere personer til å løse vanskelige programmeringsoppgaver. 

# 3. Forventet produkt
I denne delen av oppgaven vil vi gjennomgå (1) produktspesifikasjoner og (2) brukerhistorier. Mens produktspesifikasjonen tar for seg det overordnede målet for applikasjonen, så vil brukerhistoriene utdype de ulike implementasjonene vi mener er viktig å ha med for å oppnå det overordnede målet.

## 3.1 Produktspesifikasjon
Det overordnede målet for applikasjonen er å utvikle et spill som kan spilles av flere spillere, og som fungerer på alle plattformer. I spillet vektlegger vi å ha en spillfigur som kan styres i en todimensjonal verden, fiender og hindringer for spilleren og muligheten til å plukke opp gjenstander for å samle poeng. Aspektene ved spillet utdypes nærmere i neste del av oppgaven. 

## 3.2 Brukerhistorier
Brukerhistorier er spesifikasjoner av konkrete implemtasjoner vi mener er viktig å ha med i applikasjonen. Disse spesifikasjonene muliggjør at rollene i prosjektet oppnår en felles forståelse for applikasjonen. I utformingen av brukerhistoriene har vi vektlagt funksjonalitet og nytteverdi. Videre har vi satt opp akseptansekriterier som spesifiserer hvilke egenskaper applikasjonen må ha for å imøtekomme kravene gitt i brukerhistorien. Til sist har vi satt opp arbeidsoppgaver som spesifiserer hvilke metoder som må implementeres i koden for å imøtekomme akseptansekriteriene, og hvordan ansvaret blir fordelt til de ulike arbeidsoppgavene. Brukerhistoriene, akseptansekriteriene og arbeidsoppgavene er oppsummert i tabellen under. Etter tabellen følger det også en prioritert liste over hvilke brukerhistorier vi ønsker å ha med i første sprint/iterasjon.    


| Brukerhistorier  | Akseptansekriterier | Arbeidsoppgaver |
|---|---|---|
| **2D spillebrett:** Som spiller ønsker jeg å se et spillebrett, slik at jeg kan orientere meg. | **Krav:** Vise et 2D spillebrett.  **Kriterie:** Når programmet kjøres vises et vindu med grafikk til spillebrettet. | For å imøtekomme akseptansekriteriene må klassen *Play* implementeres. Denne klassen implementerer interfacet *Screen*. Videre så vil klassen *Play* sørge for at når koden kjøres så vil et map rendres, sette posisjonen til en spiller (spilleren kommer fra klassen *Player*) og sette opp *Orthographic camera* som følger skjermen. |
| **Spiller:** Som utvikler ønsker jeg å kunne bevege spillebrikken i spillet med piltastene og space for å teste funksjonene til spillebrettet og se om disse fungerer slik det skal. | **Krav:** Spilleren må kunne bevege seg.  **Kriterie:** Når en piltast trykkes beveges spillebrikken den retningen piltasten peker, og dersom en trykker *space* skal spillebrikken hoppe. | For å imøtekomme akseptansekriteriene må klassen *Player* implementeres. Denne klassen utvider den abstrakte klassen *Sprite* fra LibGDX-biblioteket. I klassen *Player* vil en spiller opprettes som et objekt av typen *Player*. Videre vil feltvariablene *Speed*, *Gravity* og *Velocity* i klassen *Player* settes. Disse feltvariablene beskriver hvordan spilleren beveger seg med tanke på hurtighet (*Speed*), tyngdekraft (*Gravity*) og i hvilken retning (*Velocity*). Klassen *Player* vil også inneholde en metode *Update* som endrer på posisjonen til spiller-objektet avhenigig av verdien på feltvariabelen *Velocity*. *Update* sjekker også om spilleren treffer en celle som er *blocked*, og i så fall vil *Velocity* settes til 0. |
| **Vegger/blokker:** Som utvikler ønsker jeg vegger og blokker slik at jeg kan implementere funksjoner som sørger for at en spiller ikke kan bevege seg gjennom disse objektene. | **Krav:** Spilleren må stoppe når den treffer en vegg eller blokk.  **Kriterie:** Når en spiller beveger seg bort mot en vegg eller blokk, kan den ikke passere veggen eller blokken. Spilleren kan imidlertid hoppe over eller på blokken for å passere den. | Her bruker vi *Tiled* for å implementere akseptansekriteriene. Først setter vi egenskapen *blocked* til celle-objektet i det rette tiled-layeret til å være *blocked*. Videre sjekker vi i metoden *Update* fra klassen *Player* om spilleren treffer en celle som er blocked. Hvis spilleren treffer en celle som er *blocked* vil feltvariabelen *Velocity* endres til 0. Som konsekvens vil da vil spilleren stoppe. |

### 3.2.1 Prioritert liste på brukerhistorier
1. 2D spillebrett
2. Vegger/Blokker
3. Spiller  

# 4. Kode
Den foreløpige koden inneholder implementasjoner for et 2D spillebrett, vegger og blokker.

# 5. Oppsummering

## 5.1 Retrospektiv vurdering
Prosjektet frem til første innlevering har fungert bra for gruppen. Vi ser blant annet at den opprinnelige organiseringen av gruppen har vært hensiktsmessig for arbeidet. Med utgangspunkt i kartlegging av kompetanse og fordeling av roller har vi oppnådd en effektiv ressursutnyttelse i gruppen. Vi har blant annet brukt project-boardet aktivt for å holde oversikt på prosessene i utviklingsarbeidet.  

Når det gjelder den retrospektive vurderingen av metodikk har vi fulgt scrum-rammeverket nøye som planlagt. Det har gjort at vi har lyktes med å ha oversikt på hvilke arbeidsoppgaver som må fullføres innen første sprint. En viktig grunn til at vi tror at vi har lyktes med dette er at vi har satt opp arbeidsoppgaver i backloggen, flyttet dem over til listen Pågående/Sprint etter hvert som vi tar fatt på oppgaven og deretter flyttet dem over til Fullført. På denne måten har vi oppnådd en bedre oversikt på hvor langt vi er kommet i utviklingsprosessen, og hvem som arbeider med hva. 

Videre har vi også hatt review-møte for å legge frem hva hver enkelt har gjort, og diskutert hvordan vi skal løse utfordringer som har dukket opp underveis. Her ser vi blant annet at vi hadde utfordringer med å få koden til å kompilere i starten, hvilket tok mye tid for å løse. Vi hadde ikke forventet å bruke så mye tid på å rette opp en liten feil, og innser at små bugs i programmet kan være kilde til mye mer ressursbruk enn planlagt. For å lære av dette så vil sette av mer tid til testing og debugging i neste sprint slik at vi reduserer utfordringer med planlegging av tid.  

Vurdering av hvordan vi traff på oppgaven: Det ferdige produktet samsvarer/samsvarer ikke med de forventningene vi har satt. Blant annet har vi fullført punkt 1-3 på prioriteringslisten over brukerhistorier (se 3.2). Vi tror at grunnen til at vi klarte å nå målene vi har satt oss er fordi vi har fulgt planen vi har satt oss, hatt en effektiv kommunikasjon i gruppen og et godt samarbeid. Spesielt kommunikasjonen i gruppen har fungert bra. Vi har brukt kommunikasjonskanalene effektivt for å koordinere arbeid og møter. På møtene har vi hatt et jevnt bidrag fra alle medlemmer og åpenhet om å lytte til alle meninger. En viktig årsak til at vi har oppnådd dette er at vi har vektlagt forståelse, kontekst, kroppspråk og respekt i kommunikasjonen. Vi ser at dette har vært en forutsetning for å nå de målene vi har satt oss, og komme i mål med oppgaven.  

## 5.2 Annet
Dokumentasjon om teknisk produktoppsett (hvordan bygge og kjøre programmet): For å kjøre programmet må du velge en editor til å åpne koden med, og kjøre filen *Main*. Denne ligger i package *inf112.skeleton.app*.

