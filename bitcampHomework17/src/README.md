Object Oriented Programming

Part 1

Zadatak 1

Napraviti klasu Computer, koja je abstract. Klasa sadr�i ime i MAC adresu ra�unara. Pored toga, napraviti i dva konstruktora, kao i dvije get metode. MAC adresa je objekat koju opisuje unutra�nja nestati�na klasa MACAddress. Objekat tog tipa treba sadr�avati niz karaktera adrese, ali bez ':'. Klasa treba imati toString metodu i konstruktor. Napraviti i equals i toString metode za Computer klasu.

Zadatak 2

Napisati klasu Network, koja je abstract. Network klasa sadr�i atribut imena mre�e, kao i spisak ra�unara koji su u toj mre�i (niz ra�unara). Klasa sadr�i konstruktor koji inicijalizira broj ra�unara niza na 0, kao i metodu addComputer(Computer c) i removeComputer(Computer c), koje su abstract. 

Zadatak 3

Napisati Server klasu koja sadr�i broj koji ozna�ava koliko maksimalno drugih ra�unara mo�e podnijeti a da ne do�ivi krah. Napraviti i jednu get metodu za taj limit. Napisati dodatni konstruktor koji inicijalizira ime, MACadresu i spomenuti limit servera. Napraviti i equals i toString metode.

Zadatak 4

Napraviti interface Connectable koji sadr�i metode connect(Computer), connect(Network) i disconnect(). Client klasa sadr�i atribut tipa Computer koji ozna�ava sa kojim je ra�unarom dati klijent spojen. Pored toga, ima jo� jedan sli�an atribut koji je tipa Network koji ozna�ava sa kojom je mre�om klijent spojen. Konstruktor klijenta treba imati samo ime i MAC adresu. Klasa implementira Connectable interface. Metoda connect treba da postavi link na dati ra�unar, odnosno na datu mre�u. Ukoliko link ve� postoji onda baciti exception. Metoda disconnect postavlja oba linka na null. Napisati i get metodu za te link atribute. 
Napraviti i equals i toString metode.

Napomena: Client se nikada ne mo�e spojiti na drugu mre�u/ra�unar ako mu oba atributa nisu null!

Zadatak 5

Napraviti demonstraciju svih klasa i metoda iz prija�nja �etiri zadatka.

Napisati javadoc za sve metode (nije potrebno za equals i toString metode).

Part 2

Zadatak 1

Napraviti interface Functionable koji ima metodu boolean isFunctioning(). 

Zadatak 2
 
Napraviti klasu ArrayManipulation koja sadr�i static metodu extendArray(Computer[]) koja pro�iri dati niz za jedan index/element. Novi element treba biti null. Pored toga, tu se nalazi i metoda shrinkArray(Computer[], int) koja smanji dati niz za jedan tako �to �obri�e� dati index.

Zadatak 3

Napraviti klasu BusNetwork koja naslje�uje Network klasu i implementira Functionable interface.
Metoda addComputer radi na principu tako �to pro�iri prvo niz ra�unara za jedan, zatim stavi dati ra�unar na to mjesto i povezuje ra�unar preko njegove connect metode sa ovom mre�om. Metoda removeComputer radi na principu tako �to prvo prona�e dati ra�unar (ako ga nema baciti exception) i obri�e ga (smanji niz). Pored toga, ra�unar prekida svoju vezu sa mre�om preko svoje disconnect metode.

Metoda isFunctioning treba vratiti true ukoliko ima barem dva ra�unara spojena na mre�i (da nisu null). toString metoda treba imati broj ra�unara u sebi, kao i dio koji govori da li mre�a funkcioni�e ili ne.

Zadatak 4
 
Napraviti klasu StarNetwork koja naslje�uje Network klasu i implementira Functionable interface.
Klasa sadr�i jedan Server. 
Metoda addComputer radi na principu tako �to pro�iri prvo niz ra�unara za jedan, zatim stavi ra�unar na to mjesto. Pored toga, dati ra�unar se povezuje preko connect metode sa serverom preko svoje connect metode. Metoda removeComputer radi na principu tako �to prvo prona�e dati ra�unar (ako ga nema baciti exception) i obri�e ga (smanji niz). Pored toga, dati ra�unar prekida link sa serverom preko svoje disconnect metode.
Metoda isFunctioning treba vratiti true ukoliko server radi. Server pada ukoliko ima vi�e povezanih ra�unara nego �to mo�e podnijeti. toString metoda treba imati broj spojenih ra�unara na server u sebi, kao i dio koji govori da li mre�a funkcioni�e ili ne.

Zadatak 5

Napisati javadoc za sve metode osim toString i equals metode. Napisati demonstraciju svih metoda!