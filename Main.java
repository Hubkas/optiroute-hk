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
