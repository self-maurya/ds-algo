package old.extra;

import java.util.Arrays;
import java.util.BitSet;

public class CarsFeatures {
    public static void main(String[] args) {
        int[] a = solution(new String[]{"100", "110", "010", "011", "100"});
        System.out.println(Arrays.toString(a));
    }

    public static int[] solution(String[] cars) {
        BitSet[] features = new BitSet[cars.length];
        for (int i = 0; i < cars.length; i++) {
            features[i] = stringToBitSet(cars[i]);
        }

        int[] similarCars = new int[features.length];
        for (int i = 0; i < similarCars.length - 1; i++) {
            for (int j = i + 1; j < similarCars.length; j++) {
                BitSet temp = (BitSet) features[i].clone();
                temp.xor(features[j]);
                if (temp.cardinality() <= 1) {
                    similarCars[i]++;
                    similarCars[j]++;
                }
            }
        }
        return similarCars;
    }

    public static BitSet stringToBitSet(String car) {
        BitSet bs = new BitSet(car.length());
        for (int i = 0; i < car.length(); i++) {
            if (car.charAt(i) == '1') {
                bs.set(i);
            }
        }
        return bs;
    }
}