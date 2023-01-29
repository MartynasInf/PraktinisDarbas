package Day26_0114.Homework;

import Day26_0114.Homework.entity.House;
import Day26_0114.Homework.entity.Owner;
import Day26_0114.Homework.repository.HouseRepo;
import Day26_0114.Homework.repository.OwnerRepo;
import Day26_0114.Homework.service.DataProvider;
import Day26_0114.Homework.service.WealthCalculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataProvider dataProvider = new DataProvider();
        List<Owner> providedOwnersList = dataProvider.createOwners();

        OwnerRepo ownerRepo = new OwnerRepo();
        for (Owner owner : providedOwnersList) {
            ownerRepo.save(owner);
        }
        ownerRepo.findAll().forEach(System.out::println);
        List<Owner> ownersList = ownerRepo.findAll();
        //ownerRepo.delete(ownersList.get(0));
        ownersList.get(1).setName("Jokubas");
        ownerRepo.update(ownersList.get(1));

        House namasPalangoje = new House();
        namasPalangoje.setPrice(250000);
        namasPalangoje.setAddress("Palanga, Tulpiu g. 8");
        namasPalangoje.setHouseArea(115);
        namasPalangoje.setPlotArea(6);
        namasPalangoje.setOwner(ownersList.get(1));

        HouseRepo houseRepo = new HouseRepo();
        houseRepo.save(namasPalangoje);
        System.out.println();
        List<House> allHouses = houseRepo.findAll();
        allHouses.forEach(System.out::println);

        //houseRepo.delete(namasPalangoje);
        namasPalangoje.setOwner(ownersList.get(0));
        houseRepo.update(namasPalangoje);
        System.out.println();
        WealthCalculator wealthCalculator = new WealthCalculator();
        System.out.println(ownerRepo.findAll().get(0).getName() +" turi turto uz "+wealthCalculator.calculatesOwnerWealth(ownerRepo.findAll().get(0)));


    }
}
