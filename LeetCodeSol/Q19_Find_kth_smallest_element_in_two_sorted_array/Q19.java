import java.util.*;
public class Q19{
    public static int find(int A[], int B[], int k){
        int pA = 0;
        int pB = 0;
        int count = 0;
        while(true){
            if(pA < A.length && pB < B.length){
                if(A[pA] <= B[pB]){
                    if(count == k - 1){
                        return A[pA];
                    }
                    pA++;
                    count++;
                } else{
                    if(count == k - 1){
                        return B[pB];
                    }
                    pB++;
                    count++;
                }
            }else if(pA == A.length){
                return B[k - pA - 1 ];
            }else if(pA == B.length){
                return A[k - pB - 1];
            }

        }
    }
    //i+j = k - 1
    public static int find(int A[], int B[], int pa, int delta, int k){
        int pb = (k - 1) - pa;
        int Ai_1 = ((pa == 0) ? Integer.MIN_VALUE : A[pa-1]);
        int Bj_1 = ((pb == 0) ? Integer.MIN_VALUE : B[pb-1]);
        int Ai = ((pa == A.length) ? Integer.MAX_VALUE : A[pa]);
        int Bj = ((pb == B.length) ? Integer.MAX_VALUE : B[pb]);
        if(Bj_1 <= Ai && Ai <= Bj) return Ai;
        if(Ai_1 <= Bj && Bj <= Ai) return Bj;
        if(Ai > Bj){
            pa = ((k-1) - (pa -delta) > B.length)? k - 1 - B.length : pa-delta;
            return find(A, B, pa, (delta + 1)/2, k);
        }else {
            pa = (pa + delta > A.length)? A.length : pa + delta;
            return find(A, B, pa, (delta + 1)/2, k);
        }
    }
       public static void main(String args[]){
        int A[] = {1, 8, 8, 10, 20};
        int B[] = {5, 8, 8, 9, 22, 110};
        //int B[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        //int A[] = {21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        Arrays.sort(A);
        Arrays.sort(B);
        System.out.println(Arrays.toString(A));
        System.out.println(Arrays.toString(B));
        for(int i = 1; i <= A.length + B.length; i++){
           // System.out.println(find(A, B, i));
           int pa = Math.min(A.length, i-1);
           System.out.println(find(A, B, pa, (pa+1)/2, i));
        }

    }
}
