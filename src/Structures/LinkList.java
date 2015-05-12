package Structures;
/*
 * ��������
 */
public class LinkList<T> 
{
	private Node<T> head;//ͷ���
	private int count = 0;//�ڵ�����
	class Node<T>{
		private T t;
		public Node<T> next;
		public Node(T t)
		{
			this.t = t;
		}
		public T getT() {
			return t;
		}
		public void setT(T t) {
			this.t = t;
		}		
	}
	
	public LinkList(){
		head = null;
	}
	
	//��ͷ���ǰ�����ڵ�
	public void addFirstNode(T t)
	{
		Node<T> node = new Node<T>(t);
		node.next = head;
		head = node;
		count++;		
	}
	
	//ɾ��ͷ��㣬������
	public Node<T> deleteFirstNode()
	{
		if(head == null){
			return null;
		}
		Node<T> tmpNode = head;
		head = head.next;
		count--;
		return tmpNode;
	}
	
	//��ָ��λ�ò���ڵ�
	public void addByIndex(int index, T t)
	{
		if(index < 0 || index > count-1)
		{
			throw new IndexOutOfBoundsException("����Խ��");
		}
		if(index == 0){
			addFirstNode(t);
		}
		Node<T> node = new Node<T>(t);
		Node<T> current = head;
		Node<T> previous = head;
		int tmp = 0;
		while(tmp != index)
		{
			previous = current;
			current = current.next;
			tmp++;
		}
		previous.next = node;
		node.next = current;
		count++;
	}
	
	//ɾ��ָ��λ�õĽڵ�
	public Node<T> deleteByIndex(int index)
	{
		if(index < 0 || index > count-1)
		{
			throw new IndexOutOfBoundsException("ɾ��Խ��");
		}
		int tmp = 0;
		Node<T> current = head;//ָ��ǰ�ڵ�
		Node<T> previous = head;//ָ��ǰ�ڵ��ǰһ���ڵ�
		while(tmp != index)
		{
			previous = current;
			current = current.next;
			tmp++;
		}
		previous.next = current.next;
		count--;
		return current;
	}
	
	//�����������ҽڵ�
	public Node<T> findByIndex(int index)
	{
		if(index < 0 || index > count-1)
		{
			throw new IndexOutOfBoundsException("ɾ��Խ��");
		}
		int tmp = 0;
		Node<T> current = head;
		while(tmp != index)
		{
			current = current.next;
			tmp++;
		}
		return current;
	}
	
	//�������ݲ��ҽڵ������ֵ
	public int IndexOf(T t)
	{
		Node<T> current = head;
		int index = 0;
		while(current.getT() != t)
		{
			if(current.next == null)
			{
				return -1;//���ҵ����һ���ڵ㣬û�в��ҵ����ݣ�����-1
			}
			current = current.next;
			index++;			
		}
		return index;
	}
	
	//��ʾ���нڵ�
	public void displayAllNodes()
	{
		Node<T> current = head;
		while(true)
		{
			System.out.println(current.getT());
			if(current.next == null){
				//���һ���ڵ���
				break;
			}
			current = current.next;
		}
	}
}
