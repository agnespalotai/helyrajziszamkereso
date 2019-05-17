Helyrajziszám ellenőrző és kereső

Az alkalmazás bekér a felhasználótól egy sztringet, majd ezt követően leellenőrzi, hogy az a jogszabályban* 
előírt számú és típusú karaktereket tartalmazza-e, úgymint: 
„6. § (1) Az ingatlan-nyilvántartási adatbázisban a helyrajzi szám alfanumerikus változó, amely 
maximum 18 karakter hosszúságú lehet.
(2) Ha egy fölrészleten több épület van, megkülönböztetésük érdekében minden egyes épületet 
külön-külön a magyar abc nagybetűivel kell megjelölni. A magánhangzók közül csak az „A” betűt, 
a mássalhangzók közül pedig csak az egyjegyűek - a Q, W, X, Y és Z kivételével (összesen 17 betű) - használhatók. 
Ha a felhasználható betűk nem elegendőek, a jelölést az „AA”, „AB”, „AC”, ..., „BA”, „BB”, „BC”,... stb. jellel 
kezdve kell folytatni. Egy épületen belül a lakások helyrajziszámozását 1-től 999-ig lehet végezni (pl. 128265/2858/BA/118).”

Ha az ellenőrzés során hibát észlel, akkor a hibának megfelelő üzenet jelenik meg, ha pedig a karakterek száma és típusa megfelelő, 
akkor egy adatbázisból kikeresi a hozzá tartozó cím(eke)t, ha létezik olyan.

A könnyebb használhatóság érdekében az ellenőrzés majd a keresés a szóközöktől megtisztított és nagybetűsített sztringgel történik.

MEGJEGYZÉS: az alkalmazás a karakteres ellenőrzésen túl, elvégez néhány tartalmi vizsgálatot is, de nem teljeskörűen. Így például a megadott sztringre hibát jelez:
•	ha abban két perjel követi egymást (pl. 125//A/5),
•	ha háromnál több alátörés, azaz háromnál több perjel van benne (pl. 03568/78/A/5/2),
•	ha perjellel végződik (pl. 32658/),
•	ha betű és szám áll közvetlenül egymást követően tetszőleges sorrendben perjel nélkül (pl. 1b/56) stb.,
de helyesnek fogadja el az 1/A/A, vagy 0/0/0 stb. sztringeket.

* az önálló ingatlanok helyrajziszámozásáról és az alrészletek megjelöléséről szóló 
44/2006. (VI. 13.) FVM rendelet 6. § (1) - (2) bekezdés
