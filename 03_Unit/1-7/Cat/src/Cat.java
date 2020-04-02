
public class Cat
{
    public static final double MIN_WEIGHT = 1000.;
    public static final double MAX_WEIGHT = 9000.;
    public static final int EYES_COUNT = 2;

    private static int count = 0;

    private double originWeight;
    private double weight;
    private Color catColor;
    private double amountEaten;

    public Cat()
    {
        this(1500.0 + 3000.0 * Math.random());
    }

    public Cat(double weight)
    {
        this.weight = weight;
        originWeight = weight;
        amountEaten = 0;
        catColor = Color.BLACK;
        if ((MIN_WEIGHT < this.weight) && (this.weight < MAX_WEIGHT))
        {
            count++;
        }
    }

    public Cat(Cat cat)
    {
        this();
        weight = cat.weight;
        originWeight = cat.originWeight;
        amountEaten = cat.amountEaten;
        catColor = cat.catColor;
    }

    public Color getCatColor()
    {
        return catColor;
    }

    public void setCatColor(Color color)
    {
        catColor = color;
    }

    public Cat createTwin()
    {
        return new Cat(this);
    }

    public void pee(Double amount)
    {
        if ((MIN_WEIGHT < weight) && (weight < MAX_WEIGHT))
        {
            weight -= amount;
            System.out.println("/Noise from tray/");
            if (getStatus().equals("Dead"))
            {
                count--;
            }
        }
        else
        {
            System.out.println("Error. Cat is not exist");
        }
    }

    public void meow()
    {
        if ((MIN_WEIGHT < weight) && (weight < MAX_WEIGHT))
        {
            weight -= 1;
            System.out.println("Meow");
            if (getStatus().equals("Dead"))
            {
                count--;
            }
        }
        else
        {
            System.out.println("Error. Cat is not exist");
        }
    }

    public void feed(Double amount)
    {
        if ((MIN_WEIGHT < weight) && (weight < MAX_WEIGHT))
        {
            amountEaten += amount;
            weight += amount;
            if (getStatus().equals("Exploded"))
            {
                count--;
            }
        }
        else
        {
            System.out.println("Error. Cat is not exist");
        }
    }

    public void drink(Double amount)
    {
        if ((MIN_WEIGHT < weight) && (weight < MAX_WEIGHT))
        {
            amountEaten += amount;
            weight += amount;
            if (getStatus().equals("Exploded"))
            {
                count--;
            }
        }
        else
        {
            System.out.println("Error. Cat is not exist");
        }
    }

    public double getEaten()
    {
        return amountEaten;
    }

    public static  int getCount() {
        return count;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}