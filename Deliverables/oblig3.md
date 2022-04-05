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

**Diskusjon:** På dette møtet diskuterte vi hvilke brukerhistorier vi vil fokusere på å implementere fram mot neste innlevering, og hvordan vi skulle fordele arbeidsoppgavene.  

**Avgjørelser:**  

**Arbeidsoppgaver til neste møte:**  

## 1.2 Oppsummering av team og prosjekt  
I denne delen av oppgaven oppsummerer vi hvordan arbeidet i gruppen har vært og reflekterer over utviklingen i vårt prosjekt.  
### 1.2.1 Roller  
*Kort oppsummering av roller her*  

*Person1* har merket at sin rolle som *rolle* innebærer at han må ...  


### 1.2.2 Erfaringer og valg  
**Erfaringer team:**  

**Erfaringer prosjektmetodikk:**   

**Valg underveis:**   


### 1.2.3 Gruppedynamikk

### 1.2.4 Kommunikasjon

### 1.2.5 Retrospektiv vurdering av prosjektstruktur
**Vurdering av hva vi har klart til nå:**  

**Hva vi mener kan forbedres:**  


### 1.2.6 Forskjeller i commits
Vi har hatt noe forskjeller commits mellom teammedlemmer underveis i prosjektet. Dette skyldes at vi har brukt mye parkoding slik at det ofte kun er én av to som comitter koden til git. Videre har vi også fordelt arbeidet slik at noen fokuserer mer på å skrive rapport. Dette bidrar også til ulikheter i commits.  

### 1.2.7 Forbedring
Basert på den retrospektive vurderingen ([1.2.5](#125-retrospektiv-vurdering-av-prosjektstruktur)) har vi satt opp følgende liste med forbedringspotensialer til neste sprint:  
1. 
2. 
3. 

# 2. Krav
I denne delen av oppgaven vil vi gå gjennom (1) ... og (2) ...

## 2.1 "Stretch goal"


## 2.2 MVP og annet

### 2.2.1 Krav og funksjonalitet
*Hele 2.2.1 bør vurderes å sette inn under 2.2.2*

*"Oppgave: Oppdater hvilke krav dere har prioritert, hvor langt dere har kommet og hva dere har gjort siden forrige gang. Er dere kommet forbi MVP? Forklar hvordan dere prioriterer ny funksjonalitet"* 


### 2.2.2 Brukerhistorier
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
| **Brukerhistorie her:** Som spiller/utvikler ønsker jeg å ... når jeg ... slik at ... | <ul><li>**Krav:** </li><li>**Kriterie:** </li></ul>  | Liste på funksjonaliteter som må implementeres for å imøtekomme akseptansekriteriene: <ol type="1"><li>Noe her</li><li>Noe her</li><li>Noe her</li></ol> |

**Prioritert liste på krav:**  
1. Start-skjerm og game over  
2. Keys og poenggjenstander  
3. 

Jobber også med å bytte map når spiller har kommet til mål/portal, utbedring mappet, tester og mål for spillet.  

**Hvor langt vi har kommet og hva vi har gjort siden forrige gang:** 

**Hvordan ny funksjonalitet prioriteres:**  

**Hvordan oppgavene fremover blir prioritert:**  

**Endringer i rekkefølge på MVP utfra det som er gitt fra kunde:**  

**Bugs i koden/kravene som er utført:**  


# 3. Produkt og kode
I denne delen av oppgaven vil vi gjennomgå (1) ... og (2) ...  

## 3.1 Utbedring av feil 
**Feil fikset fra forrige innlevering:**   

## 3.2 Annet
**Dokumentasjon om teknisk produktoppsett (hvordan bygge og kjøre programmet):** For å kjøre dette spillet trenger du først å laste ned en IDE (Integrated Development Environment) på din datamaskin og installere programvaren. En IDE er en programvare for å skrive og lage annen programvare, og det er her du kan kjøre koden for spillet som vi har laget. Noen av de mest populære IDE'ene å bruke er for eksempel [IntelliJ](https://www.jetbrains.com/idea/download/#section=mac) eller [VSCode](https://code.visualstudio.com/download). Husk å laste ned riktig versjon basert på om du bruker Mac, Windows eller Linux. Etter at du har lastet ned programvaren og installert den på din datamaskin gjenstår det å åpne filkoden til spillet og kjøre programmet. For å åpne filkoden må du først starte din IDE, deretter gå til "File" -> "Open" og deretter navigere deg fram til mappen som inneholder koden til spillet. Deretter markerer du denne mappen og trykker på "Open". Du skal nå kunne se hele koden til spillet i din IDE, med mulighet til å bla gjennom de ulike klassene i menyen til venstre. For å kjøre koden må du kjøre filen som heter *Main*. Denne ligger i package *inf112.skeleton.app*. For å kjøre *Main* kan du høyre-klikke på filen i menyen til venstre og velge *Run 'Main.main()'*. Dersom du har gjort dette riktig skal det komme opp et nytt vindu der spillet starter. Du kan nå spille spillet ved å bevege spilleren med piltastene eller ASWD og bruke space for å hoppe. Pass på å ikke gå inn i fiendene, men hopp heller oppå de for å drepe dem.  

**Nåværende Prjoct Board:**  
![alt text](/assets/maps/trelloX.png)  

**Klassediagram:**  




