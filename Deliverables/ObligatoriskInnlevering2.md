# Obligatorisk oppgave 2 - *navn på prosjektet her*
**Team**: *gruppenavn her* (Gruppe 3)  
**Gruppemedlemmer:**  
 - Thomas Thunes
 - Karl Martin Helset
 - Magnus Brodtkorb
 - Jonas Holgersen
 - Jon Kvinnsland  

**Prosjektbeskrivelse:**  

## Innholdsfortegnelse  
[[_TOC_]]  

# 1. Team og prosjekt
I denne delen av oppgaven vil vi gjennomgå (1) møtereferater og (2) en oppsummering av team og prosjekt.  

## 1.1 Møtereferater  
Møtereferatene oppsummerer hva som har blitt disuktert på de ulike møtene, eventuelle avgjørelser som er tatt og hvilke arbeidsoppgaver vi har fordelt frem til neste møte.  

### 1.1.1 Møte 1
**Dato:** 01.03  

**Deltakere:** Alle  

**Diskusjon:** På dette møtet diskuterte vi hvordan vi skulle sette rammene for prosjektet vårt frem mot neste innlevering. Vi identifiserte fire hovedutfordringer som vi mener vil kreve ekstra fokus, deriblant (1) legge til fiender/monstre, (2) la spilleren ha liv og mulighet til å miste liv når den treffer for eksempel fiender, (3) fikse hoppe-funksjonen slik at spilleren hopper realistisk og (4) legge til tester for koden. Videre diskuterer vi også utfordringer knyttet til organiseringen av prosjektet. Dette gjelder spesielt kodebasen i git der vi opplever mye *merge conflicts* ved pushing/pulling av kode. Dette diskuterer vi også med studentassistenten og får veiledning på hvordan dette kan løses.  

**Avgjørelser:** På dette møtet tok vi en avgjørelse om at spilleren skal ha en egen fart når den er i luften og gi den gravitet når den beveger seg oppover i hoppet. På denne måten ser vi for oss å kunne simulere en mer realistisk hoppefunksjon. Vi ble også enige om at Jon skriver møtereferater for alle møter frem mot neste innlevering.  

** Arbeidsoppgaver til neste møte:** Thomas starter på å legge til liv til spilleren og mulighet for at spilleren kan miste liv og dø. Karl og Magnus vil forsøke å fikse hoppe-funksjonen, Jonas jobber med tester og Jon bistår på hoppe-funksjonen i tillegg til å skrive møtereferat. Vi forventer ikke at funksjonene og testene skal være ferdig implementert til neste møte, men vi forventer noe progresjon.  


### 1.1.2 Møte 2
**Dato:**  

**Deltakere:** Alle  

**Diskusjon:**  

**Avgjørelser:**  

** Arbeidsoppgaver til neste møte:**  


| Nr. | Dato | Deltakere | Diskusjon | Avgjørelser | Arbeidsoppgaver til neste møte |
|---|---|---|---|---|---|
| 1 | 01.03 | Alle | På dette møtet diskuterte vi hvordan vi skulle sette rammene for prosjektet vårt frem mot neste innlevering. Vi identifiserte fire hovedutfordringer som vi mener vil kreve ekstra fokus, deriblant (1) legge til fiender/monstre, (2) la spilleren ha liv og mulighet til å miste liv når den treffer for eksempel fiender, (3) fikse hoppe-funksjonen slik at spilleren hopper realistisk og (4) legge til tester for koden. Videre diskuterer vi også utfordringer knyttet til organiseringen av prosjektet. Dette gjelder spesielt kodebasen i git der vi opplever mye *merge conflicts* ved pushing/pulling av kode. Dette diskuterer vi også med studentassistenten og får veiledning på hvordan dette kan løses. | På dette møtet tok vi en avgjørelse om at spilleren skal ha en egen fart når den er i luften og gi den gravitet når den beveger seg oppover i hoppet. På denne måten ser vi for oss å kunne simulere en mer realistisk hoppefunksjon. Vi ble også enige om at Jon skriver møtereferater for alle møter frem mot neste innlevering.  | Thomas starter på å legge til liv til spilleren og mulighet for at spilleren kan miste liv og dø. Karl og Magnus vil forsøke å fikse hoppe-funksjonen, Jonas jobber med tester og Jon bistår på hoppe-funksjonen i tillegg til å skrive møtereferat. Vi forventer ikke at funksjonene og testene skal være ferdig implementert til neste møte, men vi forventer noe progresjon. |
| 2 | 08.03 | Alle | På dette møtet oppdaterte vi hverandre på hva vi hadde gjort fra forrige møte. Karl og Magnus har implementert hoppefunksjonen, men merker at spilleren har mulighet til å ta løpefart. Dette ser urealistisk ut og vi finner ut at vi kan sette ned farten på spilleren og bruke den samme farten når den hopper. Thomas bemerker også at *collision*-funksjonaliteten til spilleren inneholder overflødig kode og kan forkortes. Jon sier at han kan se nærmere på dette. Vi diskuterer også hvordan vi synes at prosjektmetodikken fungerer. Her kommenterer Magnus at ikke alle sprinter trenger å vare i 14 dager, da for eksempel hoppefunksjonen er ferdig implementert allerede nå. Dette gjør oss mer oppmerksom på hvordan vi skal fordele ressurser fremover, og at vi kan planlegge å starte på noen oppgaver fra backloggen tidligere enn antatt.  | Vi bestemte oss også å sette ned farten til spilleren og la den ha samme fart når den hopper, da dette ser mer realistisk ut (spiller kan da ikke ta «løpefart»). Vi tar også en beslutning om å korte ned sprintene på enkelte arbeidsoppgaver der vi finner det hensiktsmessig. | Jon jobber med å forkorte collision-funksjonen og gjøre den mer dynamisk. Karl og Magnus setter ned farten på spilleren. Thomas starter på funksjonalitet for fiender, og Jonas ser på testing av koden. |
| 3 | 15.03 | Alle | På dette møtet blir vi enige om å ikke fordele noe særlig med arbeidsoppgaver til neste møte, da flertallet er opptatt med andre innleveringer denne uken. Vi blir dermed enige om å ha lave forventninger til progresjon på prosjektet frem mot neste møte. Videre gikk vi gjennom hva vi ser for oss rapporten til neste innlevering skal inneholde, og Jon sier han kan starte på denne da han ikke har andre innleveringer denne uken.  | Forventningsavklaring om lite progresjon frem mot neste møte. | Jon jobber med rapporten frem mot neste møte. |
| 4 | 22.03 | Alle | På dette møtet diskuterte vi hvordan vi skal jobbe frem mot innleveringen på fredag. Vi går gjennom evalueringen vi fikk på forrige innlevering og ser på mulige forbedringspotensialer. Vi diskuterer også hovedutfordringene som vi identifiserte på første møte og ser at det kun er fiender/monstre og tester som gjenstår. Thomas har til nå startet litt på klassen for fiender (Enemy), men merker at han bruker mye gjenbruk av tidligere kode. Her diskuterer vi oss frem til at vi kan lage en abstrakt klasse som gjelder for både spiller og fiende, slik at vi reduserer gjenbruk av kode. | På dette møtet tok vi en avgjørelse om å ha en abstrakt klasse som gjelder for både main player og enemy. | Jon jobber med å ferdigstille rapporten, Karl begynner på å lage en Menu-screen, Thomas jobber med å legge til fiender og utvide map’et og Jonas jobber med tester. Magnus avlaster de andre på programmeringsoppgaver der det er behov. |  

## 1.2 Oppsummering av team og prosjekt  
I denne delen av oppgaven oppsummerer vi hvordan arbeidet i gruppen har vært og reflekterer over utviklingen i vårt prosjekt.  
### 1.2.1 Roller
Rollene har til nå fungert slik som tiltenkt. Alle bidratt med sine styrker og vi merker at kvaliteten i arbeidet øker når vi fordeler ansvarsområder på ulike personer. Vi opplever at rollene vi har nå er godt dekkende for alle arbeidsoppgavene i prosjektet, og vi har dermed ikke behov for andre roller. Når det gjelder hva de ulike rollene faktisk innebærer for oss har vi merket oss følgende:  

*Oppgave: Skriv ned noen linjer om hva de ulike rollene faktisk innebærer for dere.*  

*(Denne kan endres på)*  
Thomas har merket at sin rolle som teamleder innebærer at han må være tilstede på alle gruppemøter for å holde oversikt på hele utviklingsprosessen. Han merker også at ansvarsområdet kan tidvis være krevende, og at han derfor må være aktiv på å fordele arbeidsoppgaver.  

Magnus har merket at sin rolle som prosjektansvarlig innebærer at han må ha god oversikt på brukerhistoriene og ressursbruken som kreves for å implementere de. Enkelte brukerhistorier har vært vanskeligere å implementere enn først anntatt, og da er det spesielt viktig at prosjektansvarlig har fokus på å fordele ressursene effektivt slik at alle brukerhistorier blir implementert.  

Karl har merket at sin rolle som Scrum Master innebærer at han blant annet må oppdatere vårt Project Board underveis i utviklingsprosessen. På denne måten bidrar Scrum Master til at alle har oversikt på hvilke arbeidsoppgaver som skal utføres til neste sprint. Karl holder oss også oppdatert på arbeidsoppgaver i backloggen som vi må eventuelt må vurdere å starte på.  

Jonas har merket at sin rolle som testansvarlig innebærer at han må ha god forståelse for hva som er formålet med de ulike funksjonene i koden slik at testene faktisk tester den relevante funksjonaliteten ved hver funksjon. Dette innebærer at han må ha en tett og god dialog med utviklerne av de ulike funksjonene i koden.  

Jon har merket at sin rolle som kundekontakt innebærer at han må være aktiv i dialogen med kunden for å hele tiden være observant på eventuelle endringer. Det innebærer også at han må gi rask tilbakemelding til gruppen slik at de får tid til å tilpasse seg. Frem til nå har ikke kunden kommet med nye vesentlige endringer.  

### 1.2.2 Erfaringer og valg
**Erfaringer team:** Når det gjelder erfaringer i teamet har vi merket at noen av rollene kan gli over i hverandre ved enkelte arbeidsoppgaver, og vi merker at vi i slike tilfeller drar fordel av å samarbeide på enkelte ansvarsområder. Det kan for eksempel være å holde oversikt på Project Boardet og å skrive tester. Vi merker oss også at arbeidsmåten med parprogrammering har fungert bra, og at uktentlige teammøter har bidratt til at alle kan holde god oversikt på utviklingen i prosjektet.  

**Erfaringer prosjektmetodikk:** Når det gjelder erfaringer relatert til prosjektmetodikk har vi merket at oppdelingen av konkrete arbeidsoppgaver i backloggen har fungert bra da dette gir oss en bedre forståelse av hvilke funksjoner som må legges til i koden for at vi skal oppnå et delmål/brukerhistorie. Vi merker oss imidlertid at enkelte arbeidsoppgaver kan settes opp på kortere sprinter enn 14 dager og at ressursfordelingen dermed kan forbedres på denne måten. Kravet til testing som Scrum-rammeverket legger opp til har også fungert bra og ført til at vi har fått en kvalitetssikker kode. Gjennom ukentlige Scrum-møter tidlig identifisering av eventuelle utfordringer, slik som ...   

**Valg underveis:** Vi opplever at de fleste valgene vi har tatt underveis i utviklingsprosessen har vært gode. På teammøtene har vi vurdert de ulike valgalternativene opp mot hverandre og diskutert eventuelle konskvenser av hvert valg vi tar. På denne måten har vi oppnådd god en god enighet i gruppen slik at vi er samstemte på hvordan vi ønsker at utviklingsprosessen vår skal være. Vi er for eksempel fornøyde med valget om å ... da dette har vist seg å være ... Vi ser imidlertid at valget om å ... har gjort det utfordrene å ... For å overkomme dette har vi derfor ... Dette tar vi også med oss videre når vi skal gjøre flere valg på teammøtene.  

*Oppgave: Er det noen erfaringer enten team-messig eller mtp prosjektmetodikk som er verdt å nevne? Synes teamet
at de valgene dere har tatt er gode? Hvis ikke, hva kan dere gjøre annerledes for å forbedre måten teamet
fungerer på*  

### 1.2.3 Gruppedynamikk
For å sikre en god gruppedynamikk har vi hatt ukentlige team-møter der vi diskuterer relevante saker for gruppearbeidet. Samtlige av gruppemedlemmene har vært tolmodige og åpne for å lytte til andres synspunkter, og dette merker vi har ført til en god gruppedynamikk. Gjennom Project Boardet vårt har vi blant annet avklart forventninger til hverandre og arbeidet som skal gjøres. Slike forventningsavklaringer mener vi har bidratt til redusere konflikter til et minimum og dermed forbedret gruppedynamikken.  

### 1.2.4 Kommunikasjon
*Fra retteskjema: "alle meningher blir hørt, tonen er god, alle bidrar jevnt"*  

Kommunikasjonen i gruppen har fungert bra. Vi har blant annet brukt informasjonskanaler som Messenger til å holde kontakt utenom de fysiske gruppemøtene. Vi har også hatt åpenhet for at alle skal få dele sine meninger og hjulpet hverandre når noen står fast med for eksempel kodingen.  

### 1.2.5 Retrospektiv vurdering av prosjektstruktur
*Oppgave: Gjør et kort retrospektiv hvor dere vurderer hva dere har klart til nå, og hva som kan forbedres. Dette skal handle om prosjektstruktur, ikke kode. Dere kan selvsagt diskutere kode, men dette handler ikke om feilretting, men om hvordan man jobber og kommuniserer*  

**Vurdering av hva vi har klart til nå:** Frem til nå har vi jobbet effektivt og hatt god kommunikasjon i gruppen. Vi drar godt nytte av styrkene i Scrum-rammeverket slik som Project Board med backlogg og sprinter, i tillegg til ukentlige oppfølgingsmøter. For å jobbe effektivt med koden har vi blant annet benyttet oss av parkoding der den ene skriver kode mens den andre bidrar med å fortelle hva som skal skrives. På denne måten får vi fram flere tanker og idéer som igjen øker kvaliteten i koden. Se forøvrig svar under de andre deloppgavene over på hvordan vi reflekterer over kommunikasjon og arbeid i gruppen.  

**Hva vi mener kan forbedres:** Når det gjelder hva vi mener kan forbedres så merker vi at vi kan bli flinkere på å fordele arbeidsoppgaver slik at alle har noe å gjøre til neste teammøte.  
Push/pull i git  

### 1.2.6 Forskjeller i commits
Vi har hatt forskjeller i antall commits mellom teammedlemmer underveis i prosjektet. Dette skyldes at vi har brukt mye parkoding slik at det kun er én av to som comitter koden til git. Videre har vi også fordelt arbeidet slik at noen fokuserer mer på å skrive rapport. Dette bidrar også til ulikheter i commits.   

### 1.2.7 Forbedring
*3 punkter for forbedring til neste sprint, basert på retrospektiv vurdering*  
Basert på den retrospektive vurderingen (1.2.5) har vi satt opp følgende liste med forbedringspotensiaer til neste sprint:
1. Sørge for å fordele arbeidsoppgaver til alle på gruppen  
2. Sørge for mer gjevn fordeling av commits  
3. Bli flinkere på å ha kontroll på git (push/pull)

 

# 2. Krav

## 2.1 MVP
 - Vise fiender/monstre; de skal interagere med terreng og spiller  
 - Fikse jump (lande raskere ved å justere farten på vei ned, bestemme én fart som gjelder for hopp og på bakken)  
 - Spiller har poeng og interagerer med poenggjenstander  
 - Legge inn tester  

(*kan droppes*)  
 - Spiller kan dø (ved kontakt med fiender, eller ved å falle utfor skjermen)   
 - Mål for spillbrett (enten et sted, en mengde poeng, drepe alle fiender e.l.)   

# 3. Produkt og kode

