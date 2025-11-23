 List<Punkt> GenerujPaczki(int iloscPaczek){

    List<Punkt> listaPunktow = new ArrayList<>();
    for(int i = 0; i <iloscPaczek;i++){
        Random rand = new Random();
        int randPunktX = rand.nextInt(257);
        int randPunktY = rand.nextInt(257);
        listaPunktow.add(new Punkt(randPunktX,randPunktY));
    }
    return listaPunktow;
}

double ObliczOdleglosc(Punkt punkt1, Punkt punkt2) {
    double odleglosc = Math.sqrt(Math.pow(punkt1.punktX - punkt2.punktX,2)+Math.pow(punkt1.punktY - punkt2.punktY,2));
    odleglosc = Math.round(odleglosc * 100) /100.0;
    return odleglosc;
}

void WyznaczTrase(List<Punkt> listaPunktow, Punkt sortownia){
    List<Punkt> wyznaczonaTrasa = new ArrayList<>();
    List<Punkt> doreczeniaLista = listaPunktow;
    double dlugoscTrasy = 0;
    int pozycjaXKuriera = 0;
    int pozycjaYKuriera = 0;

    Punkt pozycjaKuriera = new Punkt(pozycjaXKuriera,pozycjaYKuriera);

    wyznaczonaTrasa.add(sortownia);
    Punkt ostatniaPaczka = new Punkt(doreczeniaLista.get(doreczeniaLista.size()-1).punktX,doreczeniaLista.get(doreczeniaLista.size()-1).punktY);

    while(!doreczeniaLista.isEmpty()){
        int najblizszaPaczka = 0;
        System.out.println(pozycjaKuriera.punktX + "  " + pozycjaKuriera.punktY);
        double minWynik = ObliczOdleglosc(pozycjaKuriera,doreczeniaLista.get(0));;
        for(int i = 0; i < doreczeniaLista.size();i++){
            System.out.println("pierwsza paczka: " + pozycjaKuriera.punktX + " " + pozycjaKuriera.punktY);
            System.out.println("druga paczka: " + doreczeniaLista.get(i).punktX + " " + doreczeniaLista.get(i).punktY);
            double wynikObliczOdleglosc = ObliczOdleglosc(pozycjaKuriera,doreczeniaLista.get(i));
            System.out.println(wynikObliczOdleglosc);
            if(wynikObliczOdleglosc<minWynik) {
                minWynik = wynikObliczOdleglosc;
                System.out.println("pierwsza paczka min: " + pozycjaKuriera.punktX + " " + pozycjaKuriera.punktY);
                System.out.println("pierwsza paczka min: " + doreczeniaLista.get(i).punktX + " " + doreczeniaLista.get(i).punktY);
                najblizszaPaczka = i;
            }
        }

        System.out.println("///////////////////////////");
        dlugoscTrasy += minWynik;
        System.out.println(doreczeniaLista.get(najblizszaPaczka).punktX + "  " + doreczeniaLista.get(najblizszaPaczka).punktY);
        System.out.println("///////////////////////////");
        wyznaczonaTrasa.add(doreczeniaLista.get(najblizszaPaczka));
        pozycjaXKuriera = doreczeniaLista.get(najblizszaPaczka).punktX;
        pozycjaYKuriera = doreczeniaLista.get(najblizszaPaczka).punktY;;
        pozycjaKuriera = new Punkt(pozycjaXKuriera,pozycjaYKuriera);
        doreczeniaLista.remove(najblizszaPaczka);
    }

    dlugoscTrasy += ObliczOdleglosc(pozycjaKuriera,ostatniaPaczka);
    wyznaczonaTrasa.add(sortownia);
    for(int i = 0; i < wyznaczonaTrasa.size()-1;i++){
        System.out.println(wyznaczonaTrasa.get(i).punktX+"   " + wyznaczonaTrasa.get(i).punktY);
    }
}

void main() {
    boolean czyParseIntBezBledu = false;
    Sortownia sortownia = Sortownia.SORTOWNIA;
    System.out.println("podaj ilośc generowanych paczek: ");
    Scanner sc = new Scanner(System.in);
    String iloscPaczekStr = sc.nextLine();
    int iloscPaczek = 0;
    while (czyParseIntBezBledu == false) {
        try {
            iloscPaczek = Integer.parseInt(iloscPaczekStr);
            czyParseIntBezBledu = true;
            break;
        } catch (Exception e) {
            iloscPaczekStr = sc.nextLine();
        }
    }
    List<Punkt> listaPunktowPaczek = GenerujPaczki(iloscPaczek);
    for(int i  = 0; i < listaPunktowPaczek.size() - 1;i++) {
        System.out.println(ObliczOdleglosc(listaPunktowPaczek.get(i), listaPunktowPaczek.get(i+1)));
    }
}
