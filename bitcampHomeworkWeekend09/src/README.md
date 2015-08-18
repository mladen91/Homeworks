                            WEEKEND HOMEWORK
                            
                            
TASK #1 � CHECK IF FILE EXISTS

Napraviti jedan server koji za klijenta provjeraje da li dati file na serverovom ra�unaru postoji. Nije potrebno uraditi GUI za ovaj zadatak.

PRIMJER

Ukoliko klijent po�alje serveru String �C:/Users/Neko/Desktop/text.txt� i ukoliko server IMA taj file u tom direktoriju onda server odgovara sa 1, a ukoliko taj file ne postoji onda odgovara sa 0.

TASK #2 � THREE THREADS OF ONE CLASS

Napraviti tri Thread-a. Prvi isprinta brojeve od 1 do 10, sa pauzom od 200 [ms] izme�u svakog broja. Drugi isprinta �etiri puta �BitCamp� sa pauzom od 1000 [ms], a tre�i isprinta pet Random brojeva u rasponu od 1 do 5 sa pauzom od 700 [ms] izme�u svakog.

Tre�i Thread kre�e sa radom kada zavr�i drugi, a drugi kre�e sa radom kada zavr�i prvi. Kada svi zavr�e zatvara se program.

Sva tri Thread-a su bazirani na samo jednoj klasi!


TASK #3 � INTERRUPTING A THREAD (GUI)

Napraviti GUI aplikaciju koja ima jedan JLabel i jedan JButton. JLabel je na po�etku prazan, ali nakon svake sekunde dobija jedno po jedno slovo abecede, pa tako nakon tri sekunde JLabel �e imati u sebi �abc�, a nakon pet �e imati �abcde�. Klikom na dugme se zaustavi taj proces, ali ne i aplikacija.

Koristiti vlastite Thread-ove za ovaj zadatak! Nipo�to ne koristiti glavni Thread za JLabel!


TASK #4 � HTTP IMAGE SERVER

Napraviti HTTP server kojem klijent daje (upload-uje) sliku u obliku niza byte-ova. Server kod sebe spa�ava tu sliku i daje joj proizvoljno ime (mo�e biti nasumi�no, mo�e se generisati na osnovu ip adrese i vremena kada je poslata slika). Nakon uspje�nog prebacivanja slike na server, na stranici se pojavljuje link na tu sliku tako da korisnik mo�e otvoriti stranicu gdje se nalazi ta slika.

PRIMJER

Server prima sliku od klijenta i generi�e joj ime 2034317.jpg. Na stranici servera (HTTP protokol) pojavi se novi link koji vodi na stranicu, ukoliko je lokalni ra�unar, localhost/2034317 i tu se pojavi postavljena slika.





