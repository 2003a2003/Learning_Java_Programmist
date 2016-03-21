package lesson3.part_5.frame_6.ingridients;

public class StartDefaultPriceIngridients {

    private AbstractIngridients[] ingr;
    private int tail;

    public AbstractIngridients[] getIngr() {
        return ingr;
    }

    public int getTail() {
        return tail;
    }

    public StartDefaultPriceIngridients(){
        ingr = new AbstractIngridients[20];
        tail = 0;
    }

    public AbstractIngridients[] addNewStartDefoultPrice(){

        addOneIngridients(new Water(),200,0.2);
        addOneIngridients(new Chocolate(),100,1);
        addOneIngridients(new Lemon(),1,0.3);
        addOneIngridients(new Milk(),100,0.6);
        addOneIngridients(new MilkFoam(),100,0.7);
        addOneIngridients(new Sugar(),40,0.5);
        addOneIngridients(new TeaBlack(),1,0.8);
        addOneIngridients(new TeaGreebWithBergamot(),1,1);
        addOneIngridients(new TeaGreen(),1,0.8);
        addOneIngridients(new Mint(),20,0.4);
        addOneIngridients(new Coffee(),10,1);

        return ingr;

    }

    public void addOneIngridients(AbstractIngridients newcl, int dose, double price){
        if(tail < ingr.length){
            ingr[tail] = newcl;
            ingr[tail].setNameOfIngredient(ingr[tail].getClass().getSimpleName());
            ingr[tail].setDose(dose);
            ingr[tail].setPrice(price);
            tail++;
        }else{
            //create new array + add
            //addOneIngridients();

        }
    }

    public void addNewIngridients(String newcl, int dose, double price){
        if(tail < ingr.length){
            ingr[tail] = new NewSomeIngridients();
            ingr[tail].setNameOfIngredient(newcl);
            ingr[tail].setDose(dose);
            ingr[tail].setPrice(price);
            tail++;
        }else{
            //create new array + add
            //addOneIngridients();
        }
    }

    private void updateTeil(){
        int t = 0;
        for (AbstractIngridients i : ingr){
            if (i !=null){
                t++;
            }
        }
        tail = t;
    }
}
