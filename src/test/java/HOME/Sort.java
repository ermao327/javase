package HOME;

import java.util.Arrays;

public enum Sort {
    SINGLETON;
    public void method(double [] sort1){
        double tmp = 0;
        for (int i = 0; i <sort1.length-1; i++) {
            for (int j = 0; j <sort1.length-1-i; j++) {
                if(sort1[j]>sort1[j+1])
                {
                    tmp=sort1[j];
                    sort1[j]=sort1[j+1];
                    sort1[j+1]=tmp;
                }
            }
        }
        System.out.println(Arrays.toString(sort1));
    }
}
