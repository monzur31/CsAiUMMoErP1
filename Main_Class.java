package Project_1_CIS_479;

import java.util.*;

public class Main_Class {

	public static void main(String[] args) {
		Map BFSmap = new Map();
		Operations.BFS(BFSmap);
		BFSmap.printMap("Breadth First Search");
		
		Operations.printBreakLine();
		Map DFSmap = new Map();
		Operations.DFS(DFSmap);
		DFSmap.printMap("Depth First Search");
		
		Operations.printBreakLine();
		Map UCSmap = new Map();
		Operations.UCS(UCSmap);
		UCSmap.printMap("Uniform-Cost Search");
		
		Operations.printBreakLine();
		Map GreedyMap = new Map();
		Operations.Greedy(GreedyMap);
		GreedyMap.printMap("Greedy Search");

		Operations.printBreakLine();
		Map AstarMap = new Map();
		Operations.Astar(AstarMap);
		AstarMap.printMap("A* Search");
	}
	

}

class Operations
{
	public static void printBreakLine()
	{
		System.out.println("________________________________________________");
	}

	public static void Astar(Map map)
	{
		int currentNumber=1;
		ArrayList<Node> priorityQueue = new ArrayList<Node>();
		priorityQueue.add(map.map[3][2]);
		map.map[3][2].visited=true;
		while(map.map[0][5].value.equals("[]"))
		{
			//debug just to see logic
//			for(int i=0;i<priorityQueue.size();i++)
//			{
//				System.out.print("("+priorityQueue.toArray(new Node[0])[i].value+")"+priorityQueue.toArray(new Node[0])[i].getManhattanDistanceFromPoint(0, 5)+"+"+priorityQueue.toArray(new Node[0])[i].cost+" ");
//			}
//			System.out.println("");
			Node nodeAdventuring = priorityQueue.remove(priorityQueue.indexOf(Collections.min(priorityQueue,new DistanceCostComp())));
			if(checkBound(nodeAdventuring.x,nodeAdventuring.y-1))
			{
				Node changeNode = map.map[nodeAdventuring.x][nodeAdventuring.y-1];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
					changeNode.value=String.format("%02d", currentNumber);
					changeNode.cost=(nodeAdventuring.cost+2);
					currentNumber++;
					priorityQueue.add(changeNode);
				}
			}
			if(checkBound(nodeAdventuring.x-1,nodeAdventuring.y))
			{
				Node changeNode = map.map[nodeAdventuring.x-1][nodeAdventuring.y];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
					changeNode.value=String.format("%02d", currentNumber);
					changeNode.cost=(nodeAdventuring.cost+1);
					currentNumber++;
					priorityQueue.add(changeNode);
				}
			}
			if(checkBound(nodeAdventuring.x,nodeAdventuring.y+1))
			{
				Node changeNode = map.map[nodeAdventuring.x][nodeAdventuring.y+1];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
					changeNode.value=String.format("%02d", currentNumber);
					changeNode.cost=(nodeAdventuring.cost+2);
					currentNumber++;
					priorityQueue.add(changeNode);
				}
			}
			if(checkBound(nodeAdventuring.x+1,nodeAdventuring.y))
			{
				Node changeNode = map.map[nodeAdventuring.x+1][nodeAdventuring.y];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
					changeNode.value=String.format("%02d", currentNumber);
					changeNode.cost=(nodeAdventuring.cost+3);
					currentNumber++;
					priorityQueue.add(changeNode);
				}
			}
		}
	}
	public static void Greedy(Map map)
	{
		int currentNumber=1;
		ArrayList<Node> priorityQueue = new ArrayList<Node>();
		priorityQueue.add(map.map[3][2]);
		map.map[3][2].visited=true;
		while(map.map[0][5].value.equals("[]"))
		{
			//debug just to see logic
//			for(int i=0;i<priorityQueue.size();i++)
//			{
//				System.out.print("("+priorityQueue.toArray(new Node[0])[i].value+")"+priorityQueue.toArray(new Node[0])[i].getManhattanDistanceFromPoint(0, 5)+" ");
//			}
//			System.out.println("");
			Node nodeAdventuring = priorityQueue.remove(priorityQueue.indexOf(Collections.min(priorityQueue,new DistanceComp())));
			if(checkBound(nodeAdventuring.x,nodeAdventuring.y-1))
			{
				Node changeNode = map.map[nodeAdventuring.x][nodeAdventuring.y-1];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
				changeNode.value=String.format("%02d", currentNumber);
				changeNode.cost=(nodeAdventuring.cost+2);
				currentNumber++;
				priorityQueue.add(changeNode);
				}
			}
			if(checkBound(nodeAdventuring.x-1,nodeAdventuring.y))
			{
				Node changeNode = map.map[nodeAdventuring.x-1][nodeAdventuring.y];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
				changeNode.value=String.format("%02d", currentNumber);
				changeNode.cost=(nodeAdventuring.cost+1);
				currentNumber++;
				priorityQueue.add(changeNode);
				}
			}
			if(checkBound(nodeAdventuring.x,nodeAdventuring.y+1))
			{
				Node changeNode = map.map[nodeAdventuring.x][nodeAdventuring.y+1];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
				changeNode.value=String.format("%02d", currentNumber);
				changeNode.cost=(nodeAdventuring.cost+2);
				currentNumber++;
				priorityQueue.add(changeNode);
				}
			}
			if(checkBound(nodeAdventuring.x+1,nodeAdventuring.y))
			{
				Node changeNode = map.map[nodeAdventuring.x+1][nodeAdventuring.y];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
				changeNode.value=String.format("%02d", currentNumber);
				changeNode.cost=(nodeAdventuring.cost+3);
				currentNumber++;
				priorityQueue.add(changeNode);
				}
			}
		}
	}
	public static void UCS(Map map)
	{
		int currentNumber=1;
		ArrayList<Node> priorityQueue = new ArrayList<Node>();
		priorityQueue.add(map.map[3][2]);
		map.map[3][2].visited=true;
		while(map.map[0][5].value.equals("[]"))
		{
			Node nodeAdventuring = priorityQueue.remove(priorityQueue.indexOf(Collections.min(priorityQueue,new CostComp())));
			if(checkBound(nodeAdventuring.x,nodeAdventuring.y-1))
			{
				Node changeNode = map.map[nodeAdventuring.x][nodeAdventuring.y-1];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
				changeNode.value=String.format("%02d", currentNumber);
				changeNode.cost=(nodeAdventuring.cost+2);
				currentNumber++;
				priorityQueue.add(changeNode);
				}
			}
			if(checkBound(nodeAdventuring.x-1,nodeAdventuring.y))
			{
				Node changeNode = map.map[nodeAdventuring.x-1][nodeAdventuring.y];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
				changeNode.value=String.format("%02d", currentNumber);
				changeNode.cost=(nodeAdventuring.cost+1);
				currentNumber++;
				priorityQueue.add(changeNode);
				}
			}
			if(checkBound(nodeAdventuring.x,nodeAdventuring.y+1))
			{
				Node changeNode = map.map[nodeAdventuring.x][nodeAdventuring.y+1];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
				changeNode.value=String.format("%02d", currentNumber);
				changeNode.cost=(nodeAdventuring.cost+2);
				currentNumber++;
				priorityQueue.add(changeNode);
				}
			}
			if(checkBound(nodeAdventuring.x+1,nodeAdventuring.y))
			{
				Node changeNode = map.map[nodeAdventuring.x+1][nodeAdventuring.y];
				if(changeNode.value.equals("[]") && !changeNode.visited)
				{
				changeNode.value=String.format("%02d", currentNumber);
				changeNode.cost=(nodeAdventuring.cost+3);
				currentNumber++;
				priorityQueue.add(changeNode);
				}
			}
		}
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

class DistanceCostComp implements Comparator<Node>
{

	@Override
	public int compare(Node s1, Node s2) {
		return (s1.getManhattanDistanceFromPoint(0, 5)+s1.cost)-(s2.getManhattanDistanceFromPoint(0, 5)+s2.cost);
	}
}
class DistanceComp implements Comparator<Node>
{

	@Override
	public int compare(Node s1, Node s2) {
		return s1.getManhattanDistanceFromPoint(0, 5)-s2.getManhattanDistanceFromPoint(0, 5);
	}
}
class CostComp implements Comparator<Node>
{
	@Override
	public int compare(Node s1, Node s2) {
		return s1.cost-s2.cost;
	}
}
class Node
{
	public String value;
	public int x;
	public int y;
	public int cost;
	public Boolean visited;
	public Node(int x, int y)
	{
		this.value="[]";
		this.visited=false;
		this.x=x;
		this.y=y;
		this.cost=0;
	}
	public int getManhattanDistanceFromPoint(int x, int y)
	{
		int manHattanDistance =0;
		int xDistance = this.x-x;
		int yDistance = this.y-y;
		if(yDistance!=0)
		{
			manHattanDistance += (Math.abs(yDistance)*2);
		}
		if(xDistance>0)
		{
			manHattanDistance += (Math.abs(xDistance)*1);
		}
		if(xDistance<0)
		{
			manHattanDistance += (Math.abs(xDistance)*3);
		}
		return manHattanDistance;
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
