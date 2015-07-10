SNAKE igra

Projekat se sastoji iz tri klase. Prva klasa obuhvata Single Player mod, druga Multiplayer, a treæa predstavlja main klasu u kojoj se odluèuje koji mod želimo igrati.

U oba moda "Snake" predstavlja niz x i y koordinata. Kretnja zmije se vrši pomoæu tipki na tastaturi "UP","DOWN","LEFT","RIGHT", a u multiplayer modu igraè dva se kreæe pomoæu tipki "W","A","S","D". Nakon što zmija pokupi hranu, na tabli se generiše nova hrana pomoæu math random funkcije. Detaljniji opis svih metoda može se vidjeti kroz Javadoc.

Cilj Single Player moda jeste da igraè skupi što veæi broj bodova kupeæi "hranu" sa ploèe. Brzina kretanja zmije se poveæava svako 10 skupljenih kvadratiæa koji predstavljaju hranu. Kraj igre nastaje kada zmija udari u krajeve ploèe ili kada udari u samu sebe.

Cilj Multiplayer moda obuhvata skupljanje što veæeg broja bodova kupeæi hranu sa ploèe(svaka skupljena nosi 10 bodova). Meðutim, pored toga što je bitno skupiti što veæi broj, jednako je važno ne udariti u zid ili u drugu zmiju. Ukoliko igraè 1 ima veæi broj bodova, a izazove "crash" rezultat æe biti neriješen. U suprotnom igraè 1 je izgubio. Važno je i napomenuti da svaka peta skupljena hrana nosi po 25 bodova, te omoguæuje igraèu koji je u zaostatku da stigne protivnika.