package core;

public class Car
{
    //String number
    public String number;
    //int height
    public int height;
    //double weight
    public double weight;
    //boolean hasVehicle
    public boolean hasVehicle;
    //boolean isSpecial
    public boolean isSpecial;

    public String toString()
    {
        //String special
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}