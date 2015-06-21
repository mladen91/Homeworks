Weekend Homework #5
 


Zadatak 1

Napisati dvije klase:

1.	StoryElement klasa (abstract) 

a.	Klasa koja opisuje jedan element u radnji jedne pri�e 

b.	Sadr�i atribut imena 

c.	Sadr�i dva konstruktora 

i.	Konstruktor koji inicijalizira ime na datu vrijednost 

ii.	Prazni konstruktor koji inicijalizira, preko prvog konstruktora, ime na �STElement� 

2.	Character klasa koja naslje�uje StoryElement klasu 

a.	Klasa koja opisuje jednog lika u radnji jedne pri�e 

b.	Sadr�i spol karaktera 

c.	Sadr�i atribut koji opisuje da li je lik �iv ili ne (default je true) 

d.	Sadr�i atribut koji opisuje da li je lik sposoban ili ne 

e.	Sadr�i metodu koja... ubija lika 

f.	Sadr�i metodu koja pretvara nesposobnog lika u sposobnog 

g.	Konstruktor koji inicijalizira ime, spol karaktera i sposobnost karaktera 

Zadatak 2

Napisati dvije klase:

1.	Event klasa 

a.	Klasa koja opisuje doga�aj u radnji jedne pri�e 

b.	Klasa sadr�i samo konstante i to: 

i.	Poraz 

ii.	Prijateljstvo 

iii.	Ljubav 

iv.	Osveta 

v.	Manipulacija 

2.	Goal klasa koja naslje�uje StoryElement klasu 

a.	Klasa koja opisuje cilj jednog lika u radnji jedne pri�e 

b.	Sadr�i atribut te�ine bazirano na tri vrijednosti (lagano, te�ko i nemogu�e) 

c.	Sadr�i atribut koji opisuje �ta (Event) se treba desiti da se ispuni cilj 

d.	Sadr�i atribut koji opisuje kome ili sa kim (Character) se treba desiti doga�aj pod c. 

e.	Sadr�i konstruktor koji inicijalizira tri pomenuta atributa, kao i ime cilja 
 
Zadatak 3

Napisati klasu:

1.	Protagonist klasa koja naslje�uje Character klasu 

a.	Opisuje glavnog pozitivca u pri�i 

b.	Sadr�i atribut koji opisuje glavni cilj (Goal) lika 

c.	Sadr�i jedan niz, kao atribut, likova (Character) koji poma�u glavnom liku (max. 3) 

d.	Sadr�i jedan atribut koji ozna�ava glavnog neprijatelja (Character) 

i.	Dati atribut mo�e biti null 

e.	Sadr�i konstruktor koji inicijalizira ime, spol, sposobnost i cilj lika 

f.	Sadr�i metodu koja postavi glavnog neprijatelja 

g.	Sadr�i metodu koja doda jednog lika koji �e pomo�i glavnom liku 

i.	Pomenuta metoda se mo�e samo �etiri puta pozvati (peti throw-a exception) 

Zadatak 4

Napisati metodu:

1.	Metoda attainGoal() u klasi Protagonist 

a.	Metoda koja pokrene ciklus borbe glavnog lika i poku�aja da doku�i svoj cilj 

b.	Metoda ne mo�e raditi ukoliko glavni lik nije �iv 

c.	Metoda izra�una kolika je �ansa da glavni lik doku�i svoj cilj 

i.	Ukoliko je glavni lik sposoban onda +40% 

ii.	Za svakog sposobnog pomo�nog lika +20% 

iii.	Ukoliko je glavni neprijatelj sposoban onda -30% 

iv.	Ukoliko je cilj te�ak onda -20% 

v.	Ukoliko je cilj nemogu� onda -100% 

vi.	�ansa uvijek mora biti izme�u 0 i 100% 

d.	Bazirano na izra�unatoj �ansi metoda odlu�i da li je lik uspio ili ne 

i.	Uspjeh: 

1.	Ispisati na konzolu da je lik uspio i u �emu (Goal) je uspio 

2.	Napraviti jednog lika (nasumi�no izabranog) sposobnim (ako nije bio) 

ii.	Neuspjeh: 

1.	Ispisati na konzolu da lik nije uspio i u �emu (Goal) nije uspio 

2.	Nasumi�no izabrati jednoga lika koji je u�estvovao i ubiti ga 

3.	Napraviti jednog lika (nasumi�no izabranog) sposobnim (ako nije bio) 

Zadatak 5
 

Napraviti pri�u u main metodi pomo�u navedenih klasa!
