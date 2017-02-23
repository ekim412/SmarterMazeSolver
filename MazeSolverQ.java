import java.io.IOException;

/**
 * MazeSolverQ is the main class that solves the maze with the A* search algorithm.
 * It will print if the end was found or not, number of steps to get to the end,
 * a string representation of the queue including priorities and number of steps 
 * taken. 
 * 
 * @author Edward Kim
 *
 */

public class MazeSolverQ {
	
	public static void main(String[]args) throws InterruptedException{
		
		try{
			if(args.length<1){
				throw new IllegalArgumentException("No maze provided");
			}
			//Read the .txt file and create a Maze object
			String mazeFileName = args[0];
			Maze mazeObj = new Maze(mazeFileName);
							
			boolean endFound = false;		//false until the end is found
			int stepsToEnd = 0;
			int stepsTaken = 0;				//total steps taken counter
			double priority;				//the A* function
			
			//Create Hexagon and start hexagon tile
			Hexagon startH = mazeObj.getStart();
			startH.setSteps(0);
			Hexagon currentH = startH;
			mazeObj.repaint();
			
			//Create LinkedPriorityQueue object.
			PriorityQueueADT<Hexagon> linkedPQObject = new LinkedPriorityQueue<Hexagon>();
			
			//Make use of A* algorithm. fx is priority, gx is distance from start and
			//hx is distance to end. Compute fx = gx + hx. Since the smaller the priority
			//value means it's more important, make the (gx + hx) negative. 
			priority = -(startH.getSteps() + startH.distanceToEnd(mazeObj));
			//Enqueue accounting for the priority.
			linkedPQObject.enqueue(startH, priority);
			mazeObj.repaint();
			
			//While the queue is not empty.
			while(!linkedPQObject.isEmpty()){
				//Dequeue and set tile as current for now.
				currentH = linkedPQObject.dequeue();
				currentH.setCurrent();
				
							
				//If this is the end of the queue, setFinished and break.
				if(currentH.isEnd()){
					currentH.setFinished();
					mazeObj.repaint();
					endFound = true;
					stepsTaken++;
					break;
				}
				//If this is not the end of the queue...
				else{
					//If this is the start tile, setStarted.
					if(currentH.isStart()){
						currentH.setStarted();
						mazeObj.repaint();
						stepsTaken++;
					}
					//If it's not the start tile, set as dequeued.
					else {
						currentH.setDequeued();
						mazeObj.repaint();
						stepsTaken++;
					}
					//Check neighbours and enqueue with priority with Hexagon methods.
					for(int i = 0; i <= 5; i++){
						//Create hexagon object neighbourT for current hexagon's neighbour tiles.
						Hexagon neighbourT = currentH.getNeighbour(i);
						
						if(neighbourT == null){
							continue;
						}
						
						//If neighbourT is not null, not dequeued, not enqueued, not a wall then
						//enqueue this tile and set as enqueued while using priority..
						if(neighbourT != null && !neighbourT.isDequeued() && !neighbourT.isEnqueued()
								&& !neighbourT.isWall()){
							neighbourT.setEnqueued();
							priority = -(neighbourT.getSteps() + neighbourT.distanceToEnd(mazeObj));							
							linkedPQObject.enqueue(neighbourT, priority);
						}
						
					}
				}
			}
			//If end is not found print to let the user know.
			if(endFound == false){
				System.out.println("The end of the maze was not found.");
			}
			//For when end is found, also print
			else if(endFound == true){
				System.out.println("The end of the maze was found.");
				System.out.format("%.0f steps to the end.\n", startH.distanceToEnd(mazeObj));
			}
			//Print string representation of queue including priorities and number
			//of steps taken regardless of whether end was found or not.
			System.out.format("String Representation of the queue: \n%s", linkedPQObject.toString());
			System.out.format("%d steps were taken.", stepsTaken);
		}
		
		//Catch statements for IOException, EmptyCollection, IllegalArgument, UnknownMazeCharacter
		//and InvalidNeighbourIndex.
		catch(IOException e){
			System.out.println("Couldn't read the file or file was not found: " + e.getMessage());
		}
		catch(EmptyCollectionException f){
			System.out.println("Collection is empty : " + f.getMessage());
		}
		catch(IllegalArgumentException g){
			System.out.println("Illegal argument used: " + g.getMessage());
		}
		catch(UnknownMazeCharacterException h){
			System.out.println("Character from maze cannot be recognized: " + h.getMessage());
		}
		catch(InvalidNeighbourIndexException i){
			System.out.println("Invalid hexagon neighbour index used: " +i.getMessage());
		}
	}
	

	
}
