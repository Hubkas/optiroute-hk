 List<Punkt> GenerujPaczki(int iloscPaczek){

    List<Punkt> listaPunktow = new ArrayList<>();
    for(int i = 0; i <iloscPaczek;i++){
        Random rand = new Random();
        int randPunktX = rand.nextInt(257);
        int randPunktY = rand.nextInt(257);
        listaPunktow.add(new Punkt(randPunktX,randPunktY));
    }
    return listaPunktow;
}//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
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
    for(Punkt p:  listaPunktowPaczek){
        System.out.println(p.punktX + " " + p.punktY);
    }
}
