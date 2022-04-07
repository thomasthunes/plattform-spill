# Obligatorisk oppgave 3 - Navn på prosjekt: *Game*
**Team**: *Scrumbois* (Gruppe 3)  
**Gruppemedlemmer:**  
 - Thomas Thunes
 - Karl Martin Helset
 - Magnus Brodtkorb
 - Jonas Holgersen
 - Jon Kvinnsland  

**Prosjektbeskrivelse:** I dette spillet styrer du en spiller med enten piltaster eller ASWD, og bruker space til å la spilleren hoppe. Målet er å ikke dø, det vil si å ikke miste så mye liv at liv blir 0. Spilleren mister liv når den er i kontakt med en fiende, men kan drepe fienden ved å hoppe oppå den. Spilleren kan også plukke opp liv ved å trykke på "P" når den står på et liv-objekt (en rød sekk med et hvitt kors på).  

## Innholdsfortegnelse  
[[_TOC_]]  

# 1. Team og prosjekt
I denne delen av oppgaven vil vi gjennomgå (1) møtereferater og (2) en oppsummering av team og prosjekt.  

## 1.1 Møtereferater  
Møtereferatene oppsummerer hva som har blitt disuktert på de ulike møtene, eventuelle avgjørelser som er tatt og hvilke arbeidsoppgaver vi har fordelt frem til neste møte.  

### 1.1.1 Møte 1
**Dato:** 29.03  

**Deltakere:** Alle  

**Diskusjon:** På dette møtet reflekterte vi kort over hvordan vi syntes at utviklingen i prosjektet har vært frem til nå. Vi diskuterte blant annet vår rollefordeling og om det var behov for å endre på denne. Her ble vi enig om å fortsette med samme rollefordeling da den har fungert bra frem til nå. Videre diskuterte vi hvilke brukerhistorier vi vil fokusere på å implementere fram mot neste innlevering, og hvordan vi skulle fordele arbeidsoppgavene. Vi satte opp brukerhistoriene i en liste (se [2.2.1 Brukerhistorier](#221-brukerhistorier)) og oppdaterte vårt Project Board med arbeidsoppgaver knyttet til de nye brukerhistoriene.   

**Avgjørelser:** Vi tok en beslutning på å beholde samme rollefordeling som vi har hatt frem til nå.  

**Arbeidsoppgaver til neste møte:** Karl fortsetter på å implementere meny-skjerm. Jon starter på rapporten til neste innlevering. Thomas jobber med å forbedre koden slik at den blir mer oversiktlig, og jobber med å utvide spillebrettet. Jonas jobber videre med tester og Magnus avlaster de andre der det er behov.  

### 1.1.2 Møte 2
**Dato:** 05.04  

**Deltakere:** Alle  

**Diskusjon:** På dette møtet diskuterte vi hvordan vi ønsker å implementere funksjonalitet for poeng og poenggjenstander. Her fant vi ut at spillet blir mest interessant dersom fiendene er gjenstander for poeng, slik at spilleren må drepe fienden for å få poeng. Videre drøftet Karl noen utfordringer knyttet til implementasjonen av meny-skjerm, og her bidro Thomas og Magnus med innspill på hvordan disse utfordringene kunne løses. Vi diskuterte også implementasjonen av flere ulike spillebrett. Her så vi at det finnes flere ulike tilnærminger. Thomas sier han er usikker på hvilken implementasjon som vil passe best, men at han vil undersøke dette nærmere.  

**Avgjørelser:** Vi tok en avgjørelse på å la fiender være poenggjenstander der spilleren øker antall poeng etter å ha drept en fiende.   

**Arbeidsoppgaver til neste møte/innlevering 08.04:** Thomas fokuserer på implementeringen av flere spillebrett. Jon ferdigstiller rapporten til innleveringen. Karl fikser de siste implementasjonene som trengs for at meny-skjermen skal fungere og starter på brukerhistorien *lyd*. Jonas fortsetter å jobbe med tester og Magnus fikser forbedringspotensialer fra forrige innlevering slik som å oppdatere README-filen med prosjektbeskrivelse og teknisk produktoppsett.  

## 1.2 Oppsummering av team og prosjekt  
I denne delen av oppgaven oppsummerer vi hvordan arbeidet i gruppen har vært og reflekterer over utviklingen i prosjektet vårt.  
### 1.2.1 Roller  
Siden forrige innlevering (25.03) har vi merket lite behov for endring i vår rollefordeling. Basert på den positive erfaringen vi har hatt frem til nå med rollefordelingen har vi besluttet å fortsette med de samme rollene. Fra forrige innlevering merker vi også at hver enkelt gruppemedlem har spesialisert seg enda bedre i sin egen rolle. På denne måten drar vi godt nytte av å beholde samme rollefordeling, da økt spesialisering i hver enkelt rolle har bidratt til enda bedre kvalitet og effektivitet i arbeidet. Når det gjelder hva de ulike rollene faktisk innebærer for oss er det lite endringer fra forrige innlevering (25.03). Likevel har vi merket oss følgende:  

Thomas har merket at sin rolle som teamleder innebærer at han fortsatt må være tilstede på alle gruppemøter for å holde oversikt på utviklingsprosessen. Dette gjelder også spesielt nå som vi har startet på en ny innleveringsoppgave og skal implementere nye funksjonaliteter til spillet. Han merker også at han er blitt flinkere på å fordele arbeidsoppgaver fra sist.  

Magnus har merket at sin rolle som prosjektansvarlig innebærer at han forsatt må ha god oversikt på brukerhistoriene og ressursbruken som kreves for å implementere de. Dette gjelder spesielt nå som vi har lagt til flere nye brukerhistorier. Her merker også Magnus at han må samarbeide med Karl (Scrum Master) for å bistå Karl på hvilke detaljer som skal føres opp på de ulike arbeidsoppgavene i Project Boardet. Ellers merker også Magnus at han i rollen som prosjektansvarlig har blitt bedre på å fordele ressurser til implementasjonen av de ulike brukerhistoriene siden forrige innlevering.  

Karl har merket rollen som Scrum Master innebærer at han må være nøye på å spesifisere arbeidsoppgavene i backloggen slik at det blir tydelig og klart for hver enkelt gruppemedlem hva som skal gjøres. Ellers gjør Karl seg sine samme betraktninger som sist, nemlig at han må holde de andre gruppemedlemmene oppdatert på hvilke arbeidsoppgaver vi har i backloggen til enhver tid. Dette gjelder også spesielt for de nye arbeidsoppgavene som er kommet til som følge av nye brukerhistorier.  

Jonas merker at sin rolle som testansvarlig innebærer at han fortsatt må ha god forståelse for hvordan koden fungerer. Her merker han også at han må kontinuerlig oppdatere seg på hvilke implementasjoner spillet inneholder, da dette stadig endres etter hvert som nye funksjonaliteter legges inn.  

Jon har merket at rollen som kundekontakt innebærer at han må forsette å opprettholde kundekontakten frem mot neste innlevering. Han merker at han må være aktiv på å informere de andre gruppemedlemmene på hvilke forbedringspotensialer som kunden peker fra forrige innlevering, og sørge for at alle gruppemedlemmene vet hva som må gjøres for å imøtekomme kundens forslag til forbedringspotensialer.  

### 1.2.2 Erfaringer og valg  
Våre drøftelser knyttet til erfaringer og valg er omtrent de samme som ved forrige innlevering, da vi merker at vi ikke har jobbet lenge nok fra forrige innlevering til å gjøre oss noen vesentlige nye erfaringer.  

**Erfaringer team:** Erfaringene vi har gjort oss i teamet er at rollefordelingen har fungert bra, i tillegg til at vi har dratt nytte av samarbeid på tvers av roller som for eksempel mellom prosjektansvarlig og Scrum Master med tanke på brukerhistorier og arbeidsoppgaver i Project Board. Teammøtene har også bidratt til at vi kan diskutere mulige forbedringspotensialer fra forrige innlevering og hvordan vi kan løse disse. Ellers fortsetter vi også med parprogrammering da erfaringene har vist at dette gir gode resultater.  

**Erfaringer prosjektmetodikk:** Når det gjelder erfaringer relatert til prosjektmetodikk har vi merket fra forrige innlevering at tydeligere beskrivelse av de konkrete arbeidsoppgaver i backloggen har bidratt til mer effektiv ressursutnyttelse da det blir enklere å estimere hvor lang tid en gitt arbeidsoppgave tar. Her har vi også vært mer nøyaktige når vi estimerer hvor lang tid det tar å implementere en gitt funksjonalitet. Ellers er erfaringene knyttet til prosjektmetodikk de samme som sist, nemlig at Scrum-rammeverket med Project Board, backlogger og ukentlige møter legger godt til rette for et effektivt samarbeid.  

**Valg underveis:** Når det gjelder valg underveis gjør vi oss de samme betraktninger som sist, nemlig at vi er fornøyde med hvordan vi har håndtert ulike valg. Gjennom diskusjoner av ulike valgalternativer og mulige konsekvenser har vi også denne gang vært trygge på de valgene vi har tatt. 

### 1.2.3 Gruppedynamikk
Våre erfaringer når det gjelder gruppedynamikk er også de samme som sist. Ukentlige team-møter har gitt god oversikt på utviklingsprosessen, og åpenhet i diskusjonene har bidratt til god gruppedynamikk. Vi har fortsatt med å ha forventningsavklaringer til hverandre slik at vi unngår misfortåelser og opprettholder god kommunikasjon. Vi har også vært enda tydeligere på arbeidsoppgavene i vårt Project Board for å forbedre gruppedynamikken. Vi konkluderer med at valget av prosjektmetodikk (Scrum) lagt godt til rette for en god gruppedynamikk.  

### 1.2.4 Kommunikasjon
Kommunikasjonen i gruppen har fortsatt fungert bra, og her har vi ikke merket oss noen spesifikke nye erfaringer siden sist. Vi bruker de samme informasjonskanalene som tidligere (Messenger, Discord), og vi lytter og viser respekt til hverandres meninger i diskusjoner. De ukentlige møtene sørger også for god kommunikasjon i gruppen.  

### 1.2.5 Retrospektiv vurdering av prosjektstruktur
**Vurdering av hva vi har klart til nå:** Frem til nå har vi brukt Scrum-rammeverket godt. Vi har hatt ukentlige møter og oppdatert vårt Project Board fortløpende med nye arbeidsoppgaver. På denne måten har vi hatt god kommunikasjon og god oversikt på utviklingen i prosjektet. Vi gjør oss ellers det samme bemerkninger som sist, nemlig at parkoding har vært effektivt for å øke kvaliteten i koden og få frem flere idéer. Som nevnt tidligere har vi også hatt samarbeid på tvers av roller, for eksempel mellom prosjektansvarlig og scrum master, som har bidratt til bedre kommunikasjon og gruppedynamikk. Se forøvrig svar på de andre deloppgavene over, tilsvarende deloppgaver fra forrige innlevering og møtereferatene for refleksjon på hvordan vi vurderer kommunikasjon og arbeid i gruppen.

Når det gjelder forbedringspotensialene vi har satt oss fra forrige innlevering så ser vi at vi har blitt vesentlig flinkere på samtlige. Når det gjelder forbedringspotensialet "Bli flinkere på å ha kontroll på git (push/pull)" så opplever vi fortsatt noe problemer med push/pull av kode. Her har vi imidlertid studert feilmeldingene nøye slik at vi har fått en bedre forståelse av hvorfor vi opplever de problemene vi har. Blant annet har vi merket at vi må være nøye på å pulle kode fra git slik at en alltid har den siste versjonen av koden før en så pusher egne endringer til git. Dette har ført til at vi har blitt flinkere på å ha kontroll på git. Når det gjelder det neste forbedringspotensialet "fordeling av arbeidsoppgaver" har vi også blitt mer effektiv og sørget for at alle har noe å jobbe med. For eksempel, så diskturer vi på hvert møte hvordan vi skal fordele arbeidsoppgavene fra Project Boardet frem mot neste møte. Når det gjelder det siste forbedringspotensialet om å "Bli flinkere på å bestemme tidsintervaller ved implementasjon av ny funksjonalitet" har vi satt opp kortere tidsfrister på mindre implementasjoner og tilsvarende lengre tidsfrister på større implementasjoner. På denne måten har vi også blitt bedre på ressursfordelingen i gruppen. For eksempel, så har vi satt opp en kortere sprint-periode på brukerhistorien for meny-skjerm slik at vi også ser at det er plass for å legge til brukerhistorien for lyd.  

**Hva vi mener kan forbedres:** Frem mot neste innlevering mener vi at vi kan bli flinkere til å ...


### 1.2.6 Forskjeller i commits
Fra oblig 1: "Vi har hatt noen forskjeller underveis i prosjektet i antall commits mellom teammedlemmer. Dette skyldes at vi har brukt mye parkoding slik at det ofte kun er én av to som comitter koden til git. Videre har vi også fordelt arbeidet slik at noen fokuserer mer på å skrive rapport. Dette bidrar også til ulikheter i commits."  

### 1.2.7 Forbedring
Basert på den retrospektive vurderingen ([1.2.5](#125-retrospektiv-vurdering-av-prosjektstruktur)) har vi satt opp følgende liste med forbedringspotensialer til neste sprint:  
1. Forbedre beskrivelse på ulike arbeidsoppgaver i Project Board  
2.  
3.  

# 2. Krav
I denne delen av oppgaven vil vi gå gjennom (1) vårt stretch goal for oppgaven og (2) brukerhistorier fra MVP med tilhørende oppfølgingsspørsmål.  

## 2.1 "Stretch goal"
Som stretch goal har vi valgt å fokusere på funksjonalitet for multiplayer. Vi har startet på implementasjonen for multiplayer, men den er ikke klar til denne innleveringen. Vi fokuserer også på å ha høy kvalitet på koden, godt design og klare abstraksjoner.  

## 2.2 MVP og annet
I denne delen av oppgaven vil vi (1) oppsummere brukerhistoriene og (2) svare på oppfølgingsspørsmål knyttet til brukerhistoriene og kommentere kjente bugs knyttet til dem.  

### 2.2.1 Brukerhistorier
For beskrivelse av hva en brukerhistorie er og hvordan vi har satt dem opp se [innledende kommentar](https://git.app.uib.no/scrumbois/plattform-spill/-/blob/master/Deliverables/ObligatoriskOppgave1.md#32-brukerhistorier) fra første innlevering. Brukerhistoriene her følger samme format, og er oppsummert sammen med akseptansekriterier og arbeidsoppgaver i tabellen under. Etter tabellen følger det også en prioritert liste over hvilke brukerhistorier vi ønsker å ha med i første sprint/iterasjon.  

| Brukerhistorier  | Akseptansekriterier | Arbeidsoppgaver |
|---|---|---|
| **2D spillebrett:** Som spiller ønsker jeg å se et spillebrett, slik at jeg kan orientere meg. | <ul><li>**Krav:** Vise et 2D spillebrett.  </li><li>**Kriterie:** Når programmet kjøres vises et vindu med grafikk til spillebrettet.</li></ul> | For å imøtekomme akseptansekriteriene må klassen *Play* implementeres. Denne klassen implementerer interfacet *Screen*. Videre så vil klassen *Play* sørge for at når koden kjøres så vil et map rendres, sette posisjonen til en spiller (spilleren kommer fra klassen *Player*) og sette opp *Orthographic camera* som følger skjermen. |
| **Spiller:** Som utvikler ønsker jeg å kunne bevege spillebrikken i spillet med piltastene og space for å teste funksjonene til spillebrettet og se om disse fungerer slik det skal. | <ul><li>**Krav:** Spilleren må kunne bevege seg.   </li><li>**Kriterie:** Når en piltast trykkes beveges spillebrikken den retningen piltasten peker, og dersom en trykker *space* skal spillebrikken hoppe.</li></ul> | For å imøtekomme akseptansekriteriene må klassen *Player* implementeres. Denne klassen utvider den abstrakte klassen *Sprite* fra LibGDX-biblioteket. I klassen *Player* vil en spiller opprettes som et objekt av typen *Player*. Videre vil feltvariablene *Speed*, *Gravity* og *Velocity* i klassen *Player* settes. Disse feltvariablene beskriver hvordan spilleren beveger seg med tanke på hurtighet (*Speed*), tyngdekraft (*Gravity*) og i hvilken retning (*Velocity*). Klassen *Player* vil også inneholde en metode *Update* som endrer på posisjonen til spiller-objektet avhenigig av verdien på feltvariabelen *Velocity*. *Update* sjekker også om spilleren treffer en celle som er *blocked*, og i så fall vil *Velocity* settes til 0. |
| **Vegger/blokker:** Som utvikler ønsker jeg vegger og blokker slik at jeg kan implementere funksjoner som sørger for at en spiller ikke kan bevege seg gjennom disse objektene. | <ul><li>**Krav:** Spilleren må stoppe når den treffer en vegg eller blokk.  </li><li>**Kriterie:** Når en spiller beveger seg bort mot en vegg eller blokk, kan den ikke passere veggen eller blokken. Spilleren kan imidlertid hoppe over eller på blokken for å passere den.</li></ul> | Her bruker vi *Tiled* for å implementere akseptansekriteriene. Først setter vi egenskapen *blocked* til celle-objektet i det rette tiled-layeret til å være *blocked*. Videre sjekker vi i metoden *Update* fra klassen *Player* om spilleren treffer en celle som er blocked. Hvis spilleren treffer en celle som er *blocked* vil feltvariabelen *Velocity* endres til 0. Som konsekvens vil da vil spilleren stoppe. |
| **Fiender/monstre:** Som spiller ønsker jeg å kunne møte på fiender slik at spillet har utfordringer som gjør det spennende å spille. | <ul><li>**Krav:** Må kunne se en fiende som et objekt på spillebrettet.  </li><li>**Kriterie:** Når spilleren treffer en fiende så mister den liv. Dersom den treffer en fiende mange nok ganger vil den til slutt dø.</li></ul> | Liste på funksjonaliteter som må implementeres for å imøtekomme akseptansekriteriene: <ol type="1"><li>Implementere klassen Enemy. Denne klassen extender klassen Player slik at en fiende får de samme egenskapene som player (gravity, collision layer)</li><li>Opprette Enemy-objekter med en tilfeldig posisjon på brettet. Dette skjer samtidig som ny spiller blir opprettet.</li><li>Implementere brukerhistorien *Spiller kan dø* (se under) slik at spilleren mister liv ved kontakt med fiende.</li></ol> |
| **Spiller kan dø:** Som spiller ønsker jeg mulighet til å kunne dø slik at implementasjonen av fiender blir meningsfull. Dette gir da et insentiv til å overkomme fiendene og gjør dermed spillet mer spennende. | <ul><li>**Krav:** Dersom spilleren dør kan den ikke lenger bevege seg i spillet og spillet er dermed over.  </li><li>**Kriterie:** Når spilleren har mistet en gitt mengde med liv skal den være død.</li></ul>  | Liste på funksjonaliteter som må implementeres for å imøtekomme akseptansekriteriene: <ol type="1"><li>Implementere metoden isAttacked. Denne metoden vil kalle på funksjonen getAttack når spilleren blir angrepet.</li><li>Implementere getAttack: Denne funksjonen vil enten sette ned liv på spiller eller forlytte spilleren, avhengig av om fienden er en bombe eller en fiende som dreper/setter ned liv.</li><li>Implementere metoden Attack: Denne metoden iterer over alle fiender og sjekker om spiller kolliderer med en fiende fra toppen eller fra siden.</li><li>Implementere metodene collidesWithActorFromTop og collidesWithActorFromSide i klassen Item som skal brukes i Attack.</li><li>Implementere metoden inBounds som sjekker om spiller faller ut av mappet, og i så fall la spilleren miste liv slik at den dør.</li></ol> |
| **Liv:** Som spiller ønsker jeg å å kunne plukke opp liv slik at jeg kan helbrede meg selv etter å ha truffet på en fiende, og på denne måten unngå å dø. | <ul><li>**Krav:** Objekter som gir spilleren liv må være plassert på spillebrettet.  </li><li>**Kriterie:** Når spilleren går bort til et liv-objekt kan den plukke opp pakken med liv ved å trykke på "P" slik at liv til spilleren øker.</li></ul> | Liste på funksjonaliteter som må implementeres for å imøtekomme akseptansekriteriene: <ol type="1"><li>Implementere PickUpItem-funksjonen som (1) sjekker at spiller er på item, (2) sjekker om item er av typen *medkit* (liv) og (3) kaller på setHealth()-funksjonen.</li><li>Implementere klassen Medkits som extender Item-klassen. Denne klassen oppretter liv-objekter.</li><li>Implementere GetAmount()-funksjonen i Medkits som henter feltvariabelen som indikerer verdien til liv-objektet.</li><li>Implementere setHealth()-funksjonen som øker liv med den gitte mengden som liv-objektet har.</li></ol> |
| **Spiller kan bli flyttet på av fiende:** Som spiller ønsker jeg å bli ufrivillig flyttet på spillebrettet når jeg treffer en fiende (bombe) slik at spillet blir mer utfordrene å spille. | <ul><li>**Krav:** Et fiende-objekt (bombe) må kunne flytte spilleren ved kontakt.  </li><li>**Kriterie:** Spilleren blir flyttet bortover spillebrettet uten at spilleren kan påvirke forflytningen.</li></ul> | Liste på funksjonaliteter som må implementeres for å imøtekomme akseptansekriteriene: <ol type="1"><li>Implementere klassen Bombs som extender klassen Enemy. Her defineres det som er spesielt for bombs-objektet, som f.eks type angrep.</li><li>Kalle på getAttack-funksjonen som deretter vil endre på *velocity* til spilleren slik at den flyttes på.</li></ol> |
| **Nøkkel:** Som spiller ønsker jeg å kunne plukke opp en nøkkel når jeg beveger meg gjennom spillebrettet slik at spillet blir utfordrene og har et mål ved seg (plukke opp nøkkel og gå i mål). Nøkkelen kreves for å vinne spillet. | <ul><li>**Krav:** Spiller må ha plukket opp nøkkel <ins>før</ins> spilleren går i mål-området for å kunne vinne spillet.</li><li>**Kriterie:** Det må finnes en nøkkel på spillebrettet, og spilleren må ha mulighet til å plukke opp denne nøkkelen.</li></ul>  | Liste på funksjonaliteter som må implementeres for å imøtekomme akseptansekriteriene: <ol type="1"><li>Implementere klassen *Key* som extender klassen *Item*. I klassen *Key* spesifiseres hva som er spesifikt for et Nøkkel-objekt, nemlig størrelse og navn.</li><li>Implementere funksjonen *getKey* i klassen *ItemFactory* som genererer nye nøkler og plasser dem på spillebrettet.</li><li>Kalle på *getKey()*-funksjonen inne i *show()*-funksjonen i klassen Play, slik at nye Nøkkel-objekter bli initialisert og plassert på spillebrettet når nytt spillebrett lastes inn.</li></ol> |
| **Meny-skjerm:** Som spiller ønsker jeg å kunne se en start-skjerm med en meny når jeg starter spillet slik at jeg kan velge om jeg skal (1) starte spillet med én spiller (Play), eller om jeg (2) skal starte spillet med multiplayer eller (3) om jeg ønsker å avslutte spillet (Exit).  | <ul><li>**Krav:** En meny med ulike valgalternativer må komme opp på skjermen når spillet startes (kjører filen *Main*). </li><li>**Kriterie:** Spilleren må kunne et alternativ fra menyen. </li></ul>  | Liste på funksjonaliteter som må implementeres for å imøtekomme akseptansekriteriene: <ol type="1"><li>Implementere klassen *MenuScreen* som extender klassen *Game* og implementerer klassen *Screen*. Denne klassen vil lage en ny meny-skjerm når spillet startes, bestående av en bakgrunn, knapper for å starte spill en eller to spillere (Multiplayer) og knapp for exit. Her legger vi også til bakgrunnsmusikk til meny-skjermen.</li><li>Opprette et nytt *MenuScreen*-objekt i klassen *app* og sette dette som første skjerm som kommer opp når spillet startes</li></ol> |
| **Poeng:** Som spiller ønsker jeg å ha mulighet til å få poeng når jeg spiller slik at jeg kan sammenlikne min egen prestasjon mot tidligere spill av meg selv eller andre. På denne måten kan jeg som spiller måle om jeg har blitt flinkere i spillet. | <ul><li>**Krav:** Gjenstander som gir poeng må være plassert på spillebrettet. I vårt spill har vi valgt at fiender/monstre skal være gjenstander som gir poeng når spilleren dreper disse (hopper på de). </li><li>**Kriterie:** Spiller må ha mulighet til å interagere med gjenstandene som gir poeng, altså å hoppe på fienden slik at den dør. Videre må antall poeng for spilleren må oppdateres når spilleren interagerer med gjenstanden som gir poeng (hopper på fienden). </li></ul>  | Liste på funksjonaliteter som må implementeres for å imøtekomme akseptansekriteriene: <ol type="1"><li>Legge til feltvariabelen *killStreak* på hvert spillerobjekt i klassen *mainPlayer*</li><li>Oppdatere feltvariabelen *killStreak* i funksjonen *attack()* dersom spilleren dreper en fiende.</li></ol> |
| **Lyd:** Som spiller ønsker jeg å kunne høre lyd når jeg spiller slik at det blir mer spennende og interessant å spille. | <ul><li>**Krav:** Det må være mulig å høre lyder fra spillet når spillet kjøres.</li><li>**Kriterie:** Det må være ulike lyder for ulike deler av spillet som tilfører en mening/verdi til spilleren. Dette gjelder for eksempel egen bakgrunnslyd for meny-skjerm, egen bakgrunnslyd for første spillebrett, andre spillebrett osv. I tillegg må det også være lydeffekter når spilleren hopper.</li></ul>  | Liste på funksjonaliteter som må implementeres for å imøtekomme akseptansekriteriene: <ol type="1"><li>Bruke libGDX-biblioteket til å legge inn lyd i klassen *MenuScreen* som feltvariabel til et *MenuScreen*objekt</li><li>Bruke det samme libGDX-biblioteket til å legge inn lyder på andre objekter slik som *Key*.</li></ol> |
| **Game Over-skjerm:** Som spiller ønsker jeg å se en skjerm som viser "Game Over" når jeg dør i spillet slik at det blir tydelig for spilleren at spillet er over. | <ul><li>**Krav:** En egen skjerm som viser "Game Over" må vises når spilleren dør.</li><li>**Kriterie:** Game Over-skjermen vises når spilleren har mistet alt liv og dermed er død.</li></ul>  | Liste på funksjonaliteter som må implementeres for å imøtekomme akseptansekriteriene: <ol type="1"><li>Implementere klassen *GameOverScreen* som oppretter et nytt objekt som brukes når spilleren har mistet alt liv.</li><li>Kalle på *GameOver* objektet i *update()*-funksjonen i klassen *mainPlayer*.</li></ol> |

### 2.2.2 Oppfølgingsspørsmål brukerhistorier
**Prioritert liste på krav:**  
1. Nøkkel  
2. Meny-skjerm  
3. Poeng
4. Lyd  
5. Game Over-skjerm  

**Hvor langt vi har kommet og hva vi har gjort siden forrige gang:** Siden forrige gang har vi implementert brukerhistoriene *Nøkkel*, *Meny-skjerm*, *Poeng* og *Lyd*. Når det gjelder brukerhistorien for meny-skjerm har vi ikke lagt til valget for multiplayer enda, da denne funksjonaliteten ikke er ferdig implementert i spillet. Brukerhistorien for lyd er også ferdig implementert, men vi har ikke lagt til lyd for andre spillebrett da vi foreløpig kun har ett spillebrett. Brukerhistorien for Game Over-skjerm er ikke implementert enda, og denne planlegger vi å implementere til neste innlevering. Videre har vi siden forrige innlevering forbedret eksisterende kode som for eksempel å legge til flere typer fiender, i tillegg til å legge til en sone på spillebrettet der spilleren er ferdig med spillet.  

**Hvordan ny funksjonalitet prioriteres:** Frem til denne innleveringen har vi valgt å prioritere alle kravene fra MVP (1-10) bortsett fra vårt stretch goal om multiplayer som vi venter med til siste innlevering. Ettersom dette er den vanskeligste brukerhistorien har vi frem til nå hatt fokus på å sørge for god implementasjon av de andre brukerhistoriene. Vi har også startet på å implementere nye spillebrett for spilleren etter at spilleren er kommet i mål.  

**Hvordan oppgavene fremover blir prioritert:** Fremover vil vi prioritere implementasjonen av multiplayer, da dette er den siste viktige implementasjonen av spillet. Vi vil også implementere ferdig nye spillebrett. Ellers er vi er fornøyde med de øvrige implementasjonene, men vil også forbedre funksjonaliteten på noen av disse der vi ser at det er hensiktsmessig.  

**Endringer i rekkefølge på MVP utfra det som er gitt fra kunde:** I denne innleveringen har vi ikke foretatt nye endringer i rekkefølgen på MVP siden sist.  

**Bugs i koden/kravene som er utført:**  
*Fra forrige innlevering:*  
 - "Map'et følger ikke skjermen når spilleren går helt til enden av map'et. Da blir skjermen svart på sidene.  
 - Dersom du endrer størrelsen på skjermen til spillet så blir den svart og alle gjenstander forsvinner. Når du resizer vinduet så faller spilleren ut av spillet  
 - Noen av datamaskinene vi har kjørt spillet på lar ikke spilleren hoppe på en fiende og deretter hoppe på en ny fiende. Den kan kun hoppe på én fiende."  

# 3. Produkt og kode

## 3.1 Utbedring av feil 
**Feil fikset fra forrige innlevering:**   
 

**Nåværende Prjoct Board:**  
![alt text](/assets/maps/trello3.png)  

**Klassediagram:**  




