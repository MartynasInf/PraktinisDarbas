package Day26_0114.Homework.service;

import Day26_0114.Homework.entity.House;
import Day26_0114.Homework.entity.Owner;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class WealthCalculator {

    public Integer calculatesOwnerWealth(Owner owner){
        Integer housesValue = 0;
        for (House house : owner.getHouses()) {
            housesValue += house.getPrice();
        }
        return housesValue + owner.getBankBalance();
    }
}
