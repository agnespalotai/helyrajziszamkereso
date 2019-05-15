package model;

public class StringEllenorzo {

    public StringEllenorzo(){}


    public String stringEllenorzese(String beirtszoveg){


        if(aBeirtKarakterekSzamaNulla(beirtszoveg)){
            return "A beírt karakterek száma nulla!";
        }

        if(aBeirtKarakterekSzamaMaxTizennyolcLehet(beirtszoveg)){
            return "A beírt karakterek száma maximum 18 lehet!";
        }

        if(aBeirtSzovegSzokoztTartalmaz(beirtszoveg)){
            return "A beírt szöveg nem tartalmazhat szóközt!";
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

        if(betuEsSzamjegyNemLehetEgymasMellett(beirtszoveg)){
            return "Betű és számjegy nem állhat egymás után!";
        }
        return "OK";
    }

    public boolean aBeirtKarakterekSzamaNulla(String str){
        if(str.isEmpty()){
            return true;
        }
        return false;
    }


    public boolean aBeirtKarakterekSzamaMaxTizennyolcLehet(String str){
        if(str.length() > 18){
            return true;
        }
        return false;
    }

    public boolean aBeirtSzovegSzokoztTartalmaz(String str){
        if(str.contains(" ")){
            return true;
        }
        return false;
    }

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

    public boolean azEgyHosszusaguHelyrajziSzamCsakNemNullaSzamLehet(String str){
        if(str.length()==1 && !(str.codePointAt(0)>48 && str.codePointAt(0)<=57)){
            return true;
        }
        return false;
    }

    public boolean nemKezdodhetKetNullaval(String str){
        if(str.length()>1 && str.codePointAt(0)==48 && str.codePointAt(1)==48){
            return true;
        }
        return false;
    }


    public boolean ketPerjelNemLehetEgymasMellett(String str){
        if(str.contains("//")){
            return true;
        }
        return false;
    }

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



    public boolean karakterTipusaPerjel(int karakterkod){
        if(karakterkod == 47){
            return true;
        }
        return false;
    }

    public boolean karakterTipusaSzamjegy(int karakterkod){
        if(karakterkod >= 48 && karakterkod <= 57){
            return true;
        }
        return false;
    }

    public boolean karakterTipusaMegengedettBetu(int karakterkod){
        if( karakterkod >= 65 && karakterkod <=86 && karakterkod != 81){
            return true;
        }
        return false;
    }

}
