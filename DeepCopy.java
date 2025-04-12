import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DeepCopy {
    public static void main(String[] args) {
        // int A[] = {5,6,7,8,9};
        // int B[] = new int[A.length];
        // for (int i = 0; i < A.length; i++) {
        //     B[i] =  A[i];
        // }
        // System.out.println("Array B: ");
        // for (int i = 0; i < B.length; i++) {
        //     System.out.print(B[i] + " ");
        // }
        // System.arraycopy(A,0,B,0, A.length);
        // int a[] = {5,6,7,8};
        // int b[] = {10,20,30};

        // int c[] = new int[a.length + b.length];
        // int d[] = new int[a.length + b.length];

        // System.arraycopy(a,0,c,0,a.length);
        // System.arraycopy(b,0,c,a.length,b.length);

        // System.out.println(Arrays.toString(c));

        // System.arraycopy(b,0,d,0,b.length);
        // System.arraycopy(a,0,d,b.length,a.length);

        // System.out.println(Arrays.toString(d));


        Integer a[] = {7,27,813,46,25,19,629};
        // Sorting based on units place
        ArrayList<Integer> numlist = new ArrayList<>(Arrays.asList(a));

        numlist.sort(Comparator.comparingInt(n->n%10));
        System.out.println("Sorting based on units place "+numlist);

        // Sorting based on tens place
        numlist.sort(Comparator.comparingInt(n->(n/10)%10));
        System.out.println("Sorting based on tens place "+numlist);






        // for(int i=0;i<a.length;i++){
        //     for(int j=i+1;j<a.length;j++){
        //         if((a[i]%10) > (a[j]%10)){
        //             int temp = a[i];
        //             a[i] = a[j];
        //             a[j] = temp;
        //         }
        //         if(a[i]%10==a[j]%10){
        //             if(a[i] > a[j]){
        //                 int temp = a[i];
        //                 a[i] = a[j];
        //                 a[j] = temp;
        //             }
        //         }
        //     }
        // }
        // System.out.println(Arrays.toString(a));
    }
}
