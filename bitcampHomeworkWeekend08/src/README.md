                              WEEKEND HOMEWORK


TASK #1

Napraviti GUI aplikaciju koja se bavi raspodjelom file-ova u foldere. Aplikacija mora imati dugme koje otvori Browse prozor, tj. prozor gdje idete po direktorijima i odaberete neki file. Selektirani file se zatim parsira i gleda se njegova ekstenzija. Ukoliko je selektirani file slika (png, jpg, bmp, gif i slièno) onda staviti u folder Pictures. U sluèaju da je audio zapis (mp3, flac, wmv i slièno) onda staviti u folder Audio. Ukoliko je video (mp4, avi, mkvi slièno) onda staviti u folder Video. Dokumenti (doc, txt, xlsx i slièno) idu u folder Documents. Svi ostali file-ovi idu u Other folder.

Po pojmom „idu u X folder“ podrazumijeva se da se selektirani file fizièki prebaci (može i da kopira) u taj direktorij. Korisnik æe izabrati gdje æe se glavni direktorij nalaziti (pod glavnim misli se na direktorij koji u sebi sadrži ostale direktorije, poput Documents, Pictures i ostale).

Program sadrži i panel koji prikazuje koji su sve file-ovi u tim folderima, tj. spisak file-ova koji se trenutno nalaze u tom direktoriju zajedno sa imenom direktorija. Ovo bi se moglo uraditi tako što se u neki drugi file bilježi kada se nova datoteka doda preko Browse opcije i onda se èita iz tog file-a kada se ponovo pokrene aplikacija.

Brisanje file-ova je takoðer moguæe tako što se pritisne dugme na pomenutom panelu. Zbog toga je potrebno sve te file-ove opisati u jednoj klasi, nazvati je, recimo, UploadedFile, koja ima atribute poput imena, ekstenzije i velièine file-a, a pored toga i objekat tipa File.