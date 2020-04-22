public class Loader {
    public static final double MIN_TEMP = 32;
    public static final double MAX_TEMP = 40;
    public static final double MIN_HEALTHY_TEMP = 36.2;
    public static final double MAX_HEALTHY_TEMP = 36.9;
    public static void main(String[] args) {
        double[] arrTemp = new double[30];
        double sumTemp = 0;
        int countOfHealthy = 0;
        for (int i = 0; i < arrTemp.length; i++) {
            arrTemp[i] = MIN_TEMP + (Math.random() * (MAX_TEMP - MIN_TEMP));
            sumTemp += arrTemp[i];
            if (arrTemp[i] >= MIN_HEALTHY_TEMP && arrTemp[i] <= MAX_HEALTHY_TEMP) {
                countOfHealthy++;
            }
            System.out.printf("%.1f ", arrTemp[i]);
        }
        double middleTemp = sumTemp / arrTemp.length;
        System.out.printf("%nСредняя температура пациентов по больнице: %.1f %n", middleTemp);
        System.out.printf("Количество здоровых пациентов в больнице: %d %n", countOfHealthy);
    }
}
