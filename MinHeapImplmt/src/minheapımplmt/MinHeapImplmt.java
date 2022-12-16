
package minheapımplmt;


import java.util.Arrays;
import java.util.Scanner;

public class MinHeapImplmt {

    private static int[] convertminheap(int[] dizi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private static boolean minheap(int[] dizi) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

     private int[] Heap;
    private int index;
    private int size;

    public MinHeapImplmt(int size) {
        this.size = size;
        this.index = 0;
        Heap = new int[size];
    }

    private int root(int i) {
        return (i - 1) / 3;
    }

    private int L_Child(int i) {
        return (i * 3) + 1;
    }
    
    private int M_Child(int i) {
        return (i * 3) + 2;
    }

    private int R_Child(int i) {
        return (i * 3) + 3;
    }

    private boolean isLeaf(int i) {
        if (R_Child(i) >= size || L_Child(i) >= size || M_Child(i)>= size) {
            return true;
        }
        return false;
    }

    public void ekleme(int element) {
        if (index >= size) {
            return;
        }
        Heap[index] = element;
        int current = index;

        while (Heap[current] < Heap[root(current)]) {
            swap(current, root(current));
            current = root(current);
        }
        index++;
    }

    

    private void minHeapify(int i) {
        // Düğüm kontrolü yapılır
        if (!isLeaf(i)) {
            
            if (Heap[i] > Heap[L_Child(i)] || Heap[i] > Heap[R_Child(i)] || Heap[i]>Heap[M_Child(i)]) {
                
                if (Heap[L_Child(i)] < Heap[R_Child(i)] && Heap[L_Child(i)] < Heap[M_Child(i)]) {
                    swap(i, L_Child(i));
                    minHeapify(L_Child(i));
                    
                } else if (Heap[R_Child(i)] < Heap[L_Child(i)] && Heap[R_Child(i)] < Heap[M_Child(i)]) {
                    swap(i, R_Child(i));
                    minHeapify(R_Child(i));
                    
                }else{
                    swap(i,M_Child(i));
                    minHeapify(M_Child(i));
                }
            }
        }
    }

    // min heap oluşturma
    
    public void minHeap() {
        for (int i = (index - 1 / 3); i >= 1; i--) {
            minHeapify(i);
        }
    }

       
    public void yazdir() {
        for (int i = 0; i < (index / 3); i++) {
            System.out.print("Root : " + Heap[i]);
            if (L_Child(i) < index) {
                System.out.print(" , Sol_Düğüm : " + Heap[L_Child(i)]);
            }
            if (M_Child(i) < index) {
                System.out.print(" , Ortanca_Düğüm :" + Heap[M_Child(i)]);
            }
            if (R_Child(i) < index) {
                System.out.print(" , Sağ_Düğüm :" + Heap[R_Child(i)]);
            }
            
            System.out.println();
        }
    }
    
    // Heap yapısına eklenirken swap işlemi
    
    private void swap(int x, int y) {
        int tmp;
        tmp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = tmp;
    }

    
    public static void main(String[] args) {
       
        int heapSize;
        
        Scanner sc= new Scanner(System.in);
        
        System.out.print("Boyutunu Giriniz: ");
        
        heapSize=sc.nextInt();
        
        MinHeapImplmt minHeap = new MinHeapImplmt(heapSize);
        
        int dizi[] = new int[heapSize];

        for (int i = 0; i < dizi.length; i++) {
            
            dizi[i] = sc.nextInt();
        }

        System.out.print("[");
        for (int s : dizi) {
            System.out.print(s + " , ");
        }
        System.out.print("]");
        
        if (minheap(dizi)) {
            System.out.println("Üçlü min heap");
        }else {
            System.out.println("Üçlü min heap değil");
            dizi = convertminheap(dizi);

            System.out.print("Üçlü min heap: ");
            for (int i = 0; i < dizi.length - 1; i++) {
                System.out.print(dizi[i] + ",");
            }
            System.out.print(dizi[heapSize - 1]);
            System.out.println();
        }
        
        
        for(int i=1;i<=heapSize;i++){
            System.out.print(i + ". değer: ");
            int data=sc.nextInt();
            minHeap.ekleme(data);
            
        }

        System.out.println("MinHeapImplmt : " + Arrays.toString(minHeap.Heap));
        minHeap.yazdir();
        
    }
    
}
