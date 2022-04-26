# Møtereferater
Denne filen inneholder møtereferater fra alle møter som gruppen har hatt underveis i prosjektet.  

## Møte 1
**Dato:** 01.03  

**Deltakere:** Alle  

**Diskusjon:** På dette møtet diskuterte vi hvordan vi skulle sette rammene for prosjektet vårt frem mot neste innlevering. Vi identifiserte fire hovedutfordringer som vi mener vil kreve ekstra fokus, deriblant (1) legge til fiender/monstre, (2) la spilleren ha liv og mulighet til å miste liv når den treffer for eksempel fiender, (3) fikse hoppe-funksjonen slik at spilleren hopper realistisk og (4) legge til tester for koden. Videre diskuterer vi også utfordringer knyttet til organiseringen av prosjektet. Dette gjelder spesielt kodebasen i git der vi opplever mye *merge conflicts* ved pushing/pulling av kode. Dette diskuterer vi også med studentassistenten og får veiledning på hvordan dette kan løses. Her lærte vi å bruke egen branch som vi pusher og puller til når vi jobber med en bestemt funksjonalitet, og deretter merger denne branchen med vår master-branch når funksjonaliteten er ferdig implemtert.  

**Avgjørelser:** På dette møtet tok vi en avgjørelse om at spilleren skal ha en egen fart når den er i luften og gi den gravitet når den beveger seg oppover i hoppet. På denne måten ser vi for oss å kunne simulere en mer realistisk hoppefunksjon. Vi ble også enige om at Jon skriver møtereferater for alle møter frem mot neste innlevering.  

**Arbeidsoppgaver til neste møte:** Thomas starter på å legge til liv til spilleren og mulighet for at spilleren kan miste liv og dø. Karl og Magnus vil forsøke å fikse hoppe-funksjonen, Jonas jobber med tester og Jon bistår på hoppe-funksjonen i tillegg til å skrive møtereferat. Vi forventer ikke at funksjonene og testene skal være ferdig implementert til neste møte, men vi forventer noe progresjon.  


## Møte 2
**Dato:** 08.03  

**Deltakere:** Alle  

**Diskusjon:** På dette møtet oppdaterte vi hverandre på hva vi hadde gjort fra forrige møte. Karl og Magnus har implementert hoppefunksjonen, men merker at spilleren har mulighet til å ta løpefart. Dette ser urealistisk ut og vi finner ut at vi kan sette ned farten på spilleren og bruke den samme farten når den hopper. Thomas bemerker også at *collision*-funksjonaliteten til spilleren inneholder overflødig kode og kan forkortes. Jon sier at han kan se nærmere på dette. Vi diskuterer også hvordan vi synes at prosjektmetodikken fungerer. Her kommenterer Magnus at ikke alle sprinter trenger å vare i 14 dager, da for eksempel hoppefunksjonen er ferdig implementert allerede nå. Dette gjør oss mer oppmerksom på hvordan vi skal fordele ressurser fremover, og at vi kan planlegge å starte på noen oppgaver fra backloggen tidligere enn antatt.  

**Avgjørelser:** Vi bestemte oss også å sette ned farten til spilleren og la den ha samme fart når den hopper, da dette ser mer realistisk ut (spiller kan da ikke ta «løpefart»). Vi tar også en beslutning om å korte ned sprintene på enkelte arbeidsoppgaver der vi finner det hensiktsmessig.  

**Arbeidsoppgaver til neste møte:** Jon jobber med å forkorte collision-funksjonen og gjøre den mer dynamisk. Karl og Magnus setter ned farten på spilleren. Thomas starter på funksjonalitet for fiender, og Jonas ser på testing av koden.  


## Møte 3
**Dato:** 15.03  

**Deltakere:** Alle  

**Diskusjon:** På dette møtet blir vi enige om å ikke fordele noe særlig med arbeidsoppgaver til neste møte, da flertallet er opptatt med andre innleveringer denne uken. Vi blir dermed enige om å ha lave forventninger til progresjon på prosjektet frem mot neste møte. Videre gikk vi gjennom hva vi ser for oss rapporten til neste innlevering skal inneholde, og Jon sier han kan starte på denne da han ikke har andre innleveringer denne uken.  

**Avgjørelser:** Forventningsavklaring om lite progresjon frem mot neste møte.  

**Arbeidsoppgaver til neste møte:** Jon jobber med rapporten frem mot neste møte.  


## Møte 4
**Dato:** 22.03  

**Deltakere:** Alle  

**Diskusjon:** På dette møtet diskuterte vi hvordan vi skal jobbe frem mot innleveringen på fredag. Vi går gjennom evalueringen vi fikk på forrige innlevering og ser på mulige forbedringspotensialer. Vi diskuterer også hovedutfordringene som vi identifiserte på første møte og ser at det kun er fiender/monstre og tester som gjenstår. Thomas har til nå startet litt på klassen for fiender (Enemy), men merker at han bruker mye gjenbruk av tidligere kode. Her diskuterer vi oss frem til at vi kan lage en abstrakt klasse som gjelder for både spiller og fiende, slik at vi reduserer gjenbruk av kode.  

**Avgjørelser:** På dette møtet tok vi en avgjørelse om å ha en abstrakt klasse som gjelder for både main player og enemy.  

**Arbeidsoppgaver til neste møte/innlevering 25.03:** Jon jobber med å ferdigstille rapporten, Karl begynner på å lage en Menu-screen, Thomas jobber med å legge til fiender og utvide map’et og Jonas jobber med tester. Magnus avlaster de andre på programmeringsoppgaver der det er behov.  

## Møte 5
**Dato:** 29.03  

**Deltakere:** Alle  

**Diskusjon:** På dette møtet reflekterte vi kort over hvordan vi syntes at utviklingen i prosjektet har vært frem til nå. Vi diskuterte blant annet vår rollefordeling og om det var behov for å endre på denne. Her ble vi enig om å fortsette med samme rollefordeling da den har fungert bra frem til nå. Videre diskuterte vi hvilke brukerhistorier vi vil fokusere på å implementere fram mot neste innlevering, og hvordan vi skulle fordele arbeidsoppgavene. Vi satte opp brukerhistoriene i en liste (se [2.2.1 Brukerhistorier](#221-brukerhistorier)) og oppdaterte vårt Project Board med arbeidsoppgaver knyttet til de nye brukerhistoriene.   

**Avgjørelser:** Vi tok en beslutning på å beholde samme rollefordeling som vi har hatt frem til nå.  

**Arbeidsoppgaver til neste møte:** Karl fortsetter på å implementere meny-skjerm. Jon starter på rapporten til neste innlevering. Thomas jobber med å forbedre koden slik at den blir mer oversiktlig, og jobber med å utvide spillebrettet. Jonas jobber videre med tester og Magnus avlaster de andre der det er behov.  

## Møte 6
**Dato:** 05.04  

**Deltakere:** Alle  

**Diskusjon:** På dette møtet diskuterte vi hvordan vi ønsker å implementere funksjonalitet for poeng og poenggjenstander. Her fant vi ut at spillet blir mest interessant dersom fiendene er gjenstander for poeng, slik at spilleren må drepe fienden for å få poeng. Videre drøftet Karl noen utfordringer knyttet til implementasjonen av meny-skjerm, og her bidro Thomas og Magnus med innspill på hvordan disse utfordringene kunne løses. Vi diskuterte også implementasjonen av flere ulike spillebrett. Her så vi at det finnes flere ulike tilnærminger. Thomas sier han er usikker på hvilken implementasjon som vil passe best, men at han vil undersøke dette nærmere.  

**Avgjørelser:** Vi tok en avgjørelse på å la fiender være poenggjenstander der spilleren øker antall poeng etter å ha drept en fiende.   

**Arbeidsoppgaver til neste møte/innlevering 08.04:** Thomas fokuserer på implementeringen av flere spillebrett. Jon ferdigstiller rapporten til innleveringen. Karl fikser de siste implementasjonene som trengs for at meny-skjermen skal fungere og starter på brukerhistorien *lyd*. Jonas fortsetter å jobbe med tester og Magnus fikser forbedringspotensialer fra forrige innlevering slik som å oppdatere README-filen med prosjektbeskrivelse og teknisk produktoppsett.  


## Møte 7


## Møte 8

