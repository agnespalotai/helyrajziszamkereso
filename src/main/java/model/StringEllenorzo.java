package model;

/**
 * Osztály, ami tartalmazza egy karakterlánc különböző szempontok
 * szerinti vizsgálatát.
 */
public class StringEllenorzo {

    /**
     * A StringEllenorzo osztály konstruktora.
     */
    public StringEllenorzo(){}


    /**
     * A metódus elvégzi egy karakterlánc ellenőrzését
     * aszerint, hogy az megfelel-e egy helyrajzi szám formátumának.
     * @param  beirtszoveg a felhasználó által beírt karakterlánc
     * @return az ellenőrzés eredményének szövege
     */
    public String stringEllenorzese(String beirtszoveg){

        beirtszoveg=beirtszoveg.trim();

        if(aBeirtKarakterekSzamaNulla(beirtszoveg)){
            return "A beírt karakterek száma nulla!";
        }

        if(aBeirtKarakterekSzamaMaxTizennyolcLehet(beirtszoveg)){
            return "A beírt karakterek száma maximum 18 lehet!";
        }

        if(nemMegengedettKaraktertTartalmaz(beirtszoveg)){
            return "Csak megengedett karaktereket tartalmazhat!";
        }

        if(azEgyHosszusaguHelyrajziSzamCsakNemNullaSzamLehet(beirtszoveg)){
            return "Az egy karakteres helyrajzi-szám csak számjegy lehet!";
        }

        if(nemKezdodhetKetNullaval(beirtszoveg)){
            return "Nem kezdődhet két nullával!";
        }

        if(ketPerjelNemLehetEgymasMellett(beirtszoveg)){
            return "Két perjel nem lehet egymás mellett!";
        }

        if(maxHaromPerjelLehetBenne(beirtszoveg)){
            return "Maximum 3 perjel lehet benne!";
        }

        if(nemVegzodhetPerjellel(beirtszoveg)){
            return "Nem végződhet perjellel!";
        }

        if(betuEsSzamjegyNemLehetEgymasMellett(beirtszoveg)){
            return "Betű és számjegy nem állhat egymás után!";
        }
        return "OK";
    }

    /**
     * A metódus megvizsgálja, hogy a felhasználó által megadott
     * karakterláncot üres-e, azaz nem írt be semmit.
     * @param str a felhasználó által beírt karakterlánc
     * @return true, ha üres a beviteli mező.
     */
    public boolean aBeirtKarakterekSzamaNulla(String str){
        if(str.isEmpty()){
            return true;
        }
        return false;
    }

    /**
     * A metódus megvizsgálja, hogy a felhasználó által megadott
     * karakterláncot hossza nagyobb-e 18-nál.
     * @param str a felhasználó által beírt karakterlánc
     * @return true, ha igen.
     */
    public boolean aBeirtKarakterekSzamaMaxTizennyolcLehet(String str){
        if(str.length() > 18){
            return true;
        }
        return false;
    }

    /**
     * A metódus megvizsgálja, hogy a felhasználó által megadott
     * karakterlánc tartalmaz-e nem megengedett karaktert.
     * @param str a felhasználó által beírt karakterlánc
     * @return true, ha igen.
     */
    public boolean nemMegengedettKaraktertTartalmaz(String str){
        str = str.toUpperCase();
        for (int i=0; i<str.length(); ++i){
            int kodszam = str.codePointAt(i);
            if(!(karakterTipusaPerjel(kodszam) || karakterTipusaSzamjegy(kodszam) ||
                    karakterTipusaMegengedettBetu(kodszam) )){
                return true;
            }
        }
        return false;
    }

    /**
     * A metódus megvizsgálja, hogy a felhasználó által megadott
     * karakterlánc, ha ez egy hosszúságú, akkor az nullától
     * különböző számjegy-e.
     * @param str a felhasználó által beírt karakterlánc
     * @return true, ha igen.
     */
    public boolean azEgyHosszusaguHelyrajziSzamCsakNemNullaSzamLehet(String str){
        if(str.length()==1 && !(str.codePointAt(0)>48 && str.codePointAt(0)<=57)){
            return true;
        }
        return false;
    }

    /**
     * A metódus megvizsgálja, hogy a felhasználó által megadott
     * karakterlánc két nullával kezdődik-e.
     * @param str a felhasználó által beírt karakterlánc
     * @return true, ha igen.
     */
    public boolean nemKezdodhetKetNullaval(String str){
        if(str.length()>1 && str.codePointAt(0)==48 && str.codePointAt(1)==48){
            return true;
        }
        return false;
    }

    /**
     * A metódus megvizsgálja, hogy a felhasználó által megadott
     * karakterláncban van-e két perjel egymás mellett.
     * @param str a felhasználó által beírt karakterlánc
     * @return true, ha igen.
     */
    public boolean ketPerjelNemLehetEgymasMellett(String str){
        if(str.contains("//")){
            return true;
        }
        return false;
    }

    /**
     * A metódus megvizsgálja, hogy a felhasználó által megadott
     * karakterláncban van-e háromnál több perjel.
     * @param str a felhasználó által beírt karakterlánc
     * @return true, ha igen.
     */
    public boolean maxHaromPerjelLehetBenne(String str){
        int p = 0;
        for(int i = 0; i<str.length(); ++i){
            if(karakterTipusaPerjel(str.codePointAt(i))){
                ++p;
            }
            if(p>3){
                return true;
            }
        }
        return false;
    }

    /**
     * A metódus megvizsgálja, hogy a felhasználó által megadott
     * karakterlánc perjellel végződik-e.
     * @param str a felhasználó által beírt karakterlánc
     * @return true, ha igen.
     */
    public boolean nemVegzodhetPerjellel(String str){
        if(str.endsWith("/")){
            return true;
        }
        return false;
    }

    /**
     * A metódus megvizsgálja, hogy a felhasználó által megadott
     * karakterláncban van-e egymást követő számjegy és betű, vagy fordítva,
     * betű és számjegy.
     * @param str a felhasználó által beírt karakterlánc
     * @return true, ha igen.
     */
    public boolean betuEsSzamjegyNemLehetEgymasMellett(String str){
        str = str.toUpperCase();
        if(str.length()>1) {
            for (int i = 0; i < str.length()-1; ++i) {
                int kodszam = str.codePointAt(i);
                int kodszamPluszEgy = str.codePointAt(i + 1);
                if ( (karakterTipusaSzamjegy(kodszam) && karakterTipusaMegengedettBetu(kodszamPluszEgy)) ||
                        (karakterTipusaMegengedettBetu(kodszam) && karakterTipusaSzamjegy(kodszamPluszEgy))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * A metódus megvizsgálja, hogy egy karakter perjel-e.
     * @param karakterkod egy karakter numerikus számértéke
     * @return true, ha igen.
     */
    public boolean karakterTipusaPerjel(int karakterkod){
        if(karakterkod == 47){
            return true;
        }
        return false;
    }

    /**
     * A metódus megvizsgálja, hogy egy karakter számjegy-e.
     * @param karakterkod egy karakter numerikus számértéke
     * @return true, ha igen.
     */
    public boolean karakterTipusaSzamjegy(int karakterkod){
        if(karakterkod >= 48 && karakterkod <= 57){
            return true;
        }
        return false;
    }

    /**
     * A metódus megvizsgálja, hogy egy karakter egy helyrajziszámban
     * használható megengedett karakter-e.
     * @param karakterkod egy karakter numerikus számértéke
     * @return true, ha igen.
     */
    public boolean karakterTipusaMegengedettBetu(int karakterkod){
        if( karakterkod >= 65 && karakterkod <=86 && karakterkod != 69 &&
                karakterkod != 73 && karakterkod != 79 && karakterkod != 85 && karakterkod != 81){
            return true;
        }
        return false;
    }

}
