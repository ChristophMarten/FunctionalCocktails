package de.functional.cocktails.domain.entity.strategy;

import de.functional.cocktails.domain.entity.HandleIngredients;

public interface PrepareCokeStrategy {

  HandleIngredients prepareCoke =(a)-> {if (a <= 34){
    System.out.println(a+" Coke poured !");
    return true;
  }else{
    System.out.println("Not enough Coke");
    return false;
  }
  };
}
