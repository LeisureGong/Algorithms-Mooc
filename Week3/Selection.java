import edu.princeton.cs.algs4.StdIn;

public class Selection {
    public static void sort(Comparable[] a){

        int N = a.length;   //数组长度

        for(int i = 0;i < N;i++){
            int min = i;
            for(int j = i+1;j < N;j++)
                if(less(a[j],a[min]))
                    min = j;
            exch(a,i,min);
        }
    }


    //判断 v < w?
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }


    //交换a[i]和a[j]
    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //打印数组a中的内容
    private static void show(Comparable[] a){
        for(int i = 0;i < a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    //测试数组a中的元素是否有序
    public static boolean isSorted(Comparable[] a){
        for(int i = 1;i < a.length;i++)
            if(less(a[i],a[i-1]))
                return false;
        return true;
    }

    public static void main(String[] args){
        //读入文件中的内容
        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
