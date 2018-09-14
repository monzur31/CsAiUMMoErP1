package Project_1_CIS_479;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main_Class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map BFSmap = new Map();
		Operations.BFS(BFSmap);
		BFSmap.printMap("Breadth First Search");
		Operations.printBreakLine();
		Map DFSmap= new Map();
		Operations.DFS(DFSmap);
		DFSmap.printMap("Depth First Search");
		
	}
	

}

class Operations
{
	public static void printBreakLine()
	{
		System.out.println("________________________________________________");
	}
	public static void BFS(Map map)
	{
		int currentNumber = 1;
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(map.map[3][2]);
		map.map[3][2].visited=true;
		while(map.map[0][5].value.equals("[]"))
		{
			Node nodeAdventuring = queue.remove();
			if(checkBound(nodeAdventuring.x,nodeAdventuring.y-1))
			{
				Node changeNode = map.map[nodeAdventuring.x][nodeAdventuring.y-1];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
				changeNode.value=String.format("%02d", currentNumber);
				currentNumber++;
				queue.add(changeNode);
				}
			}
			if(checkBound(nodeAdventuring.x-1,nodeAdventuring.y))
			{
				Node changeNode = map.map[nodeAdventuring.x-1][nodeAdventuring.y];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
				changeNode.value=String.format("%02d", currentNumber);
				currentNumber++;
				queue.add(changeNode);
				}
			}
			if(checkBound(nodeAdventuring.x,nodeAdventuring.y+1))
			{
				Node changeNode = map.map[nodeAdventuring.x][nodeAdventuring.y+1];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
				changeNode.value=String.format("%02d", currentNumber);
				currentNumber++;
				queue.add(changeNode);
				}
			}
			if(checkBound(nodeAdventuring.x+1,nodeAdventuring.y))
			{
				Node changeNode = map.map[nodeAdventuring.x+1][nodeAdventuring.y];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
				changeNode.value=String.format("%02d", currentNumber);
				currentNumber++;
				queue.add(changeNode);
				}
			}
		}	
	}
	public static void DFS(Map map)
	{
		int currentNumber = 1;
		Stack<Node> stack = new Stack<Node>();
		stack.push(map.map[3][2]);
		map.map[3][2].visited=true;
		while(map.map[0][5].value.equals("[]"))
		{
			Node nodeAdventuring = stack.pop();
			if(checkBound(nodeAdventuring.x,nodeAdventuring.y-1))
			{
				Node changeNode = map.map[nodeAdventuring.x][nodeAdventuring.y-1];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
				changeNode.value=String.format("%02d", currentNumber);
				currentNumber++;
				stack.push(changeNode);
				}
			}
			if(checkBound(nodeAdventuring.x-1,nodeAdventuring.y))
			{
				Node changeNode = map.map[nodeAdventuring.x-1][nodeAdventuring.y];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
				changeNode.value=String.format("%02d", currentNumber);
				currentNumber++;
				stack.push(changeNode);
				}
			}
			if(checkBound(nodeAdventuring.x,nodeAdventuring.y+1))
			{
				Node changeNode = map.map[nodeAdventuring.x][nodeAdventuring.y+1];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
				changeNode.value=String.format("%02d", currentNumber);
				currentNumber++;
				stack.push(changeNode);
				}
			}
			if(checkBound(nodeAdventuring.x+1,nodeAdventuring.y))
			{
				Node changeNode = map.map[nodeAdventuring.x+1][nodeAdventuring.y];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
				changeNode.value=String.format("%02d", currentNumber);
				currentNumber++;
				stack.push(changeNode);
				}
			}
		}
	}
	
	private static Boolean checkBound(int x,int y)
	{
		if(x<0||x>5||y<0||y>5)
		{
			return false;
		}
		return true;
	}
}
class Node
{
	public String value;
	public int x;
	public int y;
	public Boolean visited;
	public Node(int x, int y)
	{
		this.value="[]";
		this.visited=false;
		this.x=x;
		this.y=y;
	}
}
class Map {
	Node[][] map;
	public Map()
	{
		map = new Node[6][6];
		for(int i=0;i<6;i++)
		{
			for (int j=0;j<6;j++)
			{
				this.map[i][j]=new Node(i,j);
			}
		}
		this.map[1][1].value="##";
		this.map[1][2].value="##";
		this.map[1][3].value="##";
		this.map[1][4].value="##";
		this.map[2][4].value="##";
		this.map[3][4].value="##";
		this.map[3][2].value="00";
		
	}
	public void printMap(String operationDone)
	{
		System.out.println(operationDone);
		for(int i=0;i<6;i++)
		{
			for (int j=0;j<6;j++)
			{
				System.out.print(this.map[i][j].value+" ");
			}
			System.out.println("");
		}
	}
}
