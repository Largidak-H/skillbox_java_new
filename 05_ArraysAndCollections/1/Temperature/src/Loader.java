import java.math.BigDecimal;
import java.math.RoundingMode;

public class Loader {
    public static void main(String[] args) {
        float[] arrTemp = new float[30];
        float sumTemp = 0;
        int countOfHealthy = 0;
        for (int i = 0; i < arrTemp.length; i++) {
            float buffer = 32 + (float) (Math.random() * 8);
            arrTemp[i] = new BigDecimal(buffer).setScale(1, RoundingMode.UP).floatValue();
            sumTemp += arrTemp[i];
            if (arrTemp[i] >= 36.2 && arrTemp[i] <= 36.9) {
                countOfHealthy++;
            }
            System.out.print(arrTemp[i] + " ");
        }
        float middleTemp = new BigDecimal(sumTemp / arrTemp.length).setScale(1, RoundingMode.UP).floatValue();
        System.out.println("\nСредняя температура пациентов по больнице: " + middleTemp);
        System.out.println("Количество здоровых пациентов в больнице: " + countOfHealthy);
    }
}
