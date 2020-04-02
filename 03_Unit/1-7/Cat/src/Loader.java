
public class Loader
{
    public static void main(String[] args)
    {

        Cat cat0 = new Cat();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();
        Cat cat4 = new Cat();

        System.out.println("cat0 " + cat0.getWeight() + " грамм");
        System.out.println("cat1 " + cat1.getWeight() + " грамм");
        System.out.println("cat2 " + cat2.getWeight() + " грамм");
        System.out.println("cat3 " + cat3.getWeight() + " грамм");
        System.out.println("cat4 " + cat4.getWeight() + " грамм");

        cat0.feed(300.);
        cat1.feed(100.);

        System.out.println("cat0 " + cat0.getWeight() + " грамм");
        System.out.println("cat1 " + cat1.getWeight() + " грамм");

        while (true) {
            System.out.println(cat0.getStatus());
            if (cat0.getStatus().equals("Exploded")) {
                break;
            }
            cat0.feed(300.);
        }

        while (true) {
            if (cat1.getStatus().equals("Dead")) {
                System.out.println(cat1.getStatus());
                break;
            }
            cat1.meow();
        }

        cat2.feed(150.);
        for (int i = 0; i < 5; i++) {
            cat2.pee(100.);
        }
        cat2.feed(150.);
        System.out.println(cat2.getEaten());

        System.out.println(Cat.getCount());

        Cat cat5 = new Cat(cat2);

        System.out.println(Cat.getCount());

//        System.out.println(cat.getStatus());
    }

    private static Cat getKitten()
    {
        return new Cat(1100.);
    }
}