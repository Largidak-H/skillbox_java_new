public class Loader {
    public static void main(String[] args) {
        Client pe_4276 = new PhysicalEntity(4276);
        Client le_5234 = new LegalEntity(5234);
        Client ie_2231 = new IndividualEntrepreneur(2231);

        pe_4276.replenish(1500);
        le_5234.replenish(2500);
        ie_2231.replenish(2000);
        ie_2231.replenish(500);

        pe_4276.withdraw(1000);
        le_5234.withdraw(1000);
        ie_2231.withdraw(1000);

        pe_4276.getAccountInfo();
        le_5234.getAccountInfo();
        ie_2231.getAccountInfo();
    }
}
