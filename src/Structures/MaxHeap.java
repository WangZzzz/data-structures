package Structures;
/*
 *	堆：一颗完全二叉树，书里面每个结点的子女和双亲结点的序号都可以根据当前结点的序号直接求出
 *	Parent(i) = i/2;
 *	Left(i) = 2 * i;
 *	Right(i) = 2 * i + 1;
 *	堆（heap）是完全二叉树，其元素的键值还满足下列性质：从根结点向叶结点的任何路径上的键时非递增的---！！堆性质
 *	每个完全二叉树都要到数组的自然映射，映射实际上是通过对二叉树的一次分层遍历得到的,在结果数组中，位于i处的
 *	父结点位于下标i/2处，子结点分别位于2i和2i+1处
 *
 *	完全二叉树与数组间的映射关系是双向的，如果要从数组元素构造对应的完全二叉树，首先将数组第一个元素映射为二叉树的根，
 *		然后按照分层遍历策略依次构造出整个二叉树，然后将数组下标i中的数据复制到第i个结点。
 *
 *	为了确定二叉树是否具有堆性质，可以先将他转换成二叉树，然后再验证每一条由根节点到叶的路径是否满足性质
 *	具备堆性质的数组是“部分排序的”，即数组中大部分键值大的元素都位于键值小的元素的前面，更准确的说，在数组中，每个堆路径子数组都是
 *	非递增排序的。
 *
 *	堆的插入：
 *	在向堆中插入新元素时，新元素总是插入到最下层，作为最右边的叶结点，然后将这个新元素进行适当的提升，使它不再比它的父结点大，这样堆的
 *		性质就得以维护了
 *	
 *	堆的删除：
 *		堆的删除总是从树根删除根元素，过程是：用堆的最后一个叶结点代替根节点，并将新的根结点不断下降，直至它不再比它的子结点小为止，堆的
 *		性质又得以保持。
 *	向堆中插入元素或者从堆中删除元素的时间复杂度是O(logn)
 */
public class MaxHeap {
	int[] heap;
	int heapsize;
	//构造函数
	public MaxHeap(int[] array){
		this.heap = array;
		this.heapsize = array.length;
	}
	
	public void BuildMaxHeap(){
		for(int i = heapsize/2 - 1; i >= 0; i--){
			Maxify(i);//依次向上将当前子树最大堆化
		}
	}
	//堆排序
	public void HeapSort(){
		for(int i = 0; i < heap.length; i ++){
			//执行n次，将每个当前最大的值放到末尾
			int tmp = heap[0];
			heap[0] = heap[heapsize - 1];
			heap[heapsize - 1] = tmp;
			heapsize--;
			Maxify(0);
		}
	}
	
	public void Maxify(int i){
		int l = Left(i);
		int r = Right(i);
		int largeset;
		
		if(l < heapsize && heap[l] > heap[i])
			largeset = l;
		else 
			largeset = i;
		
		if(r < heapsize && heap[r] > heap[largeset])
			largeset = r;
		if(largeset == i || largeset >= heapsize){
			//如果largest等于i说明i是最大元素，larges超出i的范围说明不存在比i结点大的子女
			return;
		}
		int tmp = heap[i];
		heap[i] = heap[largeset];
		heap[largeset] = tmp;
		Maxify(largeset);			
	}
	
	public void IncreaseValue(int i, int val){
		heap[i] = val;
		if(i >= heapsize || i <= 0 || heap[i] >= val){
			return;
		}
		int p =Parent(i);
		if(heap[p] >= val)
			return;
		heap[i] = heap[p];
		IncreaseValue(p, val);
	}
	
	private int Parent(int i){
		return (i-1)/2;
	}
	
	private int Left(int i){
		return 2*(i+1) - 1;
	}
	
	private int Right(int i){
		return 2*(i+1);
	}
}
