package Day26_0114.Homework.service;

import Day26_0114.Homework.entity.House;
import Day26_0114.Homework.entity.Owner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataProvider {

    public List<Owner> createOwners(){
        List<Owner> owners = new ArrayList<>();

        Owner edvinas = new Owner();
        edvinas.setName("Edvinas");
        edvinas.setAge(32);
        edvinas.setBankBalance(148000);

        Owner tomas = new Owner();
        tomas.setName("Tomas");
        tomas.setAge(35);
        tomas.setBankBalance(25000);

        House namasVilniuje = new House();
        namasVilniuje.setPrice(380000);
        namasVilniuje.setAddress("Vilnius, Pilaite, Darguziu g. 10");
        namasVilniuje.setHouseArea(168);
        namasVilniuje.setPlotArea(16);
        namasVilniuje.setOwner(edvinas);

        House namasKlaipedoje = new House();
        namasKlaipedoje.setPrice(195000);
        namasKlaipedoje.setAddress("Klaipeda, Baltijos pr 67");
        namasKlaipedoje.setHouseArea(150);
        namasKlaipedoje.setPlotArea(6);
        namasKlaipedoje.setOwner(tomas);

        House namasKarkleje = new House();
        namasKarkleje.setPrice(295000);
        namasKarkleje.setAddress("Karkle, Karklininku g. 26");
        namasKarkleje.setHouseArea(120);
        namasKarkleje.setPlotArea(6);
        namasKarkleje.setOwner(edvinas);


        edvinas.setHouses(Arrays.asList(namasVilniuje, namasKarkleje));
        tomas.setHouses(Arrays.asList(namasKlaipedoje));

        owners.add(edvinas);
        owners.add(tomas);
        return owners;
    }
}
