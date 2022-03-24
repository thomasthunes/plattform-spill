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

**Diskusjon:** På dette møtet diskuterte vi hvordan vi skulle sette rammene for prosjektet vårt frem mot neste innlevering. Vi identifiserte fire hovedutfordringer som vi mener vil kreve ekstra fokus, deriblant (1) legge til fiender/monstre, (2) la spilleren ha liv og mulighet til å miste liv når den treffer for eksempel fiender, (3) fikse hoppe-funksjonen slik at spilleren hopper realistisk og (4) legge til tester for koden. Videre diskuterer vi også utfordringer knyttet til organiseringen av prosjektet. Dette gjelder spesielt kodebasen i git der vi opplever mye *merge conflicts* ved pushing/pulling av kode. Dette diskuterer vi også med studentassistenten og får veiledning på hvordan dette kan løses. Her lærte vi å bruke egen branch som vi pusher og puller til når vi jobber med en bestemt funksjonalitet, og deretter merger denne branchen med vår master-branch når funksjonaliteten er ferdig implemtert.  

**Avgjørelser:** På dette møtet tok vi en avgjørelse om at spilleren skal ha en egen fart når den er i luften og gi den gravitet når den beveger seg oppover i hoppet. På denne måten ser vi for oss å kunne simulere en mer realistisk hoppefunksjon. Vi ble også enige om at Jon skriver møtereferater for alle møter frem mot neste innlevering.  

**Arbeidsoppgaver til neste møte:** Thomas starter på å legge til liv til spilleren og mulighet for at spilleren kan miste liv og dø. Karl og Magnus vil forsøke å fikse hoppe-funksjonen, Jonas jobber med tester og Jon bistår på hoppe-funksjonen i tillegg til å skrive møtereferat. Vi forventer ikke at funksjonene og testene skal være ferdig implementert til neste møte, men vi forventer noe progresjon.  


### 1.1.2 Møte 2
**Dato:** 08.03  

**Deltakere:** Alle  

**Diskusjon:** På dette møtet oppdaterte vi hverandre på hva vi hadde gjort fra forrige møte. Karl og Magnus har implementert hoppefunksjonen, men merker at spilleren har mulighet til å ta løpefart. Dette ser urealistisk ut og vi finner ut at vi kan sette ned farten på spilleren og bruke den samme farten når den hopper. Thomas bemerker også at *collision*-funksjonaliteten til spilleren inneholder overflødig kode og kan forkortes. Jon sier at han kan se nærmere på dette. Vi diskuterer også hvordan vi synes at prosjektmetodikken fungerer. Her kommenterer Magnus at ikke alle sprinter trenger å vare i 14 dager, da for eksempel hoppefunksjonen er ferdig implementert allerede nå. Dette gjør oss mer oppmerksom på hvordan vi skal fordele ressurser fremover, og at vi kan planlegge å starte på noen oppgaver fra backloggen tidligere enn antatt.  

**Avgjørelser:** Vi bestemte oss også å sette ned farten til spilleren og la den ha samme fart når den hopper, da dette ser mer realistisk ut (spiller kan da ikke ta «løpefart»). Vi tar også en beslutning om å korte ned sprintene på enkelte arbeidsoppgaver der vi finner det hensiktsmessig.  

**Arbeidsoppgaver til neste møte:** Jon jobber med å forkorte collision-funksjonen og gjøre den mer dynamisk. Karl og Magnus setter ned farten på spilleren. Thomas starter på funksjonalitet for fiender, og Jonas ser på testing av koden.  


### 1.1.3 Møte 3
**Dato:** 15.03  

**Deltakere:** Alle  

**Diskusjon:** På dette møtet blir vi enige om å ikke fordele noe særlig med arbeidsoppgaver til neste møte, da flertallet er opptatt med andre innleveringer denne uken. Vi blir dermed enige om å ha lave forventninger til progresjon på prosjektet frem mot neste møte. Videre gikk vi gjennom hva vi ser for oss rapporten til neste innlevering skal inneholde, og Jon sier han kan starte på denne da han ikke har andre innleveringer denne uken.  

**Avgjørelser:** Forventningsavklaring om lite progresjon frem mot neste møte.  

**Arbeidsoppgaver til neste møte:** Jon jobber med rapporten frem mot neste møte.  


### 1.1.4 Møte 4
**Dato:** 22.03  

**Deltakere:** Alle  

**Diskusjon:** På dette møtet diskuterte vi hvordan vi skal jobbe frem mot innleveringen på fredag. Vi går gjennom evalueringen vi fikk på forrige innlevering og ser på mulige forbedringspotensialer. Vi diskuterer også hovedutfordringene som vi identifiserte på første møte og ser at det kun er fiender/monstre og tester som gjenstår. Thomas har til nå startet litt på klassen for fiender (Enemy), men merker at han bruker mye gjenbruk av tidligere kode. Her diskuterer vi oss frem til at vi kan lage en abstrakt klasse som gjelder for både spiller og fiende, slik at vi reduserer gjenbruk av kode.  

**Avgjørelser:** På dette møtet tok vi en avgjørelse om å ha en abstrakt klasse som gjelder for både main player og enemy.  

**Arbeidsoppgaver til neste møte/innlevering 25.03:** Jon jobber med å ferdigstille rapporten, Karl begynner på å lage en Menu-screen, Thomas jobber med å legge til fiender og utvide map’et og Jonas jobber med tester. Magnus avlaster de andre på programmeringsoppgaver der det er behov.  


## 1.2 Oppsummering av team og prosjekt  
I denne delen av oppgaven oppsummerer vi hvordan arbeidet i gruppen har vært og reflekterer over utviklingen i vårt prosjekt.  
### 1.2.1 Roller
Rollene har til nå fungert slik som tiltenkt. Alle bidratt med sine styrker og vi merker at kvaliteten i arbeidet øker når vi fordeler ansvarsområder på ulike personer. Vi opplever at rollene vi har nå er godt dekkende for alle arbeidsoppgavene i prosjektet, og vi har dermed ikke behov for andre roller. Når det gjelder hva de ulike rollene faktisk innebærer for oss har vi merket oss følgende:  
 
Thomas har merket at sin rolle som teamleder innebærer at han må være tilstede på alle gruppemøter for å holde oversikt på hele utviklingsprosessen. Han merker også at ansvarsområdet kan tidvis være krevende, og at han derfor må være aktiv på å fordele arbeidsoppgaver.  

Magnus har merket at sin rolle som prosjektansvarlig innebærer at han må ha god oversikt på brukerhistoriene og ressursbruken som kreves for å implementere de. Enkelte brukerhistorier har vært vanskeligere å implementere enn først anntatt, og da er det spesielt viktig at prosjektansvarlig har fokus på å fordele ressursene effektivt slik at alle brukerhistorier blir implementert.  

Karl har merket at sin rolle som Scrum Master innebærer at han blant annet må oppdatere vårt Project Board underveis i utviklingsprosessen. På denne måten bidrar Scrum Master til at alle har oversikt på hvilke arbeidsoppgaver som skal utføres til neste sprint. Karl holder oss også oppdatert på arbeidsoppgaver i backloggen som vi må eventuelt må vurdere å starte på.  

Jonas har merket at sin rolle som testansvarlig innebærer at han må ha god forståelse for hva som er formålet med de ulike funksjonene i koden slik at testene faktisk tester den relevante funksjonaliteten ved hver funksjon. Dette innebærer at han må ha en tett og god dialog med utviklerne av de ulike funksjonene i koden.  

Jon har merket at sin rolle som kundekontakt innebærer at han må være aktiv i dialogen med kunden for å hele tiden være observant på eventuelle endringer. Det innebærer også at han må gi rask tilbakemelding til gruppen slik at de får tid til å tilpasse seg. Frem til nå har ikke kunden kommet med nye vesentlige endringer.  

### 1.2.2 Erfaringer og valg
**Erfaringer team:** Når det gjelder erfaringer i teamet har vi merket at noen av rollene kan gli over i hverandre ved enkelte arbeidsoppgaver, og vi merker at vi drar fordel av å samarbeide på enkelte ansvarsområder slik som for eksempel Project Boardet. Vi merker oss også at arbeidsmåten med parprogrammering har fungert bra, og at uktentlige teammøter har bidratt til at alle kan holde god oversikt på utviklingen i prosjektet.  

**Erfaringer prosjektmetodikk:** Når det gjelder erfaringer relatert til prosjektmetodikk har vi merket at oppdelingen av konkrete arbeidsoppgaver i backloggen har fungert bra da dette gir oss en bedre forståelse av hvilke funksjoner som må legges til i koden for at vi skal oppnå et delmål/brukerhistorie. Vi merker oss imidlertid at enkelte arbeidsoppgaver kan settes opp på kortere sprinter enn 14 dager og at ressursfordelingen dermed kan forbedres på denne måten. Gjennom ukentlige Scrum-møter har vi oppnådd tidlig identifisering av eventuelle utfordringer, slik som å fikse hoppe-funksjonen og forkorte funksjonen for *collision* (se møtereferat).  

**Valg underveis:** Vi opplever at de fleste valgene vi har tatt underveis i utviklingsprosessen har vært gode. På teammøtene har vi vurdert de ulike valgalternativene opp mot hverandre og diskutert eventuelle konskvenser av hvert valg vi tar. På denne måten har vi oppnådd god en god enighet i gruppen slik at vi er samstemte på hvordan vi ønsker at utviklingsprosessen vår skal være. Vi er for eksempel fornøyde med valget om å endre farten til spilleren da dette viser en mer realistisk bevegelse på spilleren. Vi ser imidlertid at valget om å ha kun ha sprinter på 14 dager har gjort det vanskeligere å fordele ressurser effektivt. For å overkomme dette har vi derfor kortet ned noen av sprintene. Dette tar vi også med oss videre når vi skal planlegge for nye oppgaver i backloggen.  

### 1.2.3 Gruppedynamikk
For å sikre en god gruppedynamikk har vi hatt ukentlige team-møter der vi diskuterer relevante saker for gruppearbeidet. Samtlige av gruppemedlemmene har vært tolmodige og åpne for å lytte til andres synspunkter, og dette merker vi har ført til en god gruppedynamikk. Gjennom diskusjoner har vi blant annet avklart forventninger til hverandre og arbeidet som skal gjøres. Slike forventningsavklaringer mener vi har bidratt til redusere konflikter til et minimum og dermed forbedret gruppedynamikken. Her har også Project Boardet vårt bidratt til å gi en bedre oversikt på hva alle jobber med slik at dynamikken i gruppen blir bedre. Alt i alt har valget av prosjektmetodikk (Scrum) lagt godt til rette for en god gruppedynamikk.  

### 1.2.4 Kommunikasjon
Kommunikasjonen i gruppen har fungert bra. Vi har blant annet brukt informasjonskanaler som Messenger til å holde kontakt utenom de fysiske gruppemøtene. Vi har også hatt åpenhet for at alle skal få dele sine meninger og bistått hverandre når en står fast med for eksempel koding av en funksjonalitet. Som nenvt tidligere har også ukentlige møter vært en viktig forutsetning for å oppnå god kommunikasjon.  

### 1.2.5 Retrospektiv vurdering av prosjektstruktur
**Vurdering av hva vi har klart til nå:** Frem til nå har vi jobbet effektivt og hatt god kommunikasjon i gruppen. Vi drar godt nytte av styrkene i Scrum-rammeverket slik som Project Board med backlogg og sprinter, i tillegg til ukentlige oppfølgingsmøter. For å jobbe effektivt med koden har vi blant annet benyttet oss av parkoding der den ene skriver kode mens den andre bidrar med å fortelle hva som skal skrives. På denne måten får vi fram flere tanker og idéer som igjen øker kvaliteten i koden. Se forøvrig møtereferater og svar på de andre deloppgavene over på hvordan vi reflekterer over [kommunikasjon](#124-kommunikasjon) og arbeid i gruppen ([Roller](#121-roller), [Erfaringer og valg](#122-erfaringer-og-valg) og [Gruppedynamikk](#123-gruppedynamikk)).  

**Hva vi mener kan forbedres:** Når det gjelder hva vi mener kan forbedres så merker vi at vi kan bli flinkere på å fordele arbeidsoppgaver slik at alle har noe å gjøre til neste teammøte. Vi har også opplevd utfordringer med push og pull av kode i git. Her har vi blitt flinkere fra første innlevering, men vi merker oss likevel at dette kan ytterligere forbedres. Til sist merker vi også at vi kan bli mer nøyaktig når vi setter opp tidsintervaller på hvor lang tid vi forventer at implementasjonen av en gitt funksjonalitet vil ta, slik at ressursfordelingen blir bedre.  

### 1.2.6 Forskjeller i commits
Vi har hatt noe forskjeller commits mellom teammedlemmer underveis i prosjektet. Dette skyldes at vi har brukt mye parkoding slik at det ofte kun er én av to som comitter koden til git. Videre har vi også fordelt arbeidet slik at noen fokuserer mer på å skrive rapport. Dette bidrar også til ulikheter i commits.  

### 1.2.7 Forbedring
Basert på den retrospektive vurderingen ([1.2.5](#125-retrospektiv-vurdering-av-prosjektstruktur)) har vi satt opp følgende liste med forbedringspotensialer til neste sprint:  
1. Bli flinkere på å ha kontroll på git (push/pull)  
2. Bli flinkere på å fordele arbeidsoppgaver mellom teammøter slik at alle har noe å gjøre  
3. Bli flinkere på å bestemme tidsintervaller ved implementasjon av ny funksjonalitet  

# 2. Krav

## 2.1 "Stretch goal"
Her vi valgt å fokusere på å oppnå målene fra MVP-listen som er gitt i oppgaveteksten til første innlevering. Dette gjelder spesielt å ha høy kvalitet på koden, godt design og klare abstraksjoner. Vi har imidlertid gjort noe endringer på grafikken slik som å endre utseende på map'et.  

## 2.2 MVP og annet

### 2.2.1 Krav og funksjonalitet
*Hele 2.2.1 bør vurderes å sette inn under 2.2.2*

*"Oppgave: Oppdater hvilke krav dere har prioritert, hvor langt dere har kommet og hva dere har gjort siden forrige gang. Er dere kommet forbi MVP? Forklar hvordan dere prioriterer ny funksjonalitet"*  

**Prioritert liste på krav:** 

**Hvor langt vi har kommet og hva vi har gjort siden forrige gang:**  

**Hvordan ny funksjonalitet prioriteres:**  

### 2.2.2 Brukerhistorier
For beskrivelse av hva en brukerhistorie er og hvordan vi har satt dem opp se [innledende kommentar](https://git.app.uib.no/scrumbois/plattform-spill/-/blob/master/Deliverables/ObligatoriskOppgave1.md#32-brukerhistorier) fra første innlevering. Brukerhistoriene her følger samme format, og er oppsummert sammen med akseptansekriterier og arbeidsoppgaver i tabellen under. Etter tabellen følger det også en prioritert liste over hvilke brukerhistorier vi ønsker å ha med i første sprint/iterasjon.  

| Brukerhistorier  | Akseptansekriterier | Arbeidsoppgaver |
|---|---|---|
| **2D spillebrett:** Som spiller ønsker jeg å se et spillebrett, slik at jeg kan orientere meg. | **Krav:** Vise et 2D spillebrett.  **Kriterie:** Når programmet kjøres vises et vindu med grafikk til spillebrettet. | For å imøtekomme akseptansekriteriene må klassen *Play* implementeres. Denne klassen implementerer interfacet *Screen*. Videre så vil klassen *Play* sørge for at når koden kjøres så vil et map rendres, sette posisjonen til en spiller (spilleren kommer fra klassen *Player*) og sette opp *Orthographic camera* som følger skjermen. |
| **Spiller:** Som utvikler ønsker jeg å kunne bevege spillebrikken i spillet med piltastene og space for å teste funksjonene til spillebrettet og se om disse fungerer slik det skal. | **Krav:** Spilleren må kunne bevege seg.   **Kriterie:** Når en piltast trykkes beveges spillebrikken den retningen piltasten peker, og dersom en trykker *space* skal spillebrikken hoppe. | For å imøtekomme akseptansekriteriene må klassen *Player* implementeres. Denne klassen utvider den abstrakte klassen *Sprite* fra LibGDX-biblioteket. I klassen *Player* vil en spiller opprettes som et objekt av typen *Player*. Videre vil feltvariablene *Speed*, *Gravity* og *Velocity* i klassen *Player* settes. Disse feltvariablene beskriver hvordan spilleren beveger seg med tanke på hurtighet (*Speed*), tyngdekraft (*Gravity*) og i hvilken retning (*Velocity*). Klassen *Player* vil også inneholde en metode *Update* som endrer på posisjonen til spiller-objektet avhenigig av verdien på feltvariabelen *Velocity*. *Update* sjekker også om spilleren treffer en celle som er *blocked*, og i så fall vil *Velocity* settes til 0. |
| **Vegger/blokker:** Som utvikler ønsker jeg vegger og blokker slik at jeg kan implementere funksjoner som sørger for at en spiller ikke kan bevege seg gjennom disse objektene. | **Krav:** Spilleren må stoppe når den treffer en vegg eller blokk.  **Kriterie:** Når en spiller beveger seg bort mot en vegg eller blokk, kan den ikke passere veggen eller blokken. Spilleren kan imidlertid hoppe over eller på blokken for å passere den. | Her bruker vi *Tiled* for å implementere akseptansekriteriene. Først setter vi egenskapen *blocked* til celle-objektet i det rette tiled-layeret til å være *blocked*. Videre sjekker vi i metoden *Update* fra klassen *Player* om spilleren treffer en celle som er blocked. Hvis spilleren treffer en celle som er *blocked* vil feltvariabelen *Velocity* endres til 0. Som konsekvens vil da vil spilleren stoppe. |
| **Fiender/monstre:** Som spiller ønsker jeg å kunne møte på fiender slik at spillet har utfordringer som gjør det spennende å spille. | **Krav:** Må kunne se en fiende som et objekt på spillebrettet.  **Kriterie:** Når spilleren treffer en fiende så mister den liv. Dersom den treffer en fiende mange nok ganger vil den til slutt dø. | Liste på funksjonaliteter som må implementeres for å imøtekomme akseptansekriteriene: <ul type="1"><li>Implementere klassen Enemy. Denne klassen extender klassen Player slik at en fiende får de samme egenskapene som player (gravity, collision layer)</li><li>Opprette Enemy-objekter med en tilfeldig posisjon på brettet. Dette skjer samtidig som ny spiller blir opprettet.</li><li>Implementere brukerhistorien *Spiller kan dø* (se under) slik at spilleren mister liv ved kontakt med fiende.</li></ul> |
| **Spiller kan dø:** Som spiller ønsker jeg mulighet til å kunne dø slik at implementasjonen av fiender blir meningsfull. Dette gir da et insentiv til å overkomme fiendene og gjør dermed spillet mer spennende. | **Krav:** Dersom spilleren dør kan den ikke lenger bevege seg i spillet og spillet er dermed over.  **Kriterie:** Når spilleren har mistet en gitt mengde med liv skal den være død.  | Liste på funksjonaliteter som må implementeres for å imøtekomme akseptansekriteriene: <ul><li>Implementere metoden isAttacked. Denne metoden vil kalle på funksjonen getAttack når spilleren blir angrepet.</li><li>Implementere getAttack: Denne funksjonen vil enten sette ned liv på spiller eller forlytte spilleren, avhengig av om fienden er en bombe eller en fiende som dreper/setter ned liv.</li><li>Implementere metoden Attack: Denne metoden iterer over alle fiender og sjekker om spiller kolliderer med en fiende fra toppen eller fra siden.</li><li>Implementere metodene collidesWithActorFromTop og collidesWithActorFromSide i klassen Item som skal brukes i Attack.</li><li>Implementere metoden inBounds som sjekker om spiller faller ut av mappet, og i så fall la spilleren miste liv slik at den dør.</li></ul> |
| **Liv:** Som spiller ønsker jeg å å kunne plukke opp liv slik at jeg kan helbrede meg selv etter å ha truffet på en fiende, og på denne måten unngå å dø. | **Krav:** Objekter som gir spilleren liv må være plassert på spillebrettet.  **Kriterie:** Når spilleren går bort til et liv-objekt kan den plukke opp pakken med liv ved å trykke på "P" slik at liv til spilleren øker. | Liste på funksjonaliteter som må implementeres for å imøtekomme akseptansekriteriene: <ul type="1"><li>Implementere PickUpItem-funksjonen som (1) sjekker at spiller er på item, (2) sjekker om item er av typen *medkit* (liv) og (3) kaller på setHealth()-funksjonen.</li><li>Implementere klassen Medkits som extender Item-klassen. Denne klassen oppretter liv-objekter.</li><li>Implementere GetAmount()-funksjonen i Medkits som henter feltvariabelen som indikerer verdien til liv-objektet.</li><li>Implementere setHealth()-funksjonen som øker liv med den gitte mengden som liv-objektet har.</li></ul> |
| **Spiller kan bli flyttet på av fiende:** Som spiller ønsker jeg å bli ufrivillig flyttet på spillebrettet når jeg treffer en fiende (bombe) slik at spillet blir mer utfordrene å spille. | **Krav:** Et fiende-objekt (bombe) må kunne flytte spilleren ved kontakt.  **Kriterie:** Spilleren blir flyttet bortover spillebrettet uten at spilleren kan påvirke forflytningen. | Liste på funksjonaliteter som må implementeres for å imøtekomme akseptansekriteriene: <ul><li>Implementere klassen Bombs som extender klassen Enemy. Her defineres det som er spesielt for bombs-objektet, som f.eks type angrep.</li><li>Kalle på getAttack-funksjonen som deretter vil endre på *velocity* til spilleren slik at den flyttes på.</li></ul> |
| **Funksjonalitet her:** Som spiller/utvikler ønsker jeg å ... slik at ... | **Krav:** test  **Kriterie:** test  | Liste på funksjonaliteter som må implementeres for å imøtekomme akseptansekriteriene: <ul><li>Punkt1</li><li>Punkt2</li><li>Punkt3</li><li>Punkt4</li><li>Punkt5</li></ul> |

 - Vise fiender/monstre; de skal interagere med terreng og spiller  
 - Fikse jump (lande raskere ved å justere farten på vei ned, bestemme én fart som gjelder for hopp og på bakken)  
 - Spiller har poeng og interagerer med poenggjenstander  
 - Legge inn tester  

(*kan droppes*)  
 - Spiller kan dø (ved kontakt med fiender, eller ved å falle utfor skjermen)   
 - Mål for spillbrett (enten et sted, en mengde poeng, drepe alle fiender e.l.)   

 **Hvordan oppgavene fremover blir prioritert:**  

 **Endringer i rekkefølge på MVP utfra det som er gitt fra kunde:** "hvorfor er dette gjort?"  

 **Bugs i koden/kravene som er utført:**  


# 3. Produkt og kode
## 3.1 Utbedring av feil 
**Feil fikset fra forrige innlevering:**  
 - 

## 3.2 Annet
**Dokumentasjon om teknisk produktoppsett (hvordan bygge og kjøre programmet):** For å kjøre dette spillet trenger du først å laste ned en IDE (Integrated Development Environment) på din datamaskin og installere programvaren. En IDE er en programvare for å skrive og lage annen programvare, og det er her du kan kjøre koden for spillet som vi har laget. Noen av de mest populære IDE'ene å bruke er for eksempel [IntelliJ](https://www.jetbrains.com/idea/download/#section=mac) eller [VSCode](https://code.visualstudio.com/download). Husk å laste ned riktig versjon basert på om du bruker Mac, Windows eller Linux. Etter at du har lastet ned programvaren og installert den på din datamaskin gjenstår det å åpne filkoden til spillet og kjøre programmet. For å åpne filkoden må du først starte din IDE, deretter gå til "File" -> "Open" og deretter navigere deg fram til mappen som inneholder koden til spillet. Deretter markerer du denne mappen og trykker på "Open". Du skal nå kunne se hele koden til spillet i din IDE, med mulighet til å bla gjennom de ulike klassene i menyen til venstre. For å kjøre koden må du kjøre filen som heter *Main*. Denne ligger i package *inf112.skeleton.app*. For å kjøre *Main* kan du høyre-klikke på filen i menyen til venstre og velge *Run 'Main.main()'*. Dersom du har gjort dette riktig skal det komme opp et nytt vindu der spillet starter. Du kan nå spille spillet ved å bevege spilleren med piltastene eller ASWD og bruke space for å hoppe. Pass på å ikke gå inn i fiendene, men hopp heller oppå de for å drepe dem.  

Bilde av oppdatert project board her

Bilde av klassediagram her (kan muligens droppes til denne innleveringen)




