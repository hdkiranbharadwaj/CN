import java.util.*;
class vertex{
        int id;
        int dist;
}
public class dij{
        static int n,i,j,src,count=0;
        static int cost[][]=new int[10][10];
        static int d[]=new int[10];

        static int removed[]=new int[10];
        static int heapsize;

        static void swap(vertex a, vertex b)
        {
                vertex temp = new vertex();
                temp.id=a.id;
                temp.dist=a.dist;
                a.id=b.id;
                a.dist=b.dist;
                b.id=temp.id;
                b.dist = temp.dist;
        }
        static void heapify(vertex arr[], int n, int i)
        {
                int largest =i;
                int left = 2*i+1;
                int right = left +1;
                if(left <n&& arr[right].dist<arr[largest].dist)
                {
                        largest = left;
                }
                if(right<n&&arr[right].dist<arr[largest].dist)
                        largest = right;
                if(largest != i)
                {
                        swap(arr[i], arr[largest]);
                        heapify(arr,n,largest);
                }
        }
	static void heapSort(vertex arr[],int n)
        {
                for(int i=n/2-1;i>=0;i--)
                {
                        heapify(arr,n,i);
                }
        }
        static void makegraph()
        {
                System.out.println("Enter the number of vertices:");
                Scanner Sc = new Scanner(System.in);
                n=Sc.nextInt();
                System.out.println("Enter the cost matrix:");
                for(int i=0;i<n;i++)
                {
                        for(int j=0;j<n;j++)
                        {
                                cost[i][j]=Sc.nextInt();
                                if(cost[i][j]==0)
                                        cost[i][j]=9999;
                        }
                }
                System.out.println("Enter the source vertex:");
                src=Sc.nextInt();
                for(i =0;i<n;i++);
                        d[i]=9999;
                        removed[i]=0;
                d[src]=0;
        }
        static vertex deleteheap(vertex heap[])
        {
                vertex min=heap[0];
                heap[0]=heap[heapsize-1];
                heapsize--;
                return min;
        }
	public static void dijkstra(){
                vertex heap[]= new vertex[10];
                for(int i=0;i<n;i++)
                {
                        heap[i]=new vertex();
                        heap[i].id=i;
                        heap[i].dist=9999;
                }
                heap[src].dist = 0;
                heapsize=n;

                heapSort(heap, heapsize);
                while(count<n)
                {
                        vertex minvertex = deleteheap(heap);
                        int u = minvertex.id;
                        removed[u]=1;
                        count++;
                        for(int i=0;i<n;i++)
                        {
                                if(removed[i]==0&&cost[u][i]!=9999)
                                {       d[i]=(d[u]+cost[u][i]);
                                        for(int o=0;o<heapsize;o++)
                                        {
                                                if(heap[o].id==i)
                                                {
                                                        heap[o].dist = d[i];
                                                        break;
                                                }
                                        }
                                }
                        }
                heapSort(heap, heapsize);
                }
        }
	public static void main(String args[])
 {
         makegraph();
         dijkstra();
         System.out.println("Shortest path id "+src+" is :\n");
         for(int i=0;i<n;i++)
         {
                 if(src!=i)
                 {
                         System.out.print(src+"->"+i+"="+d[i]+"\n");
                }
        }
 }}
    
